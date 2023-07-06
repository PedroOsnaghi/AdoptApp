package ar.edu.unlam.tallerweb1.domain.chat;

import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.sql.Timestamp;
import java.util.List;

public interface IRepositorioChat {

    List<ChatMensaje> listarMensajesDeSolicitud(String codigo);

    Timestamp enviarMensaje(ChatMensaje mensaje);
}
