package ar.edu.unlam.tallerweb1.domain.Mensajes;

import ar.edu.unlam.tallerweb1.delivery.MensajeDto;
import ar.edu.unlam.tallerweb1.model.Mensaje;

import java.util.List;

public interface IServicioMensajes {

    Long enviarMensaje(MensajeDto msjDto);

    void responderMensaje(MensajeDto msjDto);

    void eliminarRespuesta(Long idMensaje);

    List<Mensaje> listarMensajesPublicacion(Long idPublicacion);

    List<Mensaje> listarMensajesSinResponder(Long idPublicacion);

    List<Mensaje> listarMensajesRespondidos(Long idPublicacion);

}
