package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.model.Imagen;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/archivo")
public class ControladorArchivo {

    private IServicioArchivo servicioArchivo;

    @Autowired
    public ControladorArchivo(IServicioArchivo servicioArchivo){
        this.servicioArchivo = servicioArchivo;
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
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

        Publicacion post = new Publicacion();
        post.setId(10L);


        int subidos = this.servicioArchivo.subirImagenesPost(datosArchivo.getImages(), post);

        model.put("success_multi", subidos);
        return new ModelAndView("test-file", model);
    }

    @RequestMapping(path = "/eliminar/fileid/{id}", method = RequestMethod.GET)
    public ModelAndView eliminar(@PathVariable Long id){

        this.servicioArchivo.eliminarImagenPost(id);
        return new ModelAndView("redirect: /archivo/test");
    }



}
