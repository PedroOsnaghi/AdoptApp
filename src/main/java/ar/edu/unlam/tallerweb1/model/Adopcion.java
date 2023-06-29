package ar.edu.unlam.tallerweb1.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Adopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarioAdoptante_id")
    private Usuario usuarioAdoptante;

    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;

    @CreationTimestamp
    private Timestamp created_at;

    public Adopcion(){}
    public Adopcion(Usuario usuarioAdoptante, Publicacion publicacion){
        this.usuarioAdoptante = usuarioAdoptante;
        this.publicacion = publicacion;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioAdoptante() {
        return usuarioAdoptante;
    }

    public void setUsuarioAdoptante(Usuario usuarioAdoptante) {
        this.usuarioAdoptante = usuarioAdoptante;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
