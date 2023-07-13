package ar.edu.unlam.tallerweb1.domain.chat;

import ar.edu.unlam.tallerweb1.domain.Solicitud.IServicioSolicitud;
import ar.edu.unlam.tallerweb1.domain.notificacion.IServicioNotificacion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioChat;
import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.TipoNotificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ServicioChat implements IServicioChat {

    private final IServicioNotificacion servicioNotificacion;
    private IRepositorioChat repositorioChat;
    private IServicioSolicitud servicioSolicitud;

    @Autowired
    public ServicioChat(IRepositorioChat repositorioChat, IServicioNotificacion servicioNotificacion, IServicioSolicitud servicioSolicitud){
        this.repositorioChat = repositorioChat;
        this.servicioNotificacion = servicioNotificacion;
        this.servicioSolicitud = servicioSolicitud;
    }

    @Override
    public List<ChatMensaje> listarMensajesDeSolicitud(String codigo) {
        return this.repositorioChat.listarMensajesDeSolicitud(codigo);
    }

    @Override
    public Timestamp enviarMensaje(String codigo, Usuario usuario, String mensaje) {
        ChatMensaje chatMensaje = new ChatMensaje(codigo, usuario, mensaje);

        Solicitud solicitud= this.servicioSolicitud.getSolicitud(codigo);
        TipoNotificacion tipo = (usuario.getId() == solicitud.getUsuario().getId()) ? TipoNotificacion.NUEVO_CHAT_ADOPT : TipoNotificacion.NUEVO_CHAT_PUB;
        this.servicioNotificacion.crearNotificacion(tipo,solicitud);

        return this.repositorioChat.enviarMensaje(chatMensaje);
    }
}
