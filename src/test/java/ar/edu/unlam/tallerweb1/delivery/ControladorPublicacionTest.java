package ar.edu.unlam.tallerweb1.delivery;


import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControladorPublicacionTest {
    @Mock
     ServicioPublicacion servicioPublicacion;

    @Mock
     IServicioAuth servicioAuth;

    @Mock
     IServicioMascota servicioMascota;

    @Mock
     IServicioMensajes servicioMensaje;

    @Mock
     HttpSession session;

    @Mock
     HttpServletRequest request;

    @InjectMocks
    ControladorPublicacion controladorPublicacion;

    @Test
    public void testAlGuardarPublicacionExitosa() {
        PublicacionDto publicacion = dadoQueTengoDatosDePublicacionDeUnUsuario();
        ModelAndView vista = cuandoQuieroCrearPublicacion(publicacion);
        entoncesMeDevuelveLaVistaCorrecta(vista,  "redirect: adoptapp/home/mispublicaciones?pid=10");
    }

    @Test
    public void testAlGuardarPublicacionConError() {
        PublicacionDto publicacion = dadoQueTengoDatosDePublicacionDeUnUsuario();
        ModelAndView vista = cuandoQuieroCrearPublicacionConError(publicacion);
        entoncesMeDevuelveLaVistaCorrecta(vista,  "new-post");
    }

    private ModelAndView cuandoQuieroCrearPublicacionConError(PublicacionDto publicacionDto) {
        when(this.servicioPublicacion.guardarPublicacion(publicacionDto)).thenReturn(null);

        return controladorPublicacion.guardarPublicacion(publicacionDto, this.request );
    }


    private PublicacionDto dadoQueTengoDatosDePublicacionDeUnUsuario() {
        PublicacionDto publicacionDto = new PublicacionDto();
        publicacionDto.setBio("Esto es un Test de publicacion");
        return publicacionDto;
    }
    private ModelAndView cuandoQuieroCrearPublicacion(PublicacionDto publicacionDto) {

        when(this.request.getContextPath()).thenReturn("adoptapp");
        when(this.servicioPublicacion.guardarPublicacion(publicacionDto)).thenReturn(10L);

        return controladorPublicacion.guardarPublicacion(publicacionDto, this.request );
    }

    private void dadoQueExistenPublicaciones() {

        when(servicioPublicacion.listarPublicacionesDisponibles()).thenReturn(new ArrayList<>());

    }


    private void entoncesMeDevuelveLaVistaCorrecta(ModelAndView vista, String vistaEsperada) {
        assertThat(vista.getViewName()).isEqualTo(vistaEsperada);
    }
}
