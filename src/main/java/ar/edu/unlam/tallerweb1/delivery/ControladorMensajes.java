package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.exceptions.SendingMessageException;
import ar.edu.unlam.tallerweb1.domain.notificacion.IServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.enumerated.TipoNotificacion;
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
    private final IServicioPublicacion servicioPublicacion;
    private final IServicioNotificacion servicioNotificacion;

    @Autowired
    public ControladorMensajes(IServicioMensajes servicioMensajes, IServicioAuth servicioAuth, IServicioPublicacion servicioPublicacion, IServicioNotificacion servicioNotificacion){
        this.servicioMensajes = servicioMensajes;
        this.servicioAuth = servicioAuth;
        this.servicioPublicacion = servicioPublicacion;
        this.servicioNotificacion = servicioNotificacion;
    }

    @RequireAuth
    @RequestMapping(path = "/enviar",method = RequestMethod.POST)
    public ModelAndView enviarMensaje(@ModelAttribute MensajeDto mensajeDto, HttpServletRequest request){


       mensajeDto.setEmisor(this.servicioAuth.getUsuarioAutenticado());
       mensajeDto.setPublicacion(this.servicioPublicacion.getPublicacion(mensajeDto.getPublicacion().getId()));


        try {
            this.servicioMensajes.enviarMensaje(mensajeDto);
        }catch (SendingMessageException error){
            return new ModelAndView("redirect: "  + request.getContextPath() + "/publicacion/ver?pid=" + mensajeDto.getPublicacion().getId() + "&msj_response=error");
        }

        //envia notificacion
        this.servicioNotificacion.crearNotificacion(TipoNotificacion.NUEVA_PREGUNTA, mensajeDto.getPublicacion());


        return new ModelAndView("redirect: "  + request.getContextPath() + "/publicacion/ver?pid=" + mensajeDto.getPublicacion().getId() + "&msj_response=success");

    }

    @RequireAuth
    @RequestMapping(path = "/responder",method = RequestMethod.POST)
    public ModelAndView responderMensaje(@ModelAttribute MensajeDto mensajeDto, HttpServletRequest request){

        try{

            this.servicioMensajes.responderMensaje(mensajeDto);

        }catch (PersistenceException err){
            return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + mensajeDto.getPublicacion().getId() +"&response=error");
        }

        //notificacion
        this.servicioNotificacion.crearNotificacion(TipoNotificacion.NUEVA_RESPUESTA, this.servicioMensajes.getMensaje(mensajeDto.getId()));

        return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + mensajeDto.getPublicacion().getId() + "&response=success");
    }

    @RequireAuth
    @RequestMapping(path = "/eliminar",method = RequestMethod.GET)
    public ModelAndView eliminarRespuesta(@RequestParam Long idm, Long pid, HttpServletRequest request){

        try{

            this.servicioMensajes.eliminarRespuesta(idm);

        }catch (PersistenceException err){
            return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + pid +"&response=error");
        }

        return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/mensajes?pid=" + pid + "&response=deleted");
    }
}
