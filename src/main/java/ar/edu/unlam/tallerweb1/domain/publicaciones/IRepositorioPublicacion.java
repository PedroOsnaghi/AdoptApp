package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion_favorito;

import java.util.List;

public interface IRepositorioPublicacion {
    Publicacion buscarPublicacionPorId(Long id);
    void guardarPublicacion(Publicacion publicacion);

    void modificarPublicacion(Publicacion publicacion);

    void eliminarPublicacion(Long IdPublicacion);

    List<Publicacion> listarPublicaciones(String state);

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);

    void agregarFavorito(Publicacion_favorito favorito);

    void eliminarFavorito(Publicacion_favorito favorito);

    List<Publicacion_favorito> ListarFavoritosDeUsuario(Long idUsuario);


}
