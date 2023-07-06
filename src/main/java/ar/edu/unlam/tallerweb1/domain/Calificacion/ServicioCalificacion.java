package ar.edu.unlam.tallerweb1.domain.Calificacion;

import ar.edu.unlam.tallerweb1.delivery.dto.CalificacionDto;
import ar.edu.unlam.tallerweb1.domain.exceptions.DataValidationException;
import ar.edu.unlam.tallerweb1.model.Calificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.UsuarioConCalificacion;
import ar.edu.unlam.tallerweb1.model.enumerated.RolCalificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCalificacion implements IServicioCalificacion{

    private final IRepositorioCalificacion repositorioCalificacion;

    @Autowired
    public ServicioCalificacion(IRepositorioCalificacion repositorioCalificacion){
        this.repositorioCalificacion = repositorioCalificacion;
    }


    @Override
    public Long calificarPublicador(CalificacionDto calDto) {
        Calificacion cal = this.validarDatos(calDto, RolCalificacion.PUBLICADOR);
        return this.repositorioCalificacion.guardarCalificacion(cal);
    }

    @Override
    public Long calificarAdoptante(CalificacionDto calDto) {

        Calificacion cal = this.validarDatos(calDto, RolCalificacion.ADOPTANTE);
        return this.repositorioCalificacion.guardarCalificacion(cal);
    }

    @Override
    public UsuarioConCalificacion getCalificacionPublicador(Long idUsuario) {


        return this.repositorioCalificacion.getCalificacionUsuario(idUsuario, RolCalificacion.PUBLICADOR);
    }

    @Override
    public UsuarioConCalificacion getCalificacionAdoptante(Long idUsuario) {


        return this.repositorioCalificacion.getCalificacionUsuario(idUsuario, RolCalificacion.ADOPTANTE);
    }

    @Override
    public List<Calificacion> getComentariosComoAdoptante(Long idUsuario) {
        return this.repositorioCalificacion.getComentariosComoAdoptante(idUsuario);
    }

    @Override
    public List<Calificacion> getComentariosComoPublicador(Long idUsuario) {
        return this.repositorioCalificacion.getComentariosComoPublicador(idUsuario);
    }


    private Calificacion validarDatos(CalificacionDto cDto, RolCalificacion rol) {
        if(cDto.getCommentario().isEmpty()) throw new DataValidationException("El comentario es obligatorio");

        if(cDto.getUsuarioCalificado() == null) throw new DataValidationException("No especificó usuario a calificar");

        if(cDto.getCalificacion() == 0 | (cDto.getCalificacion() < 0 | cDto.getCalificacion() > 5) ) throw new DataValidationException("La calificación no es válida o no asigno una calificación");

        return new Calificacion(cDto.getUsuarioCalificado(), rol, cDto.getCalificacion(), cDto.getCommentario());
    }

}
