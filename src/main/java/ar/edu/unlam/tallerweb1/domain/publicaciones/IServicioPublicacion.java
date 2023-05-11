package ar.edu.unlam.tallerweb1.domain.publicaciones;

import java.util.List;

public interface IServicioPublicacion {

    Publicacion findPublicacion(Long id);
    void guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion);

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);
}
