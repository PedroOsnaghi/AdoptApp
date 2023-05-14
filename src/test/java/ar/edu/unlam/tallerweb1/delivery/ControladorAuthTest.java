package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControladorAuthTest {

    @Mock
    private HttpSession session;
    @Mock
    ServicioAuth servicioAuth;

    @Mock
    ServicioUsuario servicioUsuario;

    @Mock
    RepositorioUsuario repositorioUsuario;

    @InjectMocks
    ControladorAuth controladorAuth;

    @Test
    public void renderLogin_DeberiaRetornarModelAndViewConVistaLogin() {
        ModelAndView modelAndView = controladorAuth.renderLogin();

        String vistaObtenida = modelAndView.getViewName();
        assertEquals("/login", vistaObtenida);
    }

    @Test
    public void login_deberiaRetornarModelAndViewConVistaLoginYErrorCuandoCredencialesNoSonValidas() {
        LoginDto loginDto = new LoginDto();

        loginDto.setEmail("john@email.com");
        loginDto.setPassword("password");

        when(servicioAuth.validarCredenciales(loginDto.getEmail(), loginDto.getPassword())).thenReturn(false);

        ModelMap modelEsperado = new ModelMap();
        modelEsperado.put("error", "Credenciales invalidas");

        ModelAndView modelAndViewObtenido = controladorAuth.login(loginDto, session);

        String vistaObtenida = modelAndViewObtenido.getViewName();
        ModelMap modelObtenido = modelAndViewObtenido.getModelMap();

        assertEquals("/login", vistaObtenida);
        assertEquals(modelEsperado, modelObtenido);
    }

    @Test
    public void login_deberiaRetornarModelAndViewConRedirectAHomeCuandoCredencialesSonValidas() {
        String nombre = "john doe";
        String email = "john@email.com";
        String password = "password";
        Usuario usuario = new Usuario(nombre, email, password);

        LoginDto loginDto = new LoginDto();

        loginDto.setEmail("john@email.com");
        loginDto.setPassword("password");

        when(servicioAuth.validarCredenciales(loginDto.getEmail(), loginDto.getPassword())).thenReturn(true);
        when(repositorioUsuario.buscarUsuarioPorEmail(email)).thenReturn(usuario);

        //MockHttpSession inyecta una sesion falsa para que el metodo login no retorne null
        ModelAndView modelAndViewObtenido = controladorAuth.login(loginDto, session);

        String vistaObtenida = modelAndViewObtenido.getViewName();
        assertEquals("redirect:/home", vistaObtenida);
    }

    @Test
    public void cerrarSesion_deberiaRetornarModelAndViewConRedirectALogin() {
        ModelAndView modelAndViewObtenido = controladorAuth.cerrarSesion(session);

        assertEquals("redirect:/login", modelAndViewObtenido.getViewName());
    }

    @Test
    public void renderRegistrar_deberiaRetornarModelAndViewConVistaRegister() {
        ModelAndView modelAndViewObtenido = controladorAuth.renderRegistrar();

        assertEquals("register-sin-etiquetas", modelAndViewObtenido.getViewName());
    }

    @Test
    public void registrar_deberiaRetornarModelAndViewConVistaRegisterYErrorCuandoPasswordsNoCoinciden() {
        RegistrarDto registrarDto = new RegistrarDto();
        registrarDto.setNombre("John doe");
        registrarDto.setEmail("john@email.com");
        registrarDto.setPassword("password");
        registrarDto.setPassword2("password2");

        ModelMap modelEsperado = new ModelMap();
        modelEsperado.put("error", "Passwords no coinciden");

        ModelAndView modelAndViewObtenido = controladorAuth.registrar(registrarDto);
        String vistaObtenida = modelAndViewObtenido.getViewName();
        ModelMap modelObtenido = modelAndViewObtenido.getModelMap();

        assertEquals("/register-sin-etiquetas", vistaObtenida);
        assertEquals(modelEsperado, modelObtenido);
    }

    @Test
    public void registrar_deberiaRetornarModelAndViewConVistaRegisterYErrorCuandoSeProdujoUnErrorAlCrearUsuario() {
        RegistrarDto registrarDto = new RegistrarDto();
        registrarDto.setNombre("John doe");
        registrarDto.setEmail("john@email.com");
        registrarDto.setPassword("password");
        registrarDto.setPassword2("password");

        when(servicioUsuario.crearUsuario(anyString(), anyString(), anyString())).thenReturn(null);

        ModelMap modelEsperado = new ModelMap();
        modelEsperado.put("error", "Error al crear usuario");

        ModelAndView modelAndViewObtenido = controladorAuth.registrar(registrarDto);
        String vistaObtenida = modelAndViewObtenido.getViewName();
        ModelMap modelObtenido = modelAndViewObtenido.getModelMap();

        assertEquals("/register-sin-etiquetas", vistaObtenida);
        assertEquals(modelEsperado, modelObtenido);
    }
}


