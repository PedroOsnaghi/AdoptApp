package ar.edu.unlam.tallerweb1.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(Publicacion_favorito.class)
public class Publicacion_favorito implements Serializable {


    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "usuario_id")
    @Id
    private Usuario usuario;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "publicacion_id")
    @Id
    private Publicacion publicacion;

    public Publicacion_favorito(){}

    public Publicacion_favorito(Usuario user, Publicacion post){
        this.usuario = user;
        this.publicacion = post;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publicacion_favorito)) return false;
        Publicacion_favorito that = (Publicacion_favorito) o;
        return  Objects.equals(getUsuario(), that.getUsuario()) && Objects.equals(getPublicacion(), that.getPublicacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getUsuario(), getPublicacion());
    }
}

