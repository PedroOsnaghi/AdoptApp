package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorArchivo {

    private IServicioArchivo servicioArchivo;

    @Autowired
    public ControladorArchivo(IServicioArchivo servicioArchivo){
        this.servicioArchivo = servicioArchivo;
    }

    @RequestMapping(path = "/archivo", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelMap model = new ModelMap();
        model.put("testArchivo", new TestArchivo());
        return new ModelAndView("test-file", model);
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ModelAndView upload_single(@ModelAttribute("testArchivo") TestArchivo testArchivo, HttpServletRequest request) {
        ModelMap model = new ModelMap();

        this.servicioArchivo.subirAvatarUsuario(testArchivo.getImagen());

        model.put("error", "subido");
        return new ModelAndView("test-file", model);
    }


}
