package ar.edu.unlam.tallerweb1.model;

import javax.persistence.*;

@Entity
public class Imagen  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="LONGTEXT")
    private String base64Content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;


    public Imagen(){}

    public Imagen(String content, Publicacion post){
        this.base64Content = content;
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

    public String getBase64Content() {
        return base64Content;
    }

    public void setBase64Content(String content) {
        this.base64Content = content;
    }
}
