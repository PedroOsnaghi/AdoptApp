package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.PublicacionDto;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.util.List;

public interface IServicioPublicacion {

    String getErrorMessage();
    //
    Publicacion findPublicacion(Long id);
    Long guardarPublicacion(PublicacionDto publicacionDto);
    void modificarPublicacion(Publicacion publicacion); //TODO return Publcacion

    void eliminarPublicacion(Long IdPublicacion);//TODO return bool o int

    List<Publicacion> listarPublicacionesDisponibles();

    List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario);



    //TODO ListarFavoritos(idUsuario)

}
