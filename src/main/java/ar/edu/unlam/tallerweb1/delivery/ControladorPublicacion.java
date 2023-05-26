package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/publicacion")
public class ControladorPublicacion {

    private final IServicioAuth servicioAuth;
    private final IServicioPublicacion servicioPublicacion;
    private final IServicioMascota servicioMascota;

    private Usuario userAuth;

    @Autowired
    public ControladorPublicacion(IServicioPublicacion servicioPublicacion, IServicioMascota servicioMascota, IServicioAuth servicioAuth) {
        this.servicioPublicacion = servicioPublicacion;
        this.servicioAuth = servicioAuth;
        this.servicioMascota = servicioMascota;
    }

    private ModelMap iniciarModel() {
        this.userAuth = this.servicioAuth.getUsuarioAutenticado();
        ModelMap m = new ModelMap();
        m.put("usuario", this.userAuth);
        return m;
    }

    @RequestMapping(path = "/crear", method = RequestMethod.GET)
    public ModelAndView crear() {

        ModelMap model = this.iniciarModel();


        model.put("publicacionDto", new PublicacionDto());
        model.put("mascotas", this.servicioMascota.listarMascotasAPublicar(this.userAuth));

        return new ModelAndView("new-post", model);
    }


    @RequestMapping(path = "/publicar", method = RequestMethod.POST)
    public ModelAndView guardarPublicacion(@ModelAttribute("publicacionDto") PublicacionDto publicacionDto, HttpServletRequest request) {
        ModelMap model = this.iniciarModel();

        Long p_id = servicioPublicacion.guardarPublicacion(publicacionDto);

        if(p_id == null) {
            model.put("error", this.servicioPublicacion.getErrorMessage());
            return new ModelAndView("new-post",model);
        }

        return new ModelAndView("redirect: " + request.getContextPath() + "/home/mispublicaciones?pid=" + p_id);


    }







}
