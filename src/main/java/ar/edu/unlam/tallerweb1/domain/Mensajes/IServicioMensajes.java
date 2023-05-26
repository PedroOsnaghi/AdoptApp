package ar.edu.unlam.tallerweb1.domain.Mensajes;

import ar.edu.unlam.tallerweb1.model.Mensaje;

import java.util.List;

public interface IServicioMensajes {

    Long enviarMensaje(Mensaje msj);

    void responderMensaje(Mensaje msj);

    void eliminarRespuesta(Mensaje msj);

    List<Mensaje> listarMensajesPublicacion(Long idPublicacion);

    List<Mensaje> listarMensajesSinResponder(Long idUsuario);

    List<Mensaje> listarMensajesRespondidos(Long idUsuario);

}
