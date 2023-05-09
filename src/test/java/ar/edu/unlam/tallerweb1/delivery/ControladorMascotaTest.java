package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.IServicioIngresarMascota;
import ar.edu.unlam.tallerweb1.domain.ServicioIngresarMascota;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class ControladorMascotaTest {
    public static final String NOMBRE = "juan";
    public static final String NOMBRE_VACIO = "";
    public static final DatosIngresoMascota.Tipo TIPO = DatosIngresoMascota.Tipo.PERRO;
    public DatosIngresoMascota.Tipo tipo;
    private IServicioIngresarMascota iServicioIngresarMascota;
    private ControladorMascota controladorMascota;

    private DatosIngresoMascota datosIngresoMascota;
    private DatosIngresoMascota datosIngresoMascotaInvalidos;

    @Before
    public void init()
    {
        this.datosIngresoMascotaInvalidos  = new DatosIngresoMascota();
        this.datosIngresoMascota  = new DatosIngresoMascota();
        this.iServicioIngresarMascota = mock(ServicioIngresarMascota.class);
        this.controladorMascota = new ControladorMascota(this.iServicioIngresarMascota);
    }
    @Test
    public void alQuererIngresarUnaNuevaMascotaMeLlevaALaVistaDeNuevaMascota()
    {
        dadoQueNoExisteLaMascota();
        ModelAndView mav = cuandoQuieroIngresarNuevaMascota();
        entoncesMeLlevaAlaPantallaDeNuevoIngreso(mav);

    }

    private void dadoQueNoExisteLaMascota() {
    }

    private void entoncesMeLlevaAlaPantallaDeNuevoIngreso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("new-mascot");
    }

    private ModelAndView cuandoQuieroIngresarNuevaMascota() {
        return controladorMascota.nuevaMascota();
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

        dadoQueNoExisteMascota(this.datosIngresoMascotaInvalidos, false);
        ModelAndView mav = cuandoIngresoLaMascota(this.datosIngresoMascotaInvalidos);
        entoncesElIngresoNoEsExitoso(mav);
    }

    private void entoncesElIngresoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("profile");
        assertThat(mav.getModel().get("msg")).isEqualTo("Mascota Ingresada");
    }

    private void entoncesElIngresoNoEsExitoso(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("new-mascot");
        assertThat(mav.getModel().get("msg")).isEqualTo("No se Pudo Ingresar La mascota");
    }

    private ModelAndView cuandoIngresoLaMascota(DatosIngresoMascota datosIngresoMascota) {
        return controladorMascota.ingresarMascota(datosIngresoMascota.getNombre(), tipo , datosIngresoMascota.getNacimiento(), datosIngresoMascota.getObs(), datosIngresoMascota.getFoto());
    }
   // private void dadoQueLosDatosSonInvalidos() {
     //   when(this.iServicioIngresarMascota.sonValidos(datosIngresoMascota.getNombre(),tipo, datosIngresoMascota.getNacimiento(),datosIngresoMascota.getObs(),datosIngresoMascota.getFoto())).thenReturn(false);

   // }

    private void dadoQueNoExisteMascota(DatosIngresoMascota datosIngresoMascota, Boolean retorno) {
        when(this.iServicioIngresarMascota.sonValidos(datosIngresoMascota.getNombre(),tipo, datosIngresoMascota.getNacimiento(),datosIngresoMascota.getObs(),datosIngresoMascota.getFoto())).thenReturn(retorno);

    }
}
