package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPublicacionTest {
    @Mock
    private ServicioPublicacion servicioPublicacion;
    @InjectMocks
    ControladorPublicacion controladorPublicacion;

    @Test
    public void alPedirTodasLasPublicacionesDevuelveLaListaCompleta() {
        List<Publicacion> datosPublicacion = dadoQueTengoDatosDePublicacionValidos();
        ModelAndView vista = cuandoQuieroVerTodasLasPublicaciones(datosPublicacion);
        entoncesMeDevuelveLaVistaCorrecta(vista);
    }

    private List<Publicacion> dadoQueTengoDatosDePublicacionValidos() {
        return servicioPublicacion.listarPublicaciones();
    }

    private ModelAndView cuandoQuieroVerTodasLasPublicaciones(List<Publicacion> datosPublicacion) {
        when(servicioPublicacion.listarPublicaciones()).thenReturn(datosPublicacion);
        return controladorPublicacion.verPublicacionesFeed();
    }

    private static void entoncesMeDevuelveLaVistaCorrecta(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("index-feed");
    }
}
