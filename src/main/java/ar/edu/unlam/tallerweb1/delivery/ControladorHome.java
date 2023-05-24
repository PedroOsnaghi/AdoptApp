package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Imagen;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void ControladorHome(IServicioPublicacion servicioPublicacion, IServicioAuth servicioAuth){
        this.servicioPublicacion = servicioPublicacion;
        this.servicioAuth = servicioAuth;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home/feed");
    }

    @RequestMapping(path = "/feed",method = RequestMethod.GET)
    public ModelAndView feed() {

        userAuth = this.servicioAuth.getUsuarioAutenticado();

        if(userAuth != null){
            ModelMap model = new ModelMap();
            //solicitar publicaciones
            List<Publicacion> publicaciones = servicioPublicacion.listarPublicacionesDisponibles();


            model.put("target","feed");
            model.put("usuario", userAuth);
            model.put("publicaciones", publicaciones);
            return new ModelAndView("index-feed",model);
        }

        return new ModelAndView("redirect:/login");

    }

    @RequestMapping(path = "/favoritos",method = RequestMethod.GET)
    public ModelAndView favoritos(HttpSession session) {

        userAuth = this.servicioAuth.getUsuarioAutenticado();

        if(userAuth != null){
            ModelMap model = new ModelMap();
            //solicitar publicaciones
            List<Publicacion> publicaciones = servicioPublicacion.listarPublicacionesDisponibles();


            model.put("target","favoritos");
            model.put("usuario", userAuth);
            model.put("publicaciones", publicaciones);
            return new ModelAndView("index-favorites",model);
        }

        return new ModelAndView("redirect:/login");

    }

    @RequestMapping(path = "/mispublicaciones",method = RequestMethod.GET)
    public ModelAndView misPublicaciones(@RequestParam(required = false) String pid, HttpSession session) {

        userAuth = this.servicioAuth.getUsuarioAutenticado();

        if(userAuth != null){
            ModelMap model = new ModelMap();
            //solicitar publicaciones
            List<Publicacion> publicaciones = servicioPublicacion.listarPublicacionesPorUsuarioId(userAuth.getId());

            model.put("loader", pid);
            model.put("target","mispublicaciones");
            model.put("usuario", userAuth);
            model.put("publicaciones", publicaciones);
            return new ModelAndView("index-misposts",model);
        }

        return new ModelAndView("redirect:/login");

    }
}
