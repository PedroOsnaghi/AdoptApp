package ar.edu.unlam.tallerweb1.delivery.dto;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;

import javax.persistence.*;

public class SolicitudDto {

    private String codigo;

    private Usuario usuario;

    private Publicacion publicacion;

    private String motivo_cancelacion;


    private String mensaje;


    public Usuario getUsuarioSol() {
        return usuario;
    }

    public void setUsuarioSol(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacionSol() {
        return publicacion;
    }

    public void setPublicacionSol(Publicacion publicacion) {
        this.publicacion = publicacion;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public String getMotivo_cancelacion() {
        return motivo_cancelacion;
    }

    public void setMotivo_cancelacion(String motivo_cancelacion) {
        this.motivo_cancelacion = motivo_cancelacion;
    }
}
