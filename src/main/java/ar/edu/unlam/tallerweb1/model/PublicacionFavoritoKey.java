package ar.edu.unlam.tallerweb1.model;


import java.io.Serializable;
import java.util.Objects;

public class PublicacionFavoritoKey implements Serializable {

    private Long publicacionId;

    private Long usuarioId;

    public PublicacionFavoritoKey(){}

    public PublicacionFavoritoKey(Long pid, Long uid){
        this.publicacionId = pid;
        this.usuarioId = uid;
    }

    public Long getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Long publicacionId) {
        this.publicacionId = publicacionId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublicacionFavoritoKey)) return false;
        PublicacionFavoritoKey that = (PublicacionFavoritoKey) o;
        return Objects.equals(getPublicacionId(), that.getPublicacionId()) && Objects.equals(getUsuarioId(), that.getUsuarioId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublicacionId(), getUsuarioId());
    }
}
