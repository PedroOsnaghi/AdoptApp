package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.mascota.ServicioMascota;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
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
    HttpSession session;
    @Mock
    HttpServletRequest request;
    @InjectMocks
    private ControladorMascota controladorMascota;


    @Test
    public void alIngresarMascotaDesdeMiPefilAlfinalizarElIngresoMellevaNuevamenteAMiPerfil() {
        MascotaDto mascota = dadoQueExisteMascota();
        ModelAndView mav = cuandoIngresoLaMascota(mascota);
        entoncesElIngresoEsExitoso(mav);
    }

    @Test
    public void alNoIngresarLosDatosRequeridosDeLaMascotaNoSePuedeGuardarLaMisma()
    {
        MascotaDto mascota = dadoQueTengoUnaMascotaIncompleta();
        ModelAndView mav = cuandoIngresoLaMascota(mascota);
        entoncesElIngresoNoEsExitoso(mav);

    }

    private void entoncesElIngresoNoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo( "new-mascot");

    }

    private MascotaDto dadoQueTengoUnaMascotaIncompleta() {
        Usuario usuario = new Usuario("Ariel", "ariel@ariel", "12345");
        when(session.getAttribute("usuarioAutenticado")).thenReturn(usuario);
        MascotaDto mascotadto = new MascotaDto();



        String target = "publicacion";
        when(session.getAttribute("target")).thenReturn(target);
        when(servicioMascota.guardar(mascotadto,usuario)).thenReturn(null);



        return mascotadto;
    }

    private MascotaDto dadoQueExisteMascota() {
        Usuario usuario = new Usuario("Ariel", "ariel@ariel", "12345");
        when(session.getAttribute("usuarioAutenticado")).thenReturn(usuario);
        MascotaDto mascotadto = new MascotaDto();

        String target = "perfil";
        when(session.getAttribute("target")).thenReturn(target);



        return mascotadto;

    }

    private ModelAndView cuandoIngresoLaMascota(MascotaDto mascotadto) {

       return controladorMascota.ingresarMascota(mascotadto, session, request);

    }

    private void entoncesElIngresoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo( "redirect: " + request.getContextPath() + "/perfil/actividad/mascotas");

    }


    private void dadoQueExisteMascotas(Usuario usuario) {

        when(servicioMascota.buscarMascotaPorIdDueño(usuario)).thenReturn(new ArrayList<Mascota>());

    }




}
