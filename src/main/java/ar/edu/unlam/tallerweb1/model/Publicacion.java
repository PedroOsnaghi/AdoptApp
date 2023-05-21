package ar.edu.unlam.tallerweb1.model;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.lang.*;

@Entity
public class Publicacion {

    public enum EstadoPublicacion {
        DISPONIBLE,
        RESERVADO,
        ADOPTADO,


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String latitud;
    private String longitud;

    @Column(length = 255)
    private String disponibilidad;

    private String estado;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Long mascota_id;

    @CreationTimestamp
    private Timestamp create_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Long getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(Long mascota_id) {
        this.mascota_id = mascota_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario autor) {
        this.usuario = autor;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp fechaCreacion) {
        this.create_at = fechaCreacion;
    }
}