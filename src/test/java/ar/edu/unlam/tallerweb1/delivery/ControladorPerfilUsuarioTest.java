package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Mensajes.ServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
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



    @Before
    public void init(){
        this.servicioUsuario = mock(ServicioUsuario.class);
        this.servicioPublicacion = mock(ServicioPublicacion.class);
        this.servicioMensajes = mock(ServicioMensajes.class);
        this.servicioAuth = mock(ServicioAuth.class);
        this.controladorPerfilUsuario = new ControladorPerfilUsuario(this.servicioUsuario, this.servicioPublicacion, this.servicioMensajes, this.servicioAuth);
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
