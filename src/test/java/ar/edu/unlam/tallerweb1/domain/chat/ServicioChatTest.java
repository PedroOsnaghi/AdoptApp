package ar.edu.unlam.tallerweb1.domain.chat;


import ar.edu.unlam.tallerweb1.domain.Solicitud.IServicioSolicitud;
import ar.edu.unlam.tallerweb1.domain.notificacion.IServicioNotificacion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioChat;
import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Java6Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class ServicioChatTest {
    @Mock
    private IRepositorioChat repositorioChat;

    @Mock
    private IServicioSolicitud servicioSolicitud;

    @Mock
    private IServicioNotificacion servicioNotificacion;

    @InjectMocks
    private ServicioChat servicioChat;

    private Timestamp horaActual = Timestamp.from(Instant.now());

    @Test
    public void ListarMensajesDeSolicitudMeDevuelvaUnListaDeChatMensajes() {
        Solicitud solicitud = new Solicitud();
        solicitud.setCodigo("1234");

        List<ChatMensaje> chatMensajes = dadoQueExisteUnaListaDeMensajes(solicitud);
        List<ChatMensaje> resultado = AlListarMensajes(solicitud.getCodigo(), chatMensajes);
        MeDevuelveUnaListaCon3Mensajes(resultado);
    }
    @Test
    public void alEnviarMensajeNosDevuelveLaHoraDeCreacion() {
        ChatMensaje chatMensaje = dadoQueExisteChatMensaje();
        Timestamp horaCreacion = alEnviarMensaje(chatMensaje);
        nosDevuelveLaHoraDeCreacion(horaCreacion);
    }

    private void nosDevuelveLaHoraDeCreacion(Timestamp horaCreacion) {
        assertThat(horaCreacion).isEqualTo(horaActual);
    }

    private Timestamp alEnviarMensaje(ChatMensaje chatMensaje) {
        Solicitud s = new Solicitud();
        Usuario u = new Usuario();
        u.setId(1L);
        s.setUsuario(u);
        when(this.repositorioChat.enviarMensaje(anyObject())).thenReturn(horaActual);
        when(this.servicioSolicitud.getSolicitud(anyString())).thenReturn(s);

        return this.servicioChat.enviarMensaje(chatMensaje.getCodigo_solicitud(), chatMensaje.getUsuario(), chatMensaje.getContenido());
    }

    private ChatMensaje dadoQueExisteChatMensaje() {
        Solicitud solicitud = new Solicitud();
        solicitud.setCodigo("1234");

        Usuario usuario = new Usuario("juani", "juani@mail", "12345");

        String mensaje = "Mensaje 1";

        return new ChatMensaje(solicitud.getCodigo(), usuario, mensaje);
    }

    private void MeDevuelveUnaListaCon3Mensajes(List<ChatMensaje> resultado) {
        Assertions.assertThat(resultado).hasSize(3);
    }

    private List<ChatMensaje> AlListarMensajes(String codigo, List<ChatMensaje> chatMensajes) {
        when(this.repositorioChat.listarMensajesDeSolicitud(anyString())).thenReturn(chatMensajes);
        return this.servicioChat.listarMensajesDeSolicitud(codigo);
    }

    private List<ChatMensaje> dadoQueExisteUnaListaDeMensajes(Solicitud solicitud) {
        Usuario usuario = new Usuario("juani", "juani@mail", "12345");

        List<ChatMensaje> chatMensajes = new ArrayList<>();

        ChatMensaje chatMensaje1 = new ChatMensaje(solicitud.getCodigo(), usuario, "Contenido del mensaje");
        ChatMensaje chatMensaje2 = new ChatMensaje(solicitud.getCodigo(), usuario, "Contenido del mensaje 2");
        ChatMensaje chatMensaje3 = new ChatMensaje(solicitud.getCodigo(), usuario, "Contenido del mensaje 3");

        chatMensajes.add(chatMensaje1);
        chatMensajes.add(chatMensaje2);
        chatMensajes.add(chatMensaje3);

        return chatMensajes;
    }

}
