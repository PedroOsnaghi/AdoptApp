package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.model.Publicacion;

import java.util.List;

public interface IServicioPublicacion {


    //
    Publicacion findPublicacion(Long id);
    Publicacion guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion); //TODO return Publcacion

    void eliminarPublicacion(Long IdPublicacion);//TODO return bool o int

    List<Publicacion> listarPublicaciones();

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);

    //TODO ListarFavoritos(idUsuario)

}
