package ar.edu.unlam.tallerweb1.interceptors;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InterceptorAuthTest {

    @Mock
    private IServicioAuth servicioAuth;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private InterceptorAuth interceptor;

    @Test
    public void preHandle_SinAnotacion_DeberiaRetornarTrue() throws Exception {
        HandlerMethod handlerMethod = crearHandlerMethodSinAnotacion();

        boolean resultado = interceptor.preHandle(request, response, handlerMethod);

        assertTrue(resultado);
    }

    @Test
    public void preHandle_ConAnotacion_UsuarioLoggeado_DeberiaRetornarTrue() throws Exception {
        HandlerMethod handlerMethod = crearHandlerMethodConAnotacion();
        when(servicioAuth.usuarioLoggeado()).thenReturn(true);

        boolean resultado = interceptor.preHandle(request, response, handlerMethod);

        assertTrue(resultado);
    }

    @Test
    public void preHandle_ConAnotacion_UsuarioNoLoggeado_DeberiaRedirigirALogin() throws Exception {
        HandlerMethod handlerMethod = crearHandlerMethodConAnotacion();
        when(servicioAuth.usuarioLoggeado()).thenReturn(false);

        boolean resultado = interceptor.preHandle(request, response, handlerMethod);

        //anyString porque tienen distinto contexto en la ruta
        verify(response).sendRedirect(anyString());
        assertFalse(resultado);
    }

    //metodos para crear los handler method
    private HandlerMethod crearHandlerMethodSinAnotacion() throws NoSuchMethodException {
        return new HandlerMethod(new ControladorDePrueba(), ControladorDePrueba.class.getMethod("metodoSinRequireAuth"));
    }

    private HandlerMethod crearHandlerMethodConAnotacion() throws NoSuchMethodException {
        return new HandlerMethod(new ControladorDePrueba(), ControladorDePrueba.class.getMethod("metodoConRequireAuth"));
    }

    //clase de prueba
    private static class ControladorDePrueba {
        @RequireAuth
        public void metodoConRequireAuth() {
        }

        public void metodoSinRequireAuth() {
        }
    }
}
