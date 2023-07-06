package ar.edu.unlam.tallerweb1.domain.chat;

import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.sql.Timestamp;
import java.util.List;

public interface IServicioChat {

    List<ChatMensaje> listarMensajesDeSolicitud(String codigo);

    Timestamp enviarMensaje(String codigo, Usuario usuario, String mensaje);

}
