package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Imagen;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion_favorito;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class ControladorHome {

    private Usuario userAuth;
    private IServicioPublicacion servicioPublicacion;
    private IServicioAuth servicioAuth;


    @Autowired
    public ControladorHome(IServicioPublicacion servicioPublicacion, IServicioAuth servicioAuth){

        this.servicioPublicacion = servicioPublicacion;

        this.servicioAuth = servicioAuth;

    }

    private ModelMap iniciarModel(){
        this.userAuth = this.servicioAuth.getUsuarioAutenticado();

        ModelMap m = new ModelMap();

        m.put("usuario", this.userAuth);

        return m;
    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home/feed");
    }

    @RequireAuth
    @RequestMapping(path = "/feed",method = RequestMethod.GET)
    public ModelAndView feed(@RequestParam(required = false) String response ) {

        ModelMap model = iniciarModel();

        //solicitar publicaciones
        List<Publicacion> publicaciones = servicioPublicacion.listarPublicacionesDisponibles();

        model.put("target","feed");
        model.put("publicaciones", publicaciones);
        model.put("response_f", response);

        return new ModelAndView("index-feed",model);


    }

    @RequireAuth
    @RequestMapping(path = "/favoritos",method = RequestMethod.GET)
    public ModelAndView favoritos(@RequestParam(required = false)String response) {

        ModelMap model = iniciarModel();

        //solicitar publicaciones
        List<Publicacion_favorito> favoritos = servicioPublicacion.listarFavoritosDeUsuario(userAuth.getId());

        model.put("target","favoritos");
        model.put("publicaciones", favoritos);
        model.put("response_f", response);
        return new ModelAndView("index-favorites",model);


    }

    @RequireAuth
    @RequestMapping(path = "/mispublicaciones",method = RequestMethod.GET)
    public ModelAndView misPublicaciones(@RequestParam(required = false) String pid) {

        ModelMap model = iniciarModel();

        //solicitar publicaciones
        List<Publicacion> publicaciones = servicioPublicacion.listarPublicacionesPorUsuarioId(userAuth.getId());

        model.put("loader", pid);
        model.put("target","mispublicaciones");
        model.put("publicaciones", publicaciones);

        return new ModelAndView("index-misposts",model);


    }

    @RequestMapping(path = "/favoritos/agregar")
    public ModelAndView agregarFavorito(@RequestParam Long pid) {

        String response;

        try{

            this.servicioPublicacion.agregarFavorito(pid, this.servicioAuth.getUsuarioAutenticado());
            response = "success";

        }catch (PersistenceException err){
            System.out.println(err.getMessage());
            response = "exist";

        }

        return this.feed(response);

    }

    @RequestMapping(path = "/favoritos/eliminar")
    public ModelAndView eliminarFavorito(@RequestParam Long pid, @RequestParam(required = false) String target) {

        this.servicioPublicacion.eliminarFavorito(pid, this.servicioAuth.getUsuarioAutenticado());

        String response = "removed";

        return this.favoritos(response);

    }


}
