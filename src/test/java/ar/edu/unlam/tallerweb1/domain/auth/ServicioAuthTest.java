package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.domain.usuarios.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import java.util.Base64;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServicioAuthTest {

    @Mock
    private IRepositorioUsuario repositorioUsuario;

    @Mock
    private IServicioSesion servicioSesion;

    @InjectMocks
    private ServicioAuth servicioAuth;

    @Test
    public void validarCredenciales_debeDevolverFalseSiUsuarioEsNull() {
        Usuario usuario = null;
        String password = "password";

        boolean resultado = servicioAuth.validarCredenciales(usuario, password);

        assertFalse(resultado);
    }

    @Test
    public void validarCredenciales_debeDevolverTrueSiPasswordEsCorrecta() {
        Usuario usuario = new Usuario();
        String password = servicioAuth.encriptarPassword("password");
        usuario.setPassword(password);

        boolean resultado = servicioAuth.validarCredenciales(usuario, "password");

        assertTrue(resultado);
    }

    @Test
    public void validarCredenciales_debeDevolverFalseSiPasswordNoEsCorrecta() {
        Usuario usuario = new Usuario();
        usuario.setPassword("passwordSinHash");
        String password = "password";

        boolean resultado = servicioAuth.validarCredenciales(usuario, password);

        assertFalse(resultado);
    }

    @Test
    public void encriptarPassword_debeDevolverPasswordEnBase64() {
        String password = "password";
        String passwordHasheadaEsperada = Base64.getEncoder().encodeToString(password.getBytes());

        String passwordHasheada = servicioAuth.encriptarPassword(password);

        assertEquals(passwordHasheadaEsperada, passwordHasheada);
    }

    @Test
    public void validarPasswordHasheada_debeDevolverTrueSiPasswordsSonIguales() {
        String password = "password";
        String passwordHasheada = servicioAuth.encriptarPassword(password);

        boolean resultado = servicioAuth.validarPasswordHasheada(password, passwordHasheada);

        assertTrue(resultado);
    }

    @Test
    public void validarPasswordHasheada_debeDevolverFalseSiPasswordsSonDiferentes() {
        String password1 = "password1";
        String password2 = "password2";
        String passwordHasheada = servicioAuth.encriptarPassword(password1);

        boolean resultado = servicioAuth.validarPasswordHasheada(password2, passwordHasheada);

        assertFalse(resultado);
    }

    @Test
    public void setUsuarioAutenticado_debeLlamarMetodoSetAtributoEnSesionConUsuarioAutenticado() {
        Usuario usuario = new Usuario();

        servicioAuth.setUsuarioAutenticado(usuario);

        verify(servicioSesion).setAtributoEnSesion("usuarioAutenticado", usuario);
    }

    @Test
    public void getUsuarioAutenticado_debeLlamarMetodoGetAtributoDeSesionConNombreCorrecto() {
        Usuario usuario = new Usuario();
        when(servicioSesion.getAtributoDeSesion("usuarioAutenticado")).thenReturn(usuario);

        Usuario resultado = servicioAuth.getUsuarioAutenticado();

        assertEquals(usuario, resultado);
    }

    @Test
    public void usuarioLoggeado_debeDevolverTrueSiUsuarioAutenticadoNoEsNull() {
        Usuario usuario = new Usuario();
        when(servicioSesion.getAtributoDeSesion("usuarioAutenticado")).thenReturn(usuario);

        boolean resultado = servicioAuth.usuarioLoggeado();

        assertTrue(resultado);
    }

    @Test
    public void usuarioLoggeado_debeDevolverFalseSiUsuarioAutenticadoEsNull() {
        when(servicioSesion.getAtributoDeSesion("usuarioAutenticado")).thenReturn(null);

        boolean resultado = servicioAuth.usuarioLoggeado();

        assertFalse(resultado);
    }

    @Test
    public void usuarioEsRol_debeDevolverTrueSiRolEsIgualAlRolDelUsuarioAutenticado() {
        String rol = "admin";
        Usuario usuario = new Usuario();
        usuario.setRol("admin");
        when(servicioSesion.getAtributoDeSesion("usuarioAutenticado")).thenReturn(usuario);

        boolean resultado = servicioAuth.usuarioEsRol(rol);

        assertTrue(resultado);
    }

    @Test
    public void usuarioEsRol_debeDevolverFalseSiRolNoEsIgualAlRolDelUsuarioAutenticado() {
        String rol = "user";
        Usuario usuario = new Usuario();
        usuario.setRol("admin");
        when(servicioSesion.getAtributoDeSesion("usuarioAutenticado")).thenReturn(usuario);

        boolean resultado = servicioAuth.usuarioEsRol(rol);

        assertFalse(resultado);
    }


}
