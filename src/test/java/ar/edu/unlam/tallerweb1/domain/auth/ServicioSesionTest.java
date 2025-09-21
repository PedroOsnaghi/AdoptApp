package ar.edu.unlam.tallerweb1.domain.auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;


import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ServicioSesionTest {
    @Mock
    private HttpSession session;

    @InjectMocks
    private ServicioSesion servicioSesion;

    @Test
    public void eliminarSesion_deberiaInvalidarLaSesion() {
        servicioSesion.eliminarSesion();
        verify(session).invalidate();
    }

    @Test
    public void setTiempoSesion_deberiaSetearElTiempoDeInactividadMaximo() {
        int tiempo = 3600; // 1 hora
        servicioSesion.setTiempoSesion(tiempo);
        verify(session).setMaxInactiveInterval(tiempo);
    }

    @Test
    public void setAtributoEnSesion_deberiaSetearElAtributoEnLaSesion() {
        String clave = "usuarioAutenticado";
        Object valor = new Object();

        servicioSesion.setAtributoEnSesion(clave, valor);
        verify(session).setAttribute(clave, valor);
    }

    @Test
    public void getAtributoDeSesion_deberiaObtenerElAtributoDeLaSesion() {
        String clave = "usuarioAutenticado";

        servicioSesion.getAtributoDeSesion(clave);
        verify(session).getAttribute(clave);
    }

}