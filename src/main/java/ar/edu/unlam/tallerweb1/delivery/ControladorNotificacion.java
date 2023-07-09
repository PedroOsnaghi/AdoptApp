package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.notificacion.IServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.IServicioUsuario;
import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Notificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/notificacion")
public class ControladorNotificacion {
    IServicioNotificacion servicioNotificacion;
    IServicioUsuario servicioUsuario;
    IServicioAuth servicioAuth;

    @Autowired
    public ControladorNotificacion(IServicioNotificacion sn, IServicioUsuario su, IServicioAuth sa) {
        this.servicioNotificacion = sn;
        this.servicioUsuario = su;
        this.servicioAuth = sa;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Notificacion>> getNotificaciones() {

        Usuario usuario = servicioAuth.getUsuarioAutenticado();

        List<Notificacion> notificaciones = servicioNotificacion.listarNotificaciones(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(notificaciones);
    }
}