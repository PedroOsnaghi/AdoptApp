package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(Solicitud.class)
public class Solicitud implements Serializable {


    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    @Id
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "publicacion_id")
    @Id
    private Publicacion publicacion;

    @Enumerated(value = EnumType.STRING)
    @Column
    private EstadoSolicitud estado;

    @Column
    private String mensaje;

    public Solicitud(){}

    public Solicitud(Usuario user, Publicacion post, String mensaje){
        this.usuario = user;
        this.publicacion = post;
        this.mensaje = mensaje;
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public Solicitud(SolicitudDto sd){
        this.usuario = sd.getUsuarioSol();
        this.publicacion = sd.getPublicacionSol();
        this.mensaje = sd.getMensaje();
        this.estado = EstadoSolicitud.PENDIENTE;
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

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solicitud)) return false;
        Solicitud that = (Solicitud) o;
        return  Objects.equals(getUsuario(), that.getUsuario()) && Objects.equals(getPublicacion(), that.getPublicacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getUsuario(), getPublicacion());
    }


}

