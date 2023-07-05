package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.model.*;

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

    List<PublicacionDetallada> listarPublicacionesDetalladasPorUsuarioId(Long idUsuario);

    List<PublicacionMensajes> listarPublicacionesMensajesPorUsuarioId(Long idUsuario);

    List<PublicacionSolicitud> listarPublicacionesDisponiblesParaSolicitudPorUsuarioId(Long idUsuario);

    List<Publicacion_favorito> listarFavoritosDeUsuario(Long idUsuario);

    void pausarPublicacion(Long pid, Usuario userAuth);

    void reanudarPublicacion(Long pid, Usuario userAuth);

    void actualizarPublicacion(PublicacionDto publicacionDto);

    void reservar(Publicacion publicacion);

    void cerrar(Publicacion publicacion);

    List<Solicitud> listarPublicacionesCerradasPorUsuario(Long idUsuario);



    void reanudar(Publicacion publicacion);

    Long getPublicacionesPorUsuario(Long id);
}
