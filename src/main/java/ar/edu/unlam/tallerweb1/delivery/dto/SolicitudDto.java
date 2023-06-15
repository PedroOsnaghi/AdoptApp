package ar.edu.unlam.tallerweb1.delivery.dto;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;

import javax.persistence.*;

public class SolicitudDto {


    private Usuario usuario;


    private Publicacion publicacion;



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

}
