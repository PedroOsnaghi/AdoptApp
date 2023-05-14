package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/publicacion")
public class ControladorPublicacion {

    private IServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorPublicacion(IServicioPublicacion servicioPublicacion) {
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/crear-publicacion", method = RequestMethod.POST)
    public ModelAndView guardarPublicacion(@ModelAttribute("publicacion") DatosPublicacion datosPublicacion, HttpSession session) {
        ModelMap model = new ModelMap();

        Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

        try{
            Publicacion publicacion = new Publicacion();

            publicacion.setTitulo(datosPublicacion.getTitulo());
            publicacion.setCuerpo(datosPublicacion.getCuerpo());
           // publicacion.setAutorId(usuario.getId());
            publicacion.setMascotaId(datosPublicacion.getMascotaId());
            publicacion.setFechaCreacion(datosPublicacion.getFechaCreacion());

            servicioPublicacion.guardarPublicacion(publicacion);
        } catch (Exception e) {
            model.put("error", "No se pudo guardar la publicacion");
        }

        model.put("publicacion", datosPublicacion);
        return new ModelAndView("index-feed", model);
    }

    @RequestMapping(path = "/publicaciones-feed", method = RequestMethod.GET)
    public ModelAndView verPublicacionesFeed() {
        ModelMap model = new ModelMap();

        List<Publicacion> publicaciones = servicioPublicacion.listarPublicaciones();

        model.put("publicaciones", publicaciones);

        return new ModelAndView("index-feed", model);
    }

    @RequestMapping(path = "/mis-publicaciones", method = RequestMethod.GET)
    public ModelAndView verPublicacionesPorUsuarioId(@ModelAttribute("datosPublicacion") DatosPublicacion datosPublicacion) {
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = null;

        try {
            publicaciones = servicioPublicacion.listarPublicacionesPorUsuarioId(datosPublicacion.getAutorId());
        } catch (Exception e) {
            model.put("error", "No se encontraron publicaciones");
        }

        model.put("publicaciones", publicaciones);
        return new ModelAndView("index-misposts", model);
    }
    @RequestMapping(path = "/crear", method = RequestMethod.GET)
    public ModelAndView crear(HttpSession session) {

        return new ModelAndView("new-post");
    }


}
