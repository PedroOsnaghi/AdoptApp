package ar.edu.unlam.tallerweb1.domain.Mensajes;

import ar.edu.unlam.tallerweb1.model.Mensaje;

import java.util.List;

public interface IRepositorioMensajes {

    Mensaje obtenerMensaje(Long id);

    Long guardarMensaje(Mensaje msj);

    Mensaje actualizarMensaje(Mensaje msj);

    List<Mensaje> listarMensajesPublicacion(Long idPublicacion);

    List<Mensaje> listarMensajesSinResponder(Long idPublicacion);

    List<Mensaje> listarMensajesRespondidos(Long idPublicacion);
}
