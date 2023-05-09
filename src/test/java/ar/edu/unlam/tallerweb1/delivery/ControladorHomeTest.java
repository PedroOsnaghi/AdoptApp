package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorHomeTest {

    private ControladorHome controladorHome;

    private HttpSession session;

    private Usuario usuario;

    @Before
    public void init(){
        session = mock(HttpSession.class);
        controladorHome = new ControladorHome();
    }

    @Test
    public void alAccederAlHomeSinEstarAutenticadoDebeEnviarALogin(){
        dadoQueNoHayUsuarioAutenticado();
        ModelAndView vista = alAccederAlHome();
        debeEnviarAlLogin(vista);
    }

    @Test
    public void alAccederAlHomeEstandoAutenticadoDebeMostrarElHome(){
        dadoQueHayUsuarioAutenticado();
        ModelAndView vista = alAccederAlHome();
        debeEnviarAlHome(vista);
    }

    private void debeEnviarAlHome(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("feed");
    }

    private void dadoQueHayUsuarioAutenticado() {
        usuario = new Usuario();
        usuario.setId(100L);
        usuario.setNombre("Pedro Osnaghi");
        usuario.setEmail("osnaghi@gmail.com");
        when(session.getAttribute("usuario-autenticado")).thenReturn(usuario);
    }

    private void debeEnviarAlLogin(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("redirect:/login");
    }

    private ModelAndView alAccederAlHome() {
        return controladorHome.home(session);
    }

    private void dadoQueNoHayUsuarioAutenticado() {
        when(session.getAttribute("usuario-autenticado")).thenReturn(null);
    }


}
