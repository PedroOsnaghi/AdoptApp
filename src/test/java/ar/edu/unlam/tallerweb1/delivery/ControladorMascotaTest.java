package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.domain.mascota.ServicioMascota;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class ControladorMascotaTest {

/*
    private IServicioMascota iServicioMascota;
    private ControladorMascota controladorMascota;

    private MascotaDto mascotaDto;


    @Before
    public void init()
    {

        this.mascotaDto = new MascotaDto();
        this.iServicioMascota = mock(ServicioMascota.class);
        this.controladorMascota = new ControladorMascota(this.iServicioMascota);
    }


    @Test
    public void alIngresarDatosMinimosRequeridosDeMascotaElIngresoEsExitosoYMeLlevaAMiPerfil()
    {
        dadoQueNoExisteMascota(this.mascotaDto, true);
        ModelAndView mav = cuandoIngresoLaMascota(this.mascotaDto);
        entoncesElIngresoEsExitoso(mav);
    }

    @Test
    public void alNoIngresarDatosMinimosDeMascotaNoSePuedeIgresarLaMisma()
    {

        dadoQueNoExisteMascota(this.mascotaDto, false);
        ModelAndView mav = cuandoIngresoLaMascota(this.mascotaDto);
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

    private ModelAndView cuandoIngresoLaMascota(MascotaDto mascotaDto) {
        return controladorMascota.ingresarMascota(mascotaDto);
    }


    private void dadoQueNoExisteMascota(MascotaDto mascotaDto, Boolean retorno) {
        when(this.iServicioMascota.sonValidos(mascotaDto.getNombre(), mascotaDto.getTipo(), mascotaDto.getGenero(), mascotaDto.getRaza(), mascotaDto.getPeso(), mascotaDto.getNacimiento(), mascotaDto.getPersonalidad(), mascotaDto.getObs(), mascotaDto.getFoto())).thenReturn(retorno);

    }
    */

}
