package ar.edu.unlam.tallerweb1.model;

public class PublicacionMensajes {

    private Publicacion publicacion;

    private Long new_messages;

    public PublicacionMensajes(){}
    public PublicacionMensajes(Publicacion publicacion, Long new_messages) {
        this.publicacion = publicacion;
        this.new_messages = new_messages;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Long getNew_messages() {
        return new_messages;
    }

    public void setNew_messages(Long new_messages) {
        this.new_messages = new_messages;
    }
}
