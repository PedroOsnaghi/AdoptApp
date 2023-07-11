package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.notificacion.IServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.IServicioUsuario;
import ar.edu.unlam.tallerweb1.model.Notificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
@RestController
@RequestMapping("/notificacion")
public class ControladorNotificacion {

    @Autowired
    private  IServicioNotificacion servicioNotificacion;
    @Autowired
    private  IServicioAuth servicioAuth;



    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Notificacion>> listNotificaciones() {

        Usuario usuario = this.servicioAuth.getUsuarioAutenticado();

        List<Notificacion> notificaciones = this.servicioNotificacion.listarNotificaciones(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(notificaciones);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<String> getNotificacion(@RequestParam Long idn, HttpServletRequest request) {

       Notificacion notificacion = this.servicioNotificacion.getNotificacion(idn);

        String url;

        switch (notificacion.getTipo()){
            case WELCOME: url =  request.getContextPath() + "/home/feed"; break;
            case NUEVO_CHAT_PUB: url = request.getContextPath() +"/solicitud/adoptante?code=" + notificacion.getParams() + "&openchat=true"; break;
            case NUEVO_CHAT_ADOPT: url = request.getContextPath() +"/solicitud/publicador?code=" + notificacion.getParams() + "&openchat=true"; break;
            case NUEVA_PREGUNTA: url = request.getContextPath() + "/perfil/mensajes?pid=" + notificacion.getParams(); break;
            case NUEVA_SOLICITUD: url = request.getContextPath() + "/perfil/solicitud?pid=" + notificacion.getParams(); break;
            case ACEPT_SOLICITUD: url = request.getContextPath() + "/solicitud/adoptante?code=" + notificacion.getParams(); break;
            case CANCEL_SOLICITUD: url = request.getContextPath() + "/solicitud/publicador?code=" + notificacion.getParams(); break;
            default: url = request.getContextPath() + "/home/mispublicaciones";
        };

        this.servicioNotificacion.eliminarNotificacion(notificacion);

       return ResponseEntity.status(HttpStatus.OK).body(url);
    }


}