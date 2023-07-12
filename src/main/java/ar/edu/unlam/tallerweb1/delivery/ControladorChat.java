package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.chat.IServicioChat;
import ar.edu.unlam.tallerweb1.domain.notificacion.IServicioNotificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("/chat")
public class ControladorChat {

    private final IServicioAuth servicioAuth;

    private IServicioChat servicioChat;

    @Autowired
    public ControladorChat(IServicioChat servicioChat, IServicioAuth servicioAuth){
        this.servicioChat = servicioChat;
        this.servicioAuth = servicioAuth;

    }

    @RequestMapping(path = "/enviarmensaje", method = RequestMethod.GET)
    public ResponseEntity<Timestamp> enviarMensaje(@RequestParam String code, @RequestParam String message){

        Timestamp hora = this.servicioChat.enviarMensaje(code, this.servicioAuth.getUsuarioAutenticado(), message);



        return ResponseEntity.status(HttpStatus.OK).body(hora);
    }


    @RequestMapping(path = "/refresh", method = RequestMethod.GET)
    public ModelAndView refresh(@RequestParam String code){
        ModelMap model = new ModelMap();

        model.put("usuario", this.servicioAuth.getUsuarioAutenticado());
        model.put("mensajes_chat", this.servicioChat.listarMensajesDeSolicitud(code));

        return new ModelAndView("partials/chat-list", model);
    }

}
