package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorPublicacion {

    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorPublicacion(ServicioPublicacion servicioPublicacion) {
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/publicaciones-feed", method = RequestMethod.GET)
    public ModelAndView verPublicacionesFeed() {
        ModelMap model = new ModelMap();
        List<Publicacion> publicaciones = null;

        try {
            publicaciones = servicioPublicacion.listarPublicaciones();
        } catch (Exception e) {
            model.put("error", "No se encontraron publicaciones");
        }

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
}
