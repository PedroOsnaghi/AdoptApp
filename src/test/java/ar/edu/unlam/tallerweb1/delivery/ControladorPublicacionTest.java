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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPublicacionTest {
    @Mock
    private ServicioPublicacion servicioPublicacion;
    @Mock
    HttpServletRequest request;
    @InjectMocks
    ControladorPublicacion controladorPublicacion;

    @Test
    public void alPedirTodasLasPublicacionesDevuelveLaListaCompleta() {
        List<Publicacion> datosPublicacion = dadoQueTengoDatosDePublicacionValidos();
        ModelAndView vista = cuandoQuieroVerTodasLasPublicaciones(datosPublicacion);
        entoncesMeDevuelveLaVistaCorrecta(vista);
    }

    @Test
    public void testAlGuardarPublicacion() {
        DatosPublicacion publicacion = dadoQueTengoDatosDePublicacion();
        ModelAndView vista = cuandoQuieroGuardarPublicacion(publicacion);
        entoncesMeDevuelveLaVistaCorrecta(vista);
    }



    private DatosPublicacion dadoQueTengoDatosDePublicacion() {
        DatosPublicacion publicacion = new DatosPublicacion();
        publicacion.setCuerpo("Cuerpo");
        publicacion.setTitulo("Titulo");
        publicacion.setMascotaId(1L);
        publicacion.setAutorId(1L);
        publicacion.setFechaCreacion(new Date());
        return publicacion;
    }
    private ModelAndView cuandoQuieroGuardarPublicacion(DatosPublicacion datosPublicacion) {
        return controladorPublicacion.guardarPublicacion(datosPublicacion, request);
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
