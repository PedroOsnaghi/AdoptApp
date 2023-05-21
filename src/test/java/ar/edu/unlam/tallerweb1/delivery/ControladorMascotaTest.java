package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.domain.mascota.ServicioIngresarMascota;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class ControladorMascotaTest {


    private IServicioMascota iServicioMascota;
    private ControladorMascota controladorMascota;

    private DatosIngresoMascota datosIngresoMascota;


    @Before
    public void init()
    {

        this.datosIngresoMascota  = new DatosIngresoMascota();
        this.iServicioMascota = mock(ServicioIngresarMascota.class);
        this.controladorMascota = new ControladorMascota(this.iServicioMascota);
    }


    @Test
    public void alIngresarDatosMinimosRequeridosDeMascotaElIngresoEsExitosoYMeLlevaAMiPerfil()
    {
        dadoQueNoExisteMascota(this.datosIngresoMascota, true);
        ModelAndView mav = cuandoIngresoLaMascota(this.datosIngresoMascota);
        entoncesElIngresoEsExitoso(mav);
    }

    @Test
    public void alNoIngresarDatosMinimosDeMascotaNoSePuedeIgresarLaMisma()
    {

        dadoQueNoExisteMascota(this.datosIngresoMascota, false);
        ModelAndView mav = cuandoIngresoLaMascota(this.datosIngresoMascota);
        entoncesElIngresoNoEsExitoso(mav);
    }

    private void entoncesElIngresoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("profile");
        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Ingresada");
    }

    private void entoncesElIngresoNoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("new-mascot");
        assertThat(mav.getModel().get("msg")).isEqualTo("No se Pudo Ingresar La mascota, ingrese los campos mínimos");
    }

    private ModelAndView cuandoIngresoLaMascota(DatosIngresoMascota datosIngresoMascota) {
        return controladorMascota.ingresarMascota(datosIngresoMascota);
    }


    private void dadoQueNoExisteMascota(DatosIngresoMascota datosIngresoMascota, Boolean retorno) {
        when(this.iServicioMascota.sonValidos(datosIngresoMascota.getNombre(),datosIngresoMascota.getTipo(), datosIngresoMascota.getGenero(),datosIngresoMascota.getRaza(), datosIngresoMascota.getPeso(),datosIngresoMascota.getNacimiento(),datosIngresoMascota.getPersonalidad(),datosIngresoMascota.getObs(),datosIngresoMascota.getFoto())).thenReturn(retorno);

    }
}
