package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequireAuth
    @RequestMapping(path = "/eliminar")
    public ModelAndView eliminar(@RequestParam Long id, Long pid, @RequestParam(required = false) String target, HttpServletRequest request){

        this.servicioArchivo.eliminarImagenPost(id);

        switch (target) {
            case "p_edit":
                return new ModelAndView("redirect: " + request.getContextPath() + "/publicacion/editar?pid=" + pid);

            default:
                return new ModelAndView("redirect: " + request.getContextPath() + "/home/feed");

        }

    }


}
