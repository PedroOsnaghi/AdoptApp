package ar.edu.unlam.tallerweb1.domain.Calificacion;

import ar.edu.unlam.tallerweb1.model.Calificacion;
import ar.edu.unlam.tallerweb1.model.UsuarioConCalificacion;
import ar.edu.unlam.tallerweb1.model.enumerated.RolCalificacion;

import java.util.List;

public interface IRepositorioCalificacion {

    Long guardarCalificacion(Calificacion calificacion);

    UsuarioConCalificacion getCalificacionUsuario(Long idUsuario, RolCalificacion rol);

    List<Calificacion> getComentariosComoAdoptante(Long idUsuario);

    List<Calificacion> getComentariosComoPublicador(Long idUsuario);
}
