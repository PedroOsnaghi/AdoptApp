package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

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

    @Column(name = "mensaje")
    private String mensaje;

    @Column(nullable = false)
    private String codigo;

    private boolean calA = false;

    private boolean calP = false;

    private String motivo_cancelacion;

    @CreationTimestamp
    private Timestamp created_at;

    @UpdateTimestamp
    private Timestamp update_at;

    public Solicitud(){}

    public Solicitud(Usuario user, Publicacion post, String mensaje){
        this.usuario = user;
        this.publicacion = post;
        this.mensaje = mensaje;
        this.codigo = UUID.randomUUID().toString();
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public Solicitud(SolicitudDto sd){
        this.usuario = sd.getUsuarioSol();
        this.publicacion = sd.getPublicacionSol();
        this.mensaje = sd.getMensaje();
        this.codigo = UUID.randomUUID().toString();
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public Solicitud(Long idUsuario, Long idPublicacion){
        Usuario u = new Usuario();
        u.setId(idUsuario);
        Publicacion p = new Publicacion();
        p.setId(idPublicacion);
        this.setUsuario(u);
        this.setPublicacion(p);
        this.codigo = UUID.randomUUID().toString();
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

    public Publicacion getPublicacionSolicitud() {
        return publicacion;
    }

    public void setPublicacionSolicitud(Publicacion publicacion) {
        this.publicacion = publicacion;
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

    public String getMensajeSolicitud() {
        return mensaje;
    }

    public void setMensajeSolicitud(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isCalA() {
        return calA;
    }

    public void setCalA(boolean calA) {
        this.calA = calA;
    }

    public boolean isCalP() {
        return calP;
    }

    public void setCalP(boolean calP) {
        this.calP = calP;
    }

    public String getMotivo_cancelacion() {
        return motivo_cancelacion;
    }

    public void setMotivo_cancelacion(String motivo_cancelacion) {
        this.motivo_cancelacion = motivo_cancelacion;
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

