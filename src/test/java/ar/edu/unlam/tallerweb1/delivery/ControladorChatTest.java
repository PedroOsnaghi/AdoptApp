package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.chat.IServicioChat;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.dom4j.rule.Mode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ControladorChatTest {
    @Mock
    private IServicioChat serviciochat;
    @Mock
    private IServicioPublicacion servicioPublicacion;
    @Mock
    private IServicioAuth servicioAuth;
    @InjectMocks
    private ControladorChat controladorChat;

    private Timestamp horaActual = Timestamp.from(Instant.now());




    @Test
    public void alEnviarUnMensajeCorrectamenteDevuelveOkYHoraEnBody()
    {
        Solicitud solicitud = dadoQueExisteUnMensajeParaSerEnviado();
        ResponseEntity<Timestamp> responseEntity = alEnviarlo(solicitud);
        obtenemosLaRespuestaCorrecta(responseEntity);

    }

    @Test
    public void alrefrescarLaListaDeMensajeMeDevuelveLaVistaCorrespondiente()
    {
        Solicitud solicitud = dadoQueExisteUnaSolicitud();
        ModelAndView vista = AlRefrescar(solicitud);
        obtengoLaVistaCorrecta(vista);
    }

    private void obtengoLaVistaCorrecta(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("partials/chat-list");
    }

    private ModelAndView AlRefrescar(Solicitud solicitud) {
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(new Usuario());
        when(this.serviciochat.listarMensajesDeSolicitud(anyString())).thenReturn(new ArrayList<>());
        return this.controladorChat.refresh(solicitud.getCodigo());
    }

    private Solicitud dadoQueExisteUnaSolicitud() {
        Solicitud solicitud = new Solicitud();
        solicitud.setCodigo("1234");
        return solicitud;
    }

    private Solicitud dadoQueExisteUnMensajeParaSerEnviado() {
        Usuario user = new Usuario("Usuario Test", "test@test", "1234");
        user.setId(1L);
        Solicitud solicitud = new Solicitud();
        solicitud.setUsuario(user);
        solicitud.setCodigo("1234");

        return solicitud;

    }

    private ResponseEntity<Timestamp> alEnviarlo(Solicitud solicitud) {
        when(this.serviciochat.enviarMensaje(anyString(), anyObject(), anyString())).thenReturn(horaActual);
        return this.controladorChat.enviarMensaje(solicitud.getCodigo(), "Hola");
    }

    private void obtenemosLaRespuestaCorrecta(ResponseEntity<Timestamp> responseEntity) {
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(horaActual);
    }

}
