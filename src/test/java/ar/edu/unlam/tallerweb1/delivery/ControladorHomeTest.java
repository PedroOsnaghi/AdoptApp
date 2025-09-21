package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorHomeTest {

    private ControladorHome controladorHome;

    private ServicioPublicacion servicioPublicacion;

    private ServicioAuth servicioAuth;


    private Usuario usuario;

    @Before
    public void init(){
        this.servicioPublicacion = mock(ServicioPublicacion.class);
        this.servicioAuth = mock(ServicioAuth.class);
        this.controladorHome = new ControladorHome(this.servicioPublicacion, this.servicioAuth);
    }



    @Test
    public void alAccederAlHomeEstandoAutenticadoDebeMostrarElHome(){
       dadoQueHayUsuarioAutenticado();
       ModelAndView vista = alAccederAlHome();
       debeEnviarAlHome(vista);
   }

    @Test
    public void alAccederAFavoritosEstandoAutenticadoDebeMostrarFavoritos(){
        Usuario usuario = dadoQueHayUsuarioAutenticado();
        ModelAndView vista = alAccederAFavoritos(usuario);
        debeEnviarAFavoritos(vista);
    }

    @Test
    public void alAccederAMisPublicacionesEstandoAutenticadoDebeMostrarMisPublicaciones(){
        Usuario usuario = dadoQueHayUsuarioAutenticado();
        ModelAndView vista = alAccederAMisPublicaciones(usuario);
        debeEnviarAMisPublicaciones(vista);
    }

    @Test
    public void alAgregarUnNuevoFavoritoALaListaDebeRedirigirAlFeed(){
        dadoQueHayUsuarioAutenticado();
        ModelAndView vista = alAgregarUnFavorito();
        debeEnviarAlHome(vista);
    }



    private ModelAndView alAgregarUnFavorito() {
        Publicacion publicacion = new Publicacion();
        publicacion.setId(1L);

        when(this.servicioPublicacion.listarPublicacionesDisponibles()).thenReturn(new ArrayList<>());

        return controladorHome.agregarFavorito(publicacion.getId());
    }

    private void debeEnviarAlHome(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("index-feed");
    }

    private void debeEnviarAFavoritos(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("index-favorites");
    }

    private void debeEnviarAMisPublicaciones(ModelAndView vista) {
        assertThat(vista.getViewName()).isEqualTo("index-misposts");
    }

    private Usuario dadoQueHayUsuarioAutenticado() {
        usuario = new Usuario("Pedro Osnaghi", "osnaghi@gmail.com", "1234");
        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(usuario);
        return usuario;
    }


    private ModelAndView alAccederAlHome() {
        when(this.servicioPublicacion.listarPublicacionesDisponibles()).thenReturn(new ArrayList<>());
        return controladorHome.feed(null);
    }

    private ModelAndView alAccederAFavoritos(Usuario user) {
        when(this.servicioPublicacion.listarFavoritosDeUsuario(user.getId())).thenReturn(new ArrayList<>());
        return controladorHome.favoritos(null);
    }

    private ModelAndView alAccederAMisPublicaciones(Usuario user) {
        when(this.servicioPublicacion.listarPublicacionesPorUsuarioId(user.getId())).thenReturn(new ArrayList<>());
        return controladorHome.misPublicaciones(null);
    }




}
