package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

class SolicitudId implements Serializable {
    private Usuario usuario;
    private Publicacion publicacion;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudId that = (SolicitudId) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(publicacion, that.publicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, publicacion);
    }
}

@Entity
@Table(name = "solicitud")
@IdClass(SolicitudId.class)
public class Solicitud {

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoSolicitud estado;

    @Column(name = "mensaje", nullable = false)
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

