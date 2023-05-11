package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorPublicacion {

    @Autowired
    private IServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorPublicacion(ServicioPublicacion servicioPublicacion) {
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/ver-publicaciones", method = RequestMethod.GET)
    public ModelAndView verPublicaciones(HttpServletRequest request) {
        ModelMap model = new ModelMap();

        List<Publicacion> publicaciones = servicioPublicacion.listarPublicacionesPorUsuarioId((Long) request.getSession().getAttribute("idUsuario"));
        if (publicaciones != null && !publicaciones.isEmpty()) {
            model.put("publicaciones", publicaciones);
            return new ModelAndView("index-misposts", model);
        } else {
            model.put("error", "No se encontraron publicaciones");
            return new ModelAndView("index-feed", model);
        }
    }
}
