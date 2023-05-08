package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLoginDeprec;
import ar.edu.unlam.tallerweb1.domain.usuarios.UsuarioDeprec;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ControladorLoginDeprecTest {
    private ServicioLoginDeprec servicioLoginDeprec;
    private HttpServletRequest request;
    private HttpSession sesion;
    private ControladorLoginDeprec controladorLoginDeprec;

    @Before
    public void init() {
        servicioLoginDeprec = mock(ServicioLoginDeprec.class);
        sesion = mock(HttpSession.class);
        request = mock(HttpServletRequest.class);
        controladorLoginDeprec = new ControladorLoginDeprec(this.servicioLoginDeprec);
    }

    @Test
    public void dadoUnUsuarioExistenteQueSePuedaIniciarSesion() {

        String ROL = "admin";

        DatosLogin datosLogin = dadoQueTengoDatosDeLoginValidos();
        UsuarioDeprec usuarioDeprecEsperado = dadoQueTengoUnUsuarioConRol(ROL);

        ModelAndView vista = cuandoQuieroValidarElLogin(datosLogin, usuarioDeprecEsperado, ROL);

        entoncesMeDevuelveLaVistaCorrecta(vista);

        entoncesInicioSesion(ROL);
    }

    //Cuando

    private DatosLogin dadoQueTengoDatosDeLoginValidos() {
        return new DatosLogin();
    }

    private UsuarioDeprec dadoQueTengoUnUsuarioConRol(String rol) {
        UsuarioDeprec usuarioDeprec = new UsuarioDeprec();
        usuarioDeprec.setRol(rol);
        return usuarioDeprec;
    }

    //Dado
    private ModelAndView cuandoQuieroValidarElLogin(DatosLogin datosLogin, UsuarioDeprec usuarioDeprecEsperado, String rol) {
        when(servicioLoginDeprec.consultarUsuario(any(), any())).thenReturn(usuarioDeprecEsperado);
        when(request.getSession()).thenReturn(sesion);
        when(sesion.getAttribute("ROL")).thenReturn(rol);
        return controladorLoginDeprec.validarLogin(datosLogin, request);
    }

    //Entonces
    private static void entoncesMeDevuelveLaVistaCorrecta(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("redirect:/home");
    }
    private void entoncesInicioSesion(String rol) {
        assertThat(sesion.getAttribute("ROL")).isEqualTo(rol);
    }
}
