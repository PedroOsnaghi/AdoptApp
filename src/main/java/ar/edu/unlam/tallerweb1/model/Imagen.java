package ar.edu.unlam.tallerweb1.model;

import javax.persistence.*;

@Entity
public class Imagen {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;
    private String nombre;

    public Imagen(){}

    public Imagen(String nombre, Publicacion post){
        this.nombre = nombre;
        this.publicacion = post;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
