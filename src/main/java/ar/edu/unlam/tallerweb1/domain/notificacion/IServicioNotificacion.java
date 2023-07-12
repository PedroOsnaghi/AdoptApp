package ar.edu.unlam.tallerweb1.domain.notificacion;

import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.model.enumerated.TipoNotificacion;

import java.util.List;

public interface IServicioNotificacion {
    Long crearNotificacion(TipoNotificacion tipo, Object object);
    void eliminarNotificacion(Notificacion notificacion);
    List<Notificacion> listarNotificaciones(Usuario usuario);
    Notificacion getNotificacion(Long idn);

    void marcarLeidas(Usuario usuario);

    Long getNewNotifications(Usuario usuario);
}