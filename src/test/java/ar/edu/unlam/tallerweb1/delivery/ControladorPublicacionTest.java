package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPublicacionTest {
    @Mock
    private ServicioPublicacion servicioPublicacion;

    @Mock
    HttpSession session;

    @InjectMocks
    ControladorPublicacion controladorPublicacion;

    @Test
    public void alPedirTodasLasPublicacionesDevuelveLaListaCompleta() {
        dadoQueExistenPublicaciones();
        ModelAndView vista = cuandoQuieroVerTodasLasPublicaciones();
        entoncesMeDevuelveLaVistaCorrecta(vista);
    }

    @Test
    public void testAlGuardarPublicacion() {
        DatosPublicacion publicacion = dadoQueTengoDatosDePublicacionDeUnUsuario();
        ModelAndView vista = cuandoQuieroGuardarPublicacion(publicacion);
        entoncesMeDevuelveLaVistaCorrecta(vista);
    }



    private DatosPublicacion dadoQueTengoDatosDePublicacionDeUnUsuario() {
        DatosPublicacion datosPublicacion = new DatosPublicacion();
        datosPublicacion.setTitulo("Prueba");
        datosPublicacion.setCuerpo("Esto es un Test de publicacion");

        Usuario usuario = new Usuario("juani","juani@aa","1234");



        when(session.getAttribute("usuarioAutenticado")).thenReturn(usuario);


        return datosPublicacion;
    }
    private ModelAndView cuandoQuieroGuardarPublicacion(DatosPublicacion datosPublicacion) {


        when(servicioPublicacion.guardarPublicacion(new Publicacion())).thenReturn(null);


        return controladorPublicacion.guardarPublicacion(datosPublicacion, session);
    }

    private void dadoQueExistenPublicaciones() {

        when(servicioPublicacion.listarPublicaciones()).thenReturn(new ArrayList<Publicacion>());

    }

    private ModelAndView cuandoQuieroVerTodasLasPublicaciones() {

        return controladorPublicacion.verPublicacionesFeed();
    }

    private static void entoncesMeDevuelveLaVistaCorrecta(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("index-feed");
    }
}
