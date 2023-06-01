package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.PublicacionMensajes;
import ar.edu.unlam.tallerweb1.model.Publicacion_favorito;

import java.util.List;

public interface IRepositorioPublicacion {
    Publicacion buscarPublicacionPorId(Long id);
    Long guardarPublicacion(Publicacion publicacion);

    void modificarPublicacion(Publicacion publicacion);

    void eliminarPublicacion(Long IdPublicacion);

    List<Publicacion> listarPublicaciones(String state);

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);

    List<PublicacionMensajes> listarPublicacionesConMensajesPorUsuarioId(Long idUsuario);

    Publicacion_favorito agregarFavorito(Publicacion_favorito favorito);

    void eliminarFavorito(Publicacion_favorito favorito);

    List<Publicacion_favorito> ListarFavoritosDeUsuario(Long idUsuario);


}
