package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.domain.Mensajes.ServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorMensajesTest {

    private ServicioMensajes servicioMensajes;

    private ServicioAuth servicioAuth;

    private ControladorMensajes controladorMensajes;
    private HttpServletRequest request;

    @Before
    public void init(){
        this.servicioMensajes = mock(ServicioMensajes.class);
        this.servicioAuth = mock(ServicioAuth.class);
        this.request = mock(HttpServletRequest.class);
        this.controladorMensajes = new ControladorMensajes(this.servicioMensajes, this.servicioAuth);

    }

    @Test
    public void alEnviarseUnMensajeDeFormaCorrectaDebeRedireccionarConREspuestaSuccess(){
        MensajeDto msj = dadoQueExisteUnMensajeParaSerEnviado();
        ModelAndView view = alEnviarlo(msj);
        obtenemosLaRespuestaCorrecta(view, "redirect: adoptapp/publicacion/ver?pid=10&msj_response=success");
    }

    @Test
    public void alResponderUnMensajeDebeRedireccionarConRespuestaSuccess(){
        MensajeDto msj = dadoQueExisteUnMensajeParaSerRespondido();
        ModelAndView view = alResponderlo(msj);
        obtenemosLaRespuestaCorrecta(view, "redirect: adoptapp/perfil/mensajes?pid=10&response=success");
    }

    @Test
    public void alResponderUnMensajeYOcurrirUnErrorDebeRedireccionarConRespuestaError(){
        MensajeDto msj = dadoQueExisteUnMensajeParaSerRespondido();
        ModelAndView view = alResponderloConError(msj);
        obtenemosLaRespuestaCorrecta(view, "redirect: adoptapp/perfil/mensajes?pid=10&response=error");
    }

    @Test
    public void alEliminarUnaRespuestaDebeRedireccionarConRespuestaDeleted(){
        MensajeDto msj = dadoQueExisteUnMensajeRespondido();
        ModelAndView view = alEliminarLaRespuesta(msj);
        obtenemosLaRespuestaCorrecta(view, "redirect: adoptapp/perfil/mensajes?pid=10&response=deleted");
    }

    @Test
    public void siOcurreErroralEliminarUnaRespuestaDebeRedireccionarConRespuestaError(){
        MensajeDto msj = dadoQueExisteUnMensajeRespondido();
        ModelAndView view = alEliminarLaRespuestaConError(msj);
        obtenemosLaRespuestaCorrecta(view, "redirect: adoptapp/perfil/mensajes?pid=10&response=error");
    }

    private ModelAndView alEliminarLaRespuestaConError(MensajeDto msj) {
        when(this.request.getContextPath()).thenReturn("adoptapp");
        when(this.servicioMensajes.eliminarRespuesta(anyLong())).thenThrow(PersistenceException.class);
        return this.controladorMensajes.eliminarRespuesta(msj.getId(), msj.getPublicacion().getId(), this.request);
    }

    private ModelAndView alEliminarLaRespuesta(MensajeDto msj) {
        when(this.request.getContextPath()).thenReturn("adoptapp");
        return this.controladorMensajes.eliminarRespuesta(msj.getId(), msj.getPublicacion().getId(), this.request);
    }

    private MensajeDto dadoQueExisteUnMensajeRespondido() {
        Publicacion p = new Publicacion();
        p.setId(10L);
        MensajeDto msjDto = new MensajeDto();
        msjDto.setId(2L);
        msjDto.setPublicacion(p);
        msjDto.setEmisor(new Usuario("test","test@test","1234"));
        msjDto.setPregunta("pasara el Test?");
        msjDto.setRespuesta("esto es una respuesta");
        msjDto.setFechaRespuesta(Timestamp.from(Instant.now()));
        return msjDto;
    }

    private ModelAndView alResponderloConError(MensajeDto msj) {
        when(this.request.getContextPath()).thenReturn("adoptapp");
        when(this.servicioMensajes.responderMensaje(anyObject())).thenThrow(PersistenceException.class);
        return this.controladorMensajes.responderMensaje(msj, this.request);
    }

    private ModelAndView alResponderlo(MensajeDto msj) {
        when(this.request.getContextPath()).thenReturn("adoptapp");
        return this.controladorMensajes.responderMensaje(msj, this.request);
    }

    private MensajeDto dadoQueExisteUnMensajeParaSerRespondido() {
        Publicacion p = new Publicacion();
        p.setId(10L);

        MensajeDto msjDto = new MensajeDto();
        msjDto.setPublicacion(p);
        msjDto.setEmisor(new Usuario("test","test@test","1234"));
        msjDto.setPregunta("pasara el Test?");
        return msjDto;
    }

    private void obtenemosLaRespuestaCorrecta(ModelAndView view, String respuesta) {
        assertThat(view.getViewName()).isEqualTo(respuesta);
    }

    private ModelAndView alEnviarlo(MensajeDto msj) {
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(new Usuario("juan", "test","1234"));
        when(this.servicioMensajes.enviarMensaje(anyObject())).thenReturn(1L);
        when(this.request.getContextPath()).thenReturn("adoptapp");
        return this.controladorMensajes.enviarMensaje(msj, this.request);
    }

    private MensajeDto dadoQueExisteUnMensajeParaSerEnviado() {
        Publicacion p = new Publicacion();
        p.setId(10L);

        MensajeDto msjDto = new MensajeDto();
        msjDto.setPublicacion(p);
        msjDto.setPregunta("pasara el Test?");
        return msjDto;
    }


}