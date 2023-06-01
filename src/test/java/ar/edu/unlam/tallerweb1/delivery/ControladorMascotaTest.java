package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.dto.MascotaDto;
import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.auth.ServicioSesion;
import ar.edu.unlam.tallerweb1.domain.mascota.ServicioMascota;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Before;
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
public class ControladorMascotaTest {

    @Mock
    private ServicioMascota servicioMascota;
    @Mock
    private ServicioAuth servicioAuth;
    @Mock
    private ServicioSesion servicioSesion;
    @Mock
    HttpServletRequest request;
    @InjectMocks
    private ControladorMascota controladorMascota;

    private Usuario userAuth;

    @Before
    public void init(){
        this.userAuth = new Usuario("Ariel", "ariel@ariel", "12345");
    }


    @Test
    public void alIngresarMascotaDesdeMiPefilAlfinalizarCorrectamenteElIngresoMellevaNuevamenteAMiPerfil() {
        MascotaDto mascota = dadoQueExisteMascotaEnPerfil();
        ModelAndView mav = cuandoIngresoLaMascota(mascota);
        entoncesElIngresoEsExitosoYMeLlevaAlPerfil(mav);
    }
    @Test
    public void alIngresarMascotaDesdePublicacionAlfinalizarCorrectamenteElIngresoMellevaNuevamenteAPublicacion() {
        MascotaDto mascota = dadoQueExisteMascotaEnPublicacion();
        ModelAndView mav = cuandoIngresoLaMascota(mascota);
        entoncesElIngresoEsExitosoYMeLlevaAPublicacion(mav);
    }


    @Test
    public void alNoIngresarLosDatosRequeridosDeLaMascotaNoSePuedeGuardarLaMismaYMeVuelveAlFormularioParaIngresarMascota()
    {
        MascotaDto mascota = dadoQueExisteUnaMascotaIncompleta();
        ModelAndView mav = cuandoIngresoLaMascota(mascota);
        entoncesElIngresoNoEsExitoso(mav);

    }

    private MascotaDto dadoQueExisteMascotaEnPerfil() {

        MascotaDto mascotadto = new MascotaDto();
        String target = "perfil";
        when(this.servicioSesion.getAtributoDeSesion("target")).thenReturn(target);

        return mascotadto;

    }

    private MascotaDto dadoQueExisteMascotaEnPublicacion() {

        MascotaDto mascotadto = new MascotaDto();
        String target = "publicacion";
        when(this.servicioSesion.getAtributoDeSesion("target")).thenReturn(target);

        return mascotadto;

    }

    private ModelAndView cuandoIngresoLaMascota(MascotaDto mascotadto) {

        when(this.servicioAuth.getUsuarioAutenticado()).thenReturn(userAuth);
        when(this.request.getContextPath()).thenReturn("adoptapp");
        return controladorMascota.guardarMascota(mascotadto, request);

    }

    private void entoncesElIngresoEsExitosoYMeLlevaAlPerfil(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo( "redirect: adoptapp/perfil/actividad/mascotas");

    }

    private void entoncesElIngresoEsExitosoYMeLlevaAPublicacion(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo( "redirect: adoptapp/publicacion/crear");

    }

    private MascotaDto dadoQueExisteUnaMascotaIncompleta() {

        MascotaDto mascotadto = new MascotaDto();

        when(servicioMascota.guardar(mascotadto,this.userAuth)).thenReturn(null);

        return mascotadto;
    }



    private void entoncesElIngresoNoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo( "new-mascot");
    }


    private void dadoQueExisteMascotas(Usuario usuario) {

        when(servicioMascota.listarMascotaPorUsuario(usuario)).thenReturn(new ArrayList<Mascota>());

    }




}
