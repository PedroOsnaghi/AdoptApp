package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServicioSolicitudTest extends SpringTest {

    @Mock
    private IRepositorioSolicitud repositorioSolicitud;

    @InjectMocks
    private ServicioSolicitud servicioSolicitud;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEnviarSolicitud() {
        dadoQueSeEnviaUnaSolicitud();
        seLLamaAlRepositorioParaGuardarLaSolicitud();
    }

    @Test
    public void testCancelarSolicitud() {
        dadoQueSeCancelaUnaSolicitud();
        seLLamaAlRepositorioParaCancelarLaSolicitud();
    }

    @Test
    public void testGetSolicitudDeUsuarioPorPublicacion() {
        Publicacion publicacion = new Publicacion();
        Usuario usuario = new Usuario();
        Solicitud solicitud = dadoQueUnUsuarioSolicitoUnaPublicacion(publicacion, usuario);

        when(repositorioSolicitud.getSolicitudDeUsuarioPorPublicacion(publicacion, usuario)).thenReturn(solicitud);
        Solicitud solicitudObtenida = alBuscarLaSolicitudDeUnUsuarioPorUnaPublicacion(publicacion, usuario);

        seObtieneLaSolicitudHecha(solicitud, solicitudObtenida);
    }

    @Test
    public void testListarSolicitudesEnviadas() {
        Usuario usuario = dadoQueExisteUnUsuarioQueEnvioSolicitudes();
        List<Solicitud> solicitudes = dadoQueElUsuarioEnvioSolicitudes(usuario);

        List<Solicitud> solicitudesObtenidas = alListarLasSolicitudesEnviadasPorElUsuario(usuario);

        seObtienenLasSolicitudesEnviadas(solicitudes, solicitudesObtenidas, usuario);
        verify(repositorioSolicitud, times(1)).listarSolicitudesEnviadas(usuario.getId());
    }

    @Test
    public void testListarSolicitudesRecibidas() {
        Usuario usuario = dadoQueExisteUnUsuarioQueRecibioSolicitudes();
        List<Solicitud> solicitudes = dadoQueElUsuarioRecibioSolicitudes(usuario);

        List<Solicitud> solicitudesObtenidas = alListarLasSolicitudesRecibidasPorElUsuario(usuario, solicitudes);

        seObtienenLasSolicitudesRecibidas(solicitudes, solicitudesObtenidas, usuario);

    }

    private void seLLamaAlRepositorioParaGuardarLaSolicitud() {
        verify(repositorioSolicitud, times(1)).guardarSolicitud(any(Solicitud.class));
    }

    private void dadoQueSeEnviaUnaSolicitud() {
        SolicitudDto solicitudDto = new SolicitudDto();
        servicioSolicitud.enviarSolicitud(solicitudDto);
    }

    private void dadoQueSeCancelaUnaSolicitud() {
        Solicitud solicitud = new Solicitud();
        servicioSolicitud.cancelarSolicitud(solicitud);
    }

    private void seLLamaAlRepositorioParaCancelarLaSolicitud() {
        verify(repositorioSolicitud, times(1)).cancelarSolicitud(any(Solicitud.class));
    }

    private Solicitud dadoQueUnUsuarioSolicitoUnaPublicacion(Publicacion publicacion, Usuario usuario) {
        Solicitud solicitud = new Solicitud();
        solicitud.setPublicacion(publicacion);
        solicitud.setUsuario(usuario);
        return solicitud;
    }

    private Solicitud alBuscarLaSolicitudDeUnUsuarioPorUnaPublicacion(Publicacion publicacion, Usuario usuario) {
        return servicioSolicitud.getSolicitudDeUsuarioPorPublicacion(publicacion, usuario);
    }

    private void seObtieneLaSolicitudHecha(Solicitud solicitud, Solicitud solicitudObtenida) {
        assertEquals(solicitud, solicitudObtenida);
    }

    private Usuario dadoQueExisteUnUsuarioQueEnvioSolicitudes() {
        Usuario usuario = new Usuario();
        usuario.setId(new Random().nextLong());


        return usuario;
    }

    private List<Solicitud> alListarLasSolicitudesEnviadasPorElUsuario(Usuario usuario) {
        return servicioSolicitud.listarSolicitudesEnviadas(usuario);
    }

    private List<Solicitud> dadoQueElUsuarioEnvioSolicitudes(Usuario usuario) {
        List<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(new Solicitud());
        solicitudes.add(new Solicitud());
        solicitudes.add(new Solicitud());

        when(repositorioSolicitud.listarSolicitudesEnviadas(usuario.getId())).thenReturn(solicitudes);

        return solicitudes;
    }

    private void seObtienenLasSolicitudesEnviadas(List<Solicitud> solicitudes, List<Solicitud> solicitudesObtenidas, Usuario usuario) {
        assertEquals(solicitudes, solicitudesObtenidas);
        verify(repositorioSolicitud, times(1)).listarSolicitudesEnviadas(usuario.getId());
    }

    private Usuario dadoQueExisteUnUsuarioQueRecibioSolicitudes() {
        Usuario usuario = new Usuario();
        usuario.setId(new Random().nextLong());
        return usuario;
    }

    private List<Solicitud> dadoQueElUsuarioRecibioSolicitudes(Usuario usuario) {
        List<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(new Solicitud());
        solicitudes.add(new Solicitud());
        solicitudes.add(new Solicitud());

        when(repositorioSolicitud.listarSolicitudesRecibidas(usuario.getId())).thenReturn(solicitudes);

        return solicitudes;
    }

    private List<Solicitud> alListarLasSolicitudesRecibidasPorElUsuario(Usuario usuario, List<Solicitud> solicitudes) {
        return servicioSolicitud.listarSolicitudesRecibidas(usuario);
    }

    private void seObtienenLasSolicitudesRecibidas(List<Solicitud> solicitudes, List<Solicitud> solicitudesObtenidas, Usuario usuario) {
        assertEquals(solicitudes, solicitudesObtenidas);
        verify(repositorioSolicitud, times(1)).listarSolicitudesRecibidas(usuario.getId());
    }
}