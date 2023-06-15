package ar.edu.unlam.tallerweb1.model;

public class PublicacionDetallada {

    private Publicacion publicacion;

    private Long cantMensajes;

    private Long cantSolicitudes;

    public PublicacionDetallada(Publicacion p, Long mensajes){
        this.publicacion = p;
        this.cantMensajes = mensajes;
       // this.cantSolicitudes = solicitudes;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Long getCantMensajes() {
        return cantMensajes;
    }

    public void setCantMensajes(Long cantMensajes) {
        this.cantMensajes = cantMensajes;
    }

    public Long getCantSolicitudes() {
        return cantSolicitudes;
    }

    public void setCantSolicitudes(Long cantSolicitudes) {
        this.cantSolicitudes = cantSolicitudes;
    }
}
