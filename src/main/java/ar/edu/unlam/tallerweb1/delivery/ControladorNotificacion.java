package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Notificacion {
    private String url;
    private String mensaje;
    private Usuario usuario;
    private boolean leido;
    private Date fechaCreacion;

    public Notificacion() {
    }

    public Notificacion(Usuario usuario, String url, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

@RestController
@RequestMapping("/notificacion")
public class ControladorNotificacion {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Notificacion>> ejemplo(@RequestParam Long id) {

        Usuario usuario = new Usuario();
        usuario.setId(id);

        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(new Notificacion(usuario, "/pedido/1", "Nuevo pedido"));
        notificaciones.add(new Notificacion(usuario, "/pedido/2", "Nuevo Adopcion"));
        notificaciones.add(new Notificacion(usuario, "/pedido/3", "Nuevo Compra"));
        notificaciones.add(new Notificacion(usuario, "/pedido/4", "Nuevo Venta"));

        return ResponseEntity.status(HttpStatus.OK).body(notificaciones);
    }
}