package ar.edu.unlam.tallerweb1.model;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.lang.*;
import java.time.Instant;
import java.util.*;

@Entity
public class Publicacion {



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
    @Enumerated(value = EnumType.STRING)
    private EstadoPublicacion estado;
    @OneToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;
    @CreationTimestamp
    private Timestamp create_at;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "publicacion", cascade = {CascadeType.REMOVE, CascadeType.DETACH} , orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "publicacion", cascade = {CascadeType.REMOVE, CascadeType.DETACH} , orphanRemoval = true)
   // private List<Solicitud> solicitudes = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "publicacion", cascade = {CascadeType.REMOVE, CascadeType.DETACH} , orphanRemoval = true)
    private List<Mensaje> mensajes = new ArrayList<>();

    public Publicacion(){}

    @PrePersist
    public void prePersist() {
        Timestamp ts = Timestamp.from(Instant.now());
        this.setCreate_at(ts);
    }

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

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public EstadoPublicacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPublicacion estado) {
        this.estado = estado;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp fechaCreacion) {
        this.create_at = fechaCreacion;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
