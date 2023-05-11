package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;

import java.util.List;

public interface IRepositorioPublicacion {
    Publicacion buscarPublicacionPorId(Long id);
    Publicacion guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion);

    void eliminarPublicacion(Long IdPublicacion);

    List<Publicacion> listarPublicaciones();

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);
}
