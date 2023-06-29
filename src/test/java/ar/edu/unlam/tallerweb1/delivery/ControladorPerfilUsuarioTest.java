package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Calificacion.ServicioCalificacion;
import ar.edu.unlam.tallerweb1.domain.Mensajes.ServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.Solicitud.ServicioSolicitud;
import ar.edu.unlam.tallerweb1.domain.adopcion.ServicioAdopcion;
import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.mascota.ServicioMascota;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorPerfilUsuarioTest  {


    private ControladorPerfilUsuario controladorPerfilUsuario;

    private ServicioUsuario servicioUsuario;

    private ServicioPublicacion servicioPublicacion;

    private ServicioMensajes servicioMensajes;

    private ServicioAuth servicioAuth;

    private ServicioMascota servicioMascota;

    private ServicioCalificacion servicioCalificacion;

    private ServicioSolicitud servicioSolicitud;
    private ServicioAdopcion servicioAdopcion;


    @Before
    public void init(){
        this.servicioUsuario = mock(ServicioUsuario.class);
        this.servicioPublicacion = mock(ServicioPublicacion.class);
        this.servicioMensajes = mock(ServicioMensajes.class);
        this.servicioAuth = mock(ServicioAuth.class);
        this.servicioCalificacion = mock(ServicioCalificacion.class);
        this.servicioMascota = mock(ServicioMascota.class);
        this.servicioSolicitud = mock(ServicioSolicitud.class);
        this.servicioAdopcion = mock(ServicioAdopcion.class);
        this.controladorPerfilUsuario = new ControladorPerfilUsuario(this.servicioUsuario, this.servicioPublicacion, this.servicioMensajes, this.servicioAuth, this.servicioCalificacion,this.servicioMascota, this.servicioSolicitud, this.servicioAdopcion);
    }

    @Test
    public void cuandoUnUsuarioAutenticadoQuiereAccederALaActividadDeSuPerfil(){
        Usuario usuarioLogueado = dadoQueExisteUnUsuarioAutenticado();
        ModelAndView vista = alAccederALaActividadDeSuPerfil(usuarioLogueado);
        debeObtenerLaVistaCorrecta(vista, "user-profile-activity-posts");
    }


    @Test
    public void cuandoUnUsuarioAutenticadoQuiereAccederASusMensajes(){
        Usuario usuario = dadoQueExisteUnUsuarioAutenticado();
        ModelAndView vista = alAccederALosMensajes(usuario);
        debeObtenerLaVistaCorrecta(vista, "user-profile-messages");
    }

    @Test
    public void cuandoUnUsuarioAutenticadoQuereAccederAsuInfoDePerfil(){
        Usuario usuario = dadoQueExisteUnUsuarioAutenticado();
        ModelAndView vista = alAccederASuInformacion(usuario);
        debeObtenerLaVistaCorrecta(vista,"user-profile-info");
    }

    @Test
    public void cuandoUnUsuarioAutenticadoQuereEditarSuInfoDePerfil(){
        Usuario usuario = dadoQueExisteUnUsuarioAutenticado();
        ModelAndView vista = alAccederAEditarSuInfo(usuario);
        debeObtenerLaVistaCorrecta(vista,"user-profile-edit");
    }

    @Test
    public void cuandoUnUsuarioAutenticadoQuereAccederALasSolicitudes(){
        Usuario usuario = dadoQueExisteUnUsuarioAutenticado();
        ModelAndView vista = alAccederASolicitudes(usuario);
        debeObtenerLaVistaCorrecta(vista,"user-profile-request");
    }

    private ModelAndView alAccederASolicitudes(Usuario usuario) {
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuario);
        return this.controladorPerfilUsuario.solicitudesUsuario(null);
    }

    private ModelAndView alAccederAEditarSuInfo(Usuario usuario) {
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuario);
        return this.controladorPerfilUsuario.irAEditarDatos();
    }

    private ModelAndView alAccederASuInformacion(Usuario usuario) {
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuario);
        return this.controladorPerfilUsuario.infoUsuario();
    }


    private void debeObtenerLaVistaCorrecta(ModelAndView vista, String nombre_vista) {
        assertThat(vista.getViewName()).isEqualTo(nombre_vista);
    }

    private ModelAndView alAccederALaActividadDeSuPerfil(Usuario usuarioLogueado) {

        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuarioLogueado);

        return this.controladorPerfilUsuario.misPublicaciones();
    }

    private Usuario dadoQueExisteUnUsuarioAutenticado() {
        return new Usuario("Usuario Test", "test@test", "1234");
    }



    private ModelAndView alAccederALosMensajes(Usuario usuarioLogueado) {

        Long usuarioId = usuarioLogueado != null ? usuarioLogueado.getId() : null;

        when(this.servicioPublicacion.listarPublicacionesMensajesPorUsuarioId(usuarioId)).thenReturn(new ArrayList<>());
        when(this.servicioMensajes.listarMensajesSinResponder(null)).thenReturn(new ArrayList<>());
        when(this.servicioMensajes.listarMensajesRespondidos(null)).thenReturn(new ArrayList<>());
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuarioLogueado);

        return this.controladorPerfilUsuario.verMensajes(null, null);
    }




}
