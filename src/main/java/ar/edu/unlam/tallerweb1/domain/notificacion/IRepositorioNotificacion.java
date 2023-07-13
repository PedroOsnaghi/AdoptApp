package ar.edu.unlam.tallerweb1.domain.notificacion;

import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Notificacion;

import java.util.List;

public interface IRepositorioNotificacion {
    Long crearNotificacion(Notificacion notificacion);

    void eliminarNotificacion(Notificacion notificacion);

    List<Notificacion> listarNotificaciones (Long userId);

    Notificacion getNotificacion(Long idNotificacion);

    void marcarLeidas(Long id);

    Long getNewNotifications(Long idUsuario);
}
