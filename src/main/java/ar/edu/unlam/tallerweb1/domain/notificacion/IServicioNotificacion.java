package ar.edu.unlam.tallerweb1.domain.notificacion;

import ar.edu.unlam.tallerweb1.model.*;

import java.util.List;

public interface IServicioNotificacion {
    Long crearNotificacion(Notificacion notificacion);
    void eliminarNotificacion(Long id);
    List<Notificacion> listarNotificaciones(Usuario usuario);

}