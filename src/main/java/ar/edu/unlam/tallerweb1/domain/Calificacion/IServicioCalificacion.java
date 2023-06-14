package ar.edu.unlam.tallerweb1.domain.Calificacion;

import ar.edu.unlam.tallerweb1.delivery.dto.CalificacionDto;
import ar.edu.unlam.tallerweb1.model.Calificacion;
import ar.edu.unlam.tallerweb1.model.UsuarioConCalificacion;

import java.util.List;

public interface IServicioCalificacion {

    Long calificarPublicador(CalificacionDto calDto);

    Long calificarAdoptante(CalificacionDto calDto);

    UsuarioConCalificacion getCalificacionPublicador(Long idUsuario);

    UsuarioConCalificacion getCalificacionAdoptante(Long idUsuario);

}
