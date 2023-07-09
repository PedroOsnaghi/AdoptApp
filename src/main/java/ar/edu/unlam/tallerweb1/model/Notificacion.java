package ar.edu.unlam.tallerweb1.model;

import java.util.Date;

public class Notificacion {
    private Long id;
    private String url;
    private String mensaje;
    private Usuario usuario;
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