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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
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

    private ModelMap iniciarModel(HttpSession session) {
        ModelMap m = new ModelMap();
        m.put("usuario", (Usuario) session.getAttribute("usuarioAutenticado"));
        return m;
    }

    @RequestMapping(path = "/crear", method = RequestMethod.GET)
    public ModelAndView crear(HttpSession session, HttpServletRequest request) {

        ModelMap model = this.iniciarModel(session);

        model.put("publicacionDto", new PublicacionDto());

        return new ModelAndView("new-post", model);
    }


    @RequestMapping(path = "/publicar", method = RequestMethod.POST)
    public ModelAndView guardarPublicacion(@ModelAttribute("publicacionDto") PublicacionDto publicacionDto, HttpSession session, HttpServletRequest request) {
        ModelMap model = this.iniciarModel(session);

        Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");

        Long p_id = servicioPublicacion.guardarPublicacion(publicacionDto);

        if(p_id == null) {
            model.put("error", this.servicioPublicacion.getErrorMessage());
            return new ModelAndView("new-post",model);
        }

        return new ModelAndView("redirect: " + request.getContextPath() + "/home/mispublicaciones?pid=" + p_id);


    }






}
