package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping( path = "/mensaje")
public class ControladorMensajes {

    private final IServicioMensajes servicioMensajes;
    private final IServicioAuth servicioAuth;

    @Autowired
    public ControladorMensajes(IServicioMensajes servicioMensajes, IServicioAuth servicioAuth){
        this.servicioMensajes = servicioMensajes;
        this.servicioAuth = servicioAuth;
    }

    @RequestMapping(path = "/enviar",method = RequestMethod.POST)
    public ModelAndView enviarMensaje(@ModelAttribute MensajeDto mensajeDto, HttpServletRequest request){

       mensajeDto.setEmisor(this.servicioAuth.getUsuarioAutenticado());

       Long mid = this.servicioMensajes.enviarMensaje(mensajeDto);

       if (mid == null){
           return new ModelAndView("redirect: "  + request.getContextPath() + "/publicacion/ver?pid=" + mensajeDto.getPublicacion().getId() + "&msj_response=error");
       }

        return new ModelAndView("redirect: "  + request.getContextPath() + "/publicacion/ver?pid=" + mensajeDto.getPublicacion().getId() + "&msj_response=success");

    }

    @RequestMapping(path = "/responder",method = RequestMethod.POST)
    public ModelAndView responderMensaje(@ModelAttribute MensajeDto mensajeDto, HttpServletRequest request){

        try{

            this.servicioMensajes.responderMensaje(mensajeDto);

        }catch (PersistenceException err){
            return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + mensajeDto.getPublicacion().getId() +"&response=error");
        }

        return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + mensajeDto.getPublicacion().getId() + "&response=success");
    }

    @RequestMapping(path = "/eliminar",method = RequestMethod.GET)
    public ModelAndView responderMensaje(@RequestParam Long idm, Long pid, HttpServletRequest request){

        try{

            this.servicioMensajes.eliminarRespuesta(idm);

        }catch (PersistenceException err){
            return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + pid +"&response=error");
        }

        return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + pid + "&response=deleted");
    }
}
