package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.chat.IRepositorioChat;
import ar.edu.unlam.tallerweb1.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioChatTest extends SpringTest {

    @Autowired
    private IRepositorioChat repositorioChat;

    @Test
    @Transactional
    @Rollback
    public void alListarChatMensajesPorCodigoSolicitud(){
        Solicitud solicitud = dadoQueExistenChatMensajesQuePertenecenAUnaSolicitud();
        List<ChatMensaje> chatMensajes = alListarPorCodigoSolicitud(solicitud.getCodigo());
        assertThat(chatMensajes).hasSize(2);
    }

    @Test
    @Transactional
    @Rollback
    public void alEnviarMensajeObtenemosUnTimestamp() {
        ChatMensaje chatMensaje = dadoQueExisteChatMensaje();

        Timestamp horaCreacion = alEnviarMensaje(chatMensaje);

        assertThat(horaCreacion).isInstanceOf(Timestamp.class);
    }

    private ChatMensaje dadoQueExisteChatMensaje() {
        Usuario usuarioAdoptante = new Usuario("aldu", "aldu@mail.com", "2345");
        session().save(usuarioAdoptante);

        Usuario usuarioPublicador = new Usuario("juani", "juani@mail.com", "12345");
        session().save(usuarioPublicador);

        Mascota mascota = new Mascota();
        mascota.setUsuario(usuarioPublicador);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setMascota(mascota);
        session().save(publicacion);

        Solicitud solicitud = new Solicitud(usuarioAdoptante, publicacion, "Mensaje de solicitud");
        solicitud.setCodigo("1234");
        session().save(solicitud);

        return new ChatMensaje(solicitud.getCodigo(), usuarioPublicador, "Contenido del mensaje");
    }

    private Timestamp alEnviarMensaje(ChatMensaje chatMensaje) {
        return this.repositorioChat.enviarMensaje(chatMensaje);
    }

    private Solicitud dadoQueExistenChatMensajesQuePertenecenAUnaSolicitud() {
        Usuario usuarioAdoptante = new Usuario("aldu", "aldu@mail.com", "2345");
        session().save(usuarioAdoptante);

        Usuario usuarioPublicador = new Usuario("juani", "juani@mail.com", "12345");
        session().save(usuarioPublicador);

        Mascota mascota = new Mascota();
        mascota.setUsuario(usuarioPublicador);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setMascota(mascota);
        session().save(publicacion);

        Solicitud solicitud = new Solicitud(usuarioAdoptante, publicacion, "Mensaje de solicitud");
        solicitud.setCodigo("1234");
        session().save(solicitud);

        ChatMensaje chatMensaje1 = new ChatMensaje(solicitud.getCodigo(), usuarioPublicador, "Contenido del mensaje");
        ChatMensaje chatMensaje2 = new ChatMensaje(solicitud.getCodigo(), usuarioPublicador, "Contenido del mensaje 2");

        session().save(chatMensaje1);
        session().save(chatMensaje2);

        return solicitud;
    }

    private List<ChatMensaje> alListarPorCodigoSolicitud(String codigo) {
        return this.repositorioChat.listarMensajesDeSolicitud(codigo);
    }
}
