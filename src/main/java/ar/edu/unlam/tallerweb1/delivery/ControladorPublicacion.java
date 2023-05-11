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

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPublicacion {
    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorPublicacion(ServicioPublicacion servicioPublicacion) {
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/ver-publicacion", method = RequestMethod.POST)
    public ModelAndView verPublicacion(@ModelAttribute("datosPublicacion") DatosPublicacion datosPublicacion, HttpServletRequest request) {
        ModelMap model = new ModelMap();

        Publicacion publicacionBuscada = servicioPublicacion.findPublicacion(datosPublicacion.getId());
        if (publicacionBuscada != null) {
            return new ModelAndView("redirect:/post-details");
        } else {
            model.put("error", "No se encuentra la publicación");
        }
        return new ModelAndView("index-misposts", model);
    }
}
