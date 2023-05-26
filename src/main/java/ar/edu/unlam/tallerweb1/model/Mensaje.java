package ar.edu.unlam.tallerweb1.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "emisor_id")
    private Usuario emisor;

    private Timestamp fechaEmision;

    private String pregunta;

    private String respuesta;

    private Timestamp fechaRespuesta;

    public Mensaje() {}

    public Mensaje(Publicacion publicacion, Usuario emisor, String pregunta) {
        this.publicacion = publicacion;
        this.emisor = emisor;
        this.pregunta = pregunta;
        this.fechaEmision =  Timestamp.from(Instant.now());
        this.respuesta = null;
        this.fechaRespuesta = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Timestamp getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Timestamp fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Timestamp getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Timestamp fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensaje)) return false;
        Mensaje mensaje1 = (Mensaje) o;
        return Objects.equals(getId(), mensaje1.getId()) && Objects.equals(getPublicacion(), mensaje1.getPublicacion()) && Objects.equals(getEmisor(), mensaje1.getEmisor()) && Objects.equals(getFechaEmision(), mensaje1.getFechaEmision()) && Objects.equals(getPregunta(), mensaje1.getPregunta()) && Objects.equals(getRespuesta(), mensaje1.getRespuesta()) && Objects.equals(getFechaRespuesta(), mensaje1.getFechaRespuesta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPublicacion(), getEmisor(), getFechaEmision(), getPregunta(), getRespuesta(), getFechaRespuesta());
    }
}
