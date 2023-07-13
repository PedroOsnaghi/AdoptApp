package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.domain.Solicitud.ServicioSolicitud;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.exceptions.DataValidationException;
import ar.edu.unlam.tallerweb1.domain.exceptions.SolicitudException;
import ar.edu.unlam.tallerweb1.domain.notificacion.IServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;

import ar.edu.unlam.tallerweb1.model.enumerated.GeneroMascota;
import ar.edu.unlam.tallerweb1.model.enumerated.TipoMascota;
import static org.mockito.ArgumentMatchers.anyObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControladorSolicitudTest {

    @Mock
    ServicioSolicitud servicioSolicitud;

    @Mock
    IServicioAuth servicioAuth;

    @Mock
    HttpServletRequest request;

    @Mock
    IServicioNotificacion servicioNotificacion;

    @Mock
    IServicioPublicacion servicioPublicacion;

    @InjectMocks
    ControladorSolicitud controladorSolicitud;

    @Test
    public void TestQueSePuedaAceptarSolicitud() {
        Usuario usuarioDuenio = new Usuario("Usuario Test", "test@test", "1234");
        usuarioDuenio.setId(1L);
        Solicitud solicitud = dadoQueExisteUnaSolicitud(usuarioDuenio);
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuarioDuenio);
        when(this.servicioSolicitud.getSolicitud(anyString())).thenReturn(solicitud);

        controladorSolicitud.aceptarSolicitud(solicitud.getCodigo(), "", request);

        verify(servicioSolicitud, times(1)).aceptarSolicitud(solicitud, servicioAuth.getUsuarioAutenticado());
    }

    @Test
    public void TestQueSeLanzeExcepcionAlAceptarSolicitudConUsuarioNoPropietarioYDevuelveAlHomeConMensajeError() {
        Usuario usuarioDuenio = new Usuario("Usuario Test", "test@test", "1234");
        usuarioDuenio.setId(1L);
        Usuario usuarioNoDuenio = new Usuario("Usuario No Duenio", "test@noduenio", "1234");
        usuarioDuenio.setId(1L);

        Solicitud solicitud = dadoQueExisteUnaSolicitud(usuarioDuenio);

        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuarioNoDuenio);
        when(this.servicioSolicitud.getSolicitud(anyString())).thenReturn(solicitud);

        doThrow(SolicitudException.class).when(this.servicioSolicitud).aceptarSolicitud(anyObject(), anyObject());

        when(this.request.getContextPath()).thenReturn("adoptapp");

        ModelAndView vista = controladorSolicitud.aceptarSolicitud(solicitud.getCodigo(), "", request);

        verify(servicioSolicitud, times(1)).aceptarSolicitud(solicitud, servicioAuth.getUsuarioAutenticado());

        assertThat(vista.getViewName()).isEqualTo("redirect: adoptapp/home?response=error#1001");
    }

    @Test
    public void TestQueSeAceptaSolicitudYDevuelvaALaVistaCorrecta() {
        Usuario usuarioDuenio = new Usuario("Usuario Test", "test@test", "1234");
        usuarioDuenio.setId(1L);
        Solicitud solicitud = dadoQueExisteUnaSolicitud(usuarioDuenio);
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuarioDuenio);
        when(this.servicioSolicitud.getSolicitud(anyString())).thenReturn(solicitud);


        ModelAndView vista = controladorSolicitud.aceptarSolicitud(solicitud.getCodigo(), "perfil-solicitud", request);

        verify(servicioSolicitud, times(1)).aceptarSolicitud(solicitud, servicioAuth.getUsuarioAutenticado());
        assertThat(vista.getViewName()).isEqualTo("redirect: " + request.getContextPath() + "/perfil/solicitud?pid=2");
    }

    @Test
    public void TestQueSeCancelaSolicitudYDevuelveALaVistaCorrecta() {
        Usuario usuarioDuenio = new Usuario("Usuario Test", "test@test", "1234");
        usuarioDuenio.setId(1L);
        Solicitud solicitud = dadoQueExisteUnaSolicitud(usuarioDuenio);
        when(this.servicioSolicitud.getSolicitud(anyString())).thenReturn(solicitud);

        ModelAndView vista = controladorSolicitud.cancelarSolicitud(solicitud.getCodigo(), "", request);

        verify(servicioSolicitud, times(1)).cancelarSolicitud(solicitud);
        assertThat(vista.getViewName()).isEqualTo("redirect: " + request.getContextPath() + "/home");
    }

    @Test
    public void TestQueSeLanzeExcepcionAlenviarSolicitudYDevuelveUnMensajeDeError() {
        Usuario usuarioDuenio = new Usuario("Usuario Test", "test@test", "1234");
        usuarioDuenio.setId(1L);

        Publicacion publicacion = new Publicacion();
        publicacion.setId(10L);

        SolicitudDto solicitud = new SolicitudDto();
        solicitud.setPublicacionSol(publicacion);

        doThrow(DataValidationException.class).when(this.servicioSolicitud).enviarSolicitud(anyObject());

        when(this.request.getContextPath()).thenReturn("adoptapp");

        ModelAndView vista = controladorSolicitud.enviarSolicitud(solicitud, request);

        verify(servicioSolicitud, times(1)).enviarSolicitud(solicitud);

        assertThat(vista.getViewName()).isEqualTo("redirect: " + request.getContextPath() + "/publicacion/ver?pid=10&sol_response=error");
    }

    @Test
    public void TestAlEnviarSolicitudYDevuelveMensajeDeExito() {
        Usuario usuarioDuenio = new Usuario("Usuario Test", "test@test", "1234");
        usuarioDuenio.setId(1L);

        Publicacion publicacion = new Publicacion();
        publicacion.setId(10L);

        SolicitudDto solicitud = new SolicitudDto();
        solicitud.setPublicacionSol(publicacion);

        when(this.request.getContextPath()).thenReturn("adoptapp");


        ModelAndView vista = controladorSolicitud.enviarSolicitud(solicitud, request);

        verify(servicioSolicitud, times(1)).enviarSolicitud(solicitud);

        assertThat(vista.getViewName()).isEqualTo("redirect: " + request.getContextPath() + "/publicacion/ver?pid=10&sol_response=success");
    }

    private Solicitud dadoQueExisteUnaSolicitud(Usuario usuario) {
        Mascota mascota = new Mascota();
        mascota.setUsuario(usuario);
        mascota.setNombre("PEPITO");
        mascota.setTipo(TipoMascota.PERRO);
        mascota.setGenero(GeneroMascota.HEMBRA);

        Publicacion publicacion = new Publicacion();
        publicacion.setBio("Test");
        publicacion.setId(2L);
        publicacion.setMascota(mascota);

        Solicitud solicitud = new Solicitud();
        solicitud.setCodigo("1234");
        solicitud.setPublicacion(publicacion);

        return solicitud;
    }
}