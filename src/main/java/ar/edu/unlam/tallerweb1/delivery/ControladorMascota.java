package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.delivery.dto.MascotaDto;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioSesion;
import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mascota")
public class ControladorMascota {

    private final IServicioAuth servicioAuth;
    private final IServicioSesion servicioSesion;

    @Autowired
    private IServicioMascota servicioMascota;

    @Autowired
    public ControladorMascota(IServicioMascota servicioMascota, IServicioAuth Auth, IServicioSesion servicioSesion) {
        this.servicioMascota = servicioMascota;
        this.servicioAuth = Auth;
        this.servicioSesion = servicioSesion;
    }

    private ModelMap iniciarModel() {
        ModelMap m = new ModelMap();
        m.put("usuario", this.servicioAuth.getUsuarioAutenticado());
        return m;
    }

    @RequireAuth
    @RequestMapping("/crear")
    public ModelAndView crearMascota(@RequestParam(required = false) String target) {

        ModelMap modelo = this.iniciarModel();

        this.servicioSesion.setAtributoEnSesion("target", target);

        modelo.put("mascotaDto", new MascotaDto());
        modelo.put("target", target);

        return new ModelAndView("new-mascot", modelo);
    }


    @RequireAuth
    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ModelAndView guardarMascota(@ModelAttribute MascotaDto mascotaDto, HttpServletRequest request) {

        String target = "";

        ModelMap model = this.iniciarModel();

        Usuario usuario = this.servicioAuth.getUsuarioAutenticado();

        try {
            this.servicioMascota.guardar(mascotaDto, usuario);
        }catch (MaxUploadSizeExceededException error){
            model.put("error", error.getMessage());
            return new ModelAndView("new-mascot", model);
        }


        if (servicioSesion.getAtributoDeSesion("target") != null)
            target = (String) servicioSesion.getAtributoDeSesion("target");

        switch (target) {
            case "publicacion":
                return new ModelAndView("redirect: " + request.getContextPath() + "/publicacion/crear");

            case "perfil":
                return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/actividad/mascotas");

            default:
                return new ModelAndView("redirect: " + request.getContextPath() + "/home/feed");

        }


    }


}
