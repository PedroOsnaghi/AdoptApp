package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ServicioAuthTest {

    @Mock
    private HttpSession session;

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private ServicioAuth servicioAuth;

    @Test
    public void testValidarCredencialesPasswordCorrecta() {
        String passwordHasheada = servicioAuth.encriptarPassword("1234");
        Usuario usuario = new Usuario("John", "john@test.com", passwordHasheada);

        Mockito.when(repositorioUsuario.buscarUsuarioPorEmail("john@test.com")).thenReturn(usuario);

        boolean passwordConcuerda = servicioAuth.validarCredenciales("john@test.com", "1234");

        assertTrue(passwordConcuerda);
    }

    @Test
    public void testValidarCredencialesPasswordIncorrecta() {
        String passwordHasheada = servicioAuth.encriptarPassword("1234");
        Usuario usuario = new Usuario("John", "john@test.com", passwordHasheada);

        Mockito.when(repositorioUsuario.buscarUsuarioPorEmail("john@test.com")).thenReturn(usuario);

        boolean passwordConcuerda = servicioAuth.validarCredenciales("john@test.com", "passmala");

        assertFalse(passwordConcuerda);
    }

    @Test
    public void testEncriptarPassword() {
        String password = "password";

        String passwordConcuerda = servicioAuth.encriptarPassword(password);

        assertNotNull(passwordConcuerda);
        assertNotEquals(password, passwordConcuerda);
    }

    @Test
    public void testValidarPasswordHasheadaPasswordCorrecta() {
        String password = "password";
        String passwordHasheada = servicioAuth.encriptarPassword(password);

        boolean passwordConcuerda = servicioAuth.validarPasswordHasheada(password, passwordHasheada);

        assertTrue(passwordConcuerda);
    }

    @Test
    public void testValidarPasswordHasheadaPasswordIncorrecta() {
        String password = "password";
        String passwordHasheada = servicioAuth.encriptarPassword(password);

        boolean passwordConcuerda = servicioAuth.validarPasswordHasheada("incorrecta", passwordHasheada);

        assertFalse(passwordConcuerda);
    }

    @Test
    public void testEliminarSesion() {
        servicioAuth.eliminarSesion();
        Mockito.verify(session).invalidate();
    }

    @Test
    public void testSetUsuarioAutenticado() {
        Usuario usuario = new Usuario("John", "john@test.com", "1234");

        servicioAuth.setUsuarioAutenticado(usuario);

        Mockito.verify(session).setAttribute("usuarioAutenticado", usuario);
    }

    @Test
    public void testGetUsuarioAutenticado() {
        Usuario usuario = new Usuario("John", "john@test.com", "1234");

        Mockito.when(session.getAttribute("usuarioAutenticado")).thenReturn(usuario);

        Usuario usuarioEnSesion = servicioAuth.getUsuarioAutenticado();

        assertEquals(usuario, usuarioEnSesion);
    }

    @Test
    public void testSetTiempoSesion() {
        int tiempo = 60;

        servicioAuth.setTiempoSesion(tiempo);

        Mockito.verify(session).setMaxInactiveInterval(tiempo);
    }

    @Test
    public void testUsuarioLoggeadoTrue() {
        Usuario usuario = new Usuario("John", "john@test.com", "1234");

        Mockito.when(session.getAttribute("usuarioAutenticado")).thenReturn(usuario);

        boolean usuarioEstaLoggeado = servicioAuth.usuarioLoggeado();

        assertTrue(usuarioEstaLoggeado);
    }

    @Test
    public void testUsuarioLoggeadoFalse() {
        Mockito.when(session.getAttribute("usuarioAutenticado")).thenReturn(null);

        boolean usuarioEstaLoggeado = servicioAuth.usuarioLoggeado();

        assertFalse(usuarioEstaLoggeado);
    }

    @Test
    public void guardarAtributoEnSesionTest() {
        String clave = "clave";
        String valor = "valor";
        servicioAuth.guardarAtributoEnSesion(clave, valor);

        Mockito.verify(session).setAttribute(clave, valor);
    }

    @Test
    public void getAtributoDeSesionTest() {
        String clave = "clave";
        String valor = "valor";

        Mockito.when(session.getAttribute(clave)).thenReturn(valor);

        Object valorObtenido = servicioAuth.getAtributoDeSesion(clave);

        assertEquals(valor, valorObtenido);
        Mockito.verify(session).getAttribute(clave);
    }
}
