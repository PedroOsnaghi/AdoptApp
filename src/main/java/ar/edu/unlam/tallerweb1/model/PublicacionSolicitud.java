package ar.edu.unlam.tallerweb1.model;

public class PublicacionSolicitud {

    private Publicacion publicacion;

    private Long new_solicitud;

    public PublicacionSolicitud(){}
    public PublicacionSolicitud(Publicacion publicacion, Long new_solicitud) {
        this.publicacion = publicacion;
        this.new_solicitud = new_solicitud;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Long getNew_solicitud() {
        return new_solicitud;
    }

    public void setNew_solicitud(Long new_solicitud) {
        this.new_solicitud = new_solicitud;
    }
}
