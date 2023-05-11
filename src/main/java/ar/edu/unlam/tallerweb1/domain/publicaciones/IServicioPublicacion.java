package ar.edu.unlam.tallerweb1.domain.publicaciones;
public interface IServicioPublicacion {

    Publicacion findPublicacion(Long id);
    void guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion);
}
