package ar.edu.unlam.tallerweb1.domain.publicaciones;

import java.util.List;

public interface IServicioPublicacion {

    Publicacion findPublicacion(Long id);
    Publicacion guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion);

    void eliminarPublicacion(Long IdPublicacion);

    List<Publicacion> listarPublicaciones();

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);

}
