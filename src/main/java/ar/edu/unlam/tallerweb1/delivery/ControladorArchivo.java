package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.put("datosArchivo", new DatosArchivo());
        return new ModelAndView("test-file", model);
    }

    @RequestMapping(path = "/subir", method = RequestMethod.POST)
    public ModelAndView upload_single(@ModelAttribute("datosArchivo") DatosArchivo datosArchivo) {
        ModelMap model = new ModelMap();


       String nombre_archivo_subido = this.servicioArchivo.subirAvatarUsuario(datosArchivo.getImagen());

        model.put("success-single", nombre_archivo_subido);
        return new ModelAndView("test-file", model);
    }

    @RequestMapping(path = "/subir-multiple", method = RequestMethod.POST)
    public ModelAndView upload_multiple(@ModelAttribute("datosArchivo") DatosArchivo datosArchivo) {
        ModelMap model = new ModelMap();


        int subidos = this.servicioArchivo.subirImagenesPost(datosArchivo.getImages());

        model.put("success_multi", subidos);
        return new ModelAndView("test-file", model);
    }



}
