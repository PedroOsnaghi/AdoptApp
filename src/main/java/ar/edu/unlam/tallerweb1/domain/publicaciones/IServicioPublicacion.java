package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.PublicacionDto;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion_favorito;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.util.List;

public interface IServicioPublicacion {

    String getErrorMessage();
    //
    Publicacion findPublicacion(Long id);
    Long guardarPublicacion(PublicacionDto publicacionDto);
    void modificarPublicacion(Publicacion publicacion); //TODO return Publcacion

    void eliminarPublicacion(Long IdPublicacion);//TODO return bool o int

    void agregarFavorito(Long idPublicacion, Usuario usuario);

    void eliminarFavorito(Long idPublicacion, Usuario usuario);

    List<Publicacion> listarPublicacionesDisponibles();

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);

    List<Publicacion_favorito> listarFavoritosDeUsuario(Long idUsuario);



}
