package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ControladorHome {

    private Usuario userAuth;
    private IServicioPublicacion servicioPublicacion;
    private IServicioAuth servicioAuth;

    @Autowired
    public void ControladorHome(IServicioPublicacion servicioPublicacion, IServicioAuth servicioAuth) {
        this.servicioPublicacion = servicioPublicacion;
        this.servicioAuth = servicioAuth;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home/feed");
    }

    @RequireAuth //! leeme e.e
    @RequestMapping(path = "/feed", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {

        Usuario userAuth = servicioAuth.getUsuarioAutenticado(); //leemeeee

        ModelMap model = new ModelMap();
        //solicitar publicaciones
        List<Publicacion> publicaciones = servicioPublicacion.listarPublicaciones();

        model.addAttribute("usuario", userAuth);
        model.addAttribute("publicaciones", publicaciones);
        return new ModelAndView("index-feed", model);

    }
}
