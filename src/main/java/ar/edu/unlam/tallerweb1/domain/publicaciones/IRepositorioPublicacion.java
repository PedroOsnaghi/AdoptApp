package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.model.Publicacion;

import java.util.List;

public interface IRepositorioPublicacion {
    Publicacion buscarPublicacionPorId(Long id);
    void guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion);

    void eliminarPublicacion(Long IdPublicacion);

    List<Publicacion> listarPublicaciones(String state);

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);
}
