package ar.edu.unlam.tallerweb1.domain.chat;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioChat;
import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ServicioChat implements IServicioChat {

    private IRepositorioChat repositorioChat;

    @Autowired
    public ServicioChat(IRepositorioChat repositorioChat){
        this.repositorioChat = repositorioChat;
    }

    @Override
    public List<ChatMensaje> listarMensajesDeSolicitud(String codigo) {
        return this.repositorioChat.listarMensajesDeSolicitud(codigo);
    }

    @Override
    public Timestamp enviarMensaje(String codigo, Usuario usuario, String mensaje) {
        ChatMensaje chatMensaje = new ChatMensaje(codigo, usuario, mensaje);

        return this.repositorioChat.enviarMensaje(chatMensaje);
    }
}
