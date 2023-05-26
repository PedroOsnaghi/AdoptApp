package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mascota")
public class ControladorMascota {

    private final IServicioAuth servicioAuth;

    @Autowired
    private IServicioMascota servicioMascota;
    @Autowired
    public ControladorMascota(IServicioMascota servicioMascota, IServicioAuth Auth)
    {
        this.servicioMascota = servicioMascota;
        this.servicioAuth = Auth;
    }

    private ModelMap iniciarModel() {
        ModelMap m = new ModelMap();
        m.put("usuario", this.servicioAuth.getUsuarioAutenticado());
        return m;
    }

    @RequestMapping("/crear")
    public ModelAndView irANewMascot(@RequestParam(required = false) String target, HttpSession session) {

        ModelMap modelo = this.iniciarModel();

        session.setAttribute("target" ,target);

        modelo.put("mascotaDto",new MascotaDto());
        modelo.put("target",target);

        return new ModelAndView("new-mascot", modelo);
    }


    @RequestMapping(path = "/guardar", method=RequestMethod.POST)
    public ModelAndView ingresarMascota(@ModelAttribute MascotaDto mascotaDto, HttpSession session, HttpServletRequest request) {

        ModelMap model = this.iniciarModel();

        Usuario usuario = this.servicioAuth.getUsuarioAutenticado();

        Long p_id = this.servicioMascota.guardar(mascotaDto, usuario);

        if(p_id == null) {
            model.put("error", this.servicioMascota.getErrorMessage());
            return new ModelAndView("new-mascot",model);
        }

        String target = (String) session.getAttribute("target");

        switch (target){
            case "publicacion":
                return new ModelAndView("redirect: " + request.getContextPath() + "/publicacion/crear");

            case  "perfil":
                return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/actividad/mascotas");

            default:
                return new ModelAndView("redirect: " + request.getContextPath() + "/home/feed");

        }


    }


}
