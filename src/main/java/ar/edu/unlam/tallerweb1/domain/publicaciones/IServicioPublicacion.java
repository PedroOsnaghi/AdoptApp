package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.PublicacionMensajes;
import ar.edu.unlam.tallerweb1.model.Publicacion_favorito;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.util.List;

public interface IServicioPublicacion {

    Publicacion getPublicacion(Long id);

    Long guardarPublicacion(PublicacionDto publicacionDto);
    void modificarPublicacion(Publicacion publicacion); //TODO return Publcacion

    void eliminarPublicacion(Long idPublicacion, Usuario userAuth);//TODO return bool o int

    Publicacion_favorito agregarFavorito(Long idPublicacion, Usuario usuario);

    void eliminarFavorito(Long idPublicacion, Usuario usuario);

    List<Publicacion> listarPublicacionesDisponibles();

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);

    List<PublicacionMensajes> listarPublicacionesMensajesPorUsuarioId(Long idUsuario);

    List<Publicacion_favorito> listarFavoritosDeUsuario(Long idUsuario);

    void pausarPublicacion(Long pid, Usuario userAuth);

    void reanudarPublicacion(Long pid, Usuario userAuth);

    void actualizarPublicacion(PublicacionDto publicacionDto);

    void crearSolicitud(Long pid, Usuario userAuth);

    void eliminarSolicitud(Long publicacionId, Usuario userAuth);
}
