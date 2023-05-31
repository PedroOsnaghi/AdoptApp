package ar.edu.unlam.tallerweb1.domain.mascota;

import ar.edu.unlam.tallerweb1.delivery.MascotaDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServicioMascotaTest {

    private IServicioArchivo servicioArchivo;
    private IRepositorioMascota repositorioMascota;
    private ServicioMascota servicioMascota;



    @Before
    public void init(){
        this.servicioArchivo = mock(IServicioArchivo.class);
        this.repositorioMascota = mock(IRepositorioMascota.class);
        this.servicioMascota = new ServicioMascota(repositorioMascota, servicioArchivo);

    }
    @Test
    public void alNoIngresarNombreDeLaMascotaDevuelveFalse()
    {
        MascotaDto mascota = dadoQueIngresoLaMascotaSinNombre();
        Boolean resultado = cuandoIntentoGuardarLaMascota(mascota);
        entoncesDevuelveFalse(resultado);
    }


    @Test
    public void alNoIngresarElTipoDeMascotaMeDevuelveFalse()
    {
        MascotaDto mascota = dadoQueIngresoLaMascotaSinTipo();
        Boolean resultado = cuandoIntentoGuardarLaMascota(mascota);
        entoncesDevuelveFalse(resultado);
    }
    @Test
    public void alNoIngresarElGeneroDeMascotaMeDevuelveFalse()
    {
        MascotaDto mascota = dadoQueIngresoLaMascotaSinGenero();
        Boolean resultado = cuandoIntentoGuardarLaMascota(mascota);
        entoncesDevuelveFalse(resultado);
    }

    @Test
    public void alIngresarNombreTipoYGeneroDeMascotaMeDevuelveTrue()
    {
        MascotaDto mascota = dadoQueIngresoLaMascota();
        Boolean resultado = cuandoIntentoGuardarLaMascota(mascota);
        entoncesDevuelveTrue(resultado);
    }





    private MascotaDto dadoQueIngresoLaMascotaSinNombre() {
        MascotaDto mascotaDto = new MascotaDto();
        mascotaDto.setNombre("");
        mascotaDto.setTipo("PERRO");
        mascotaDto.setGenero("HEMBRA");

        return mascotaDto;
    }



    private void entoncesDevuelveFalse(Boolean resultado) {
        assertThat(resultado).isFalse();
    }

    private MascotaDto dadoQueIngresoLaMascotaSinTipo() {
        MascotaDto mascotaDto = new MascotaDto();
        mascotaDto.setNombre("PEPITO");
        mascotaDto.setTipo(null);
        mascotaDto.setGenero("HEMBRA");

        return mascotaDto;
    }

    private MascotaDto dadoQueIngresoLaMascotaSinGenero() {
        MascotaDto mascotaDto = new MascotaDto();
        mascotaDto.setNombre("PEPITO");
        mascotaDto.setTipo("PERRO");
        mascotaDto.setGenero(null);

        return mascotaDto;
    }


    private MascotaDto dadoQueIngresoLaMascota() {
        MascotaDto mascotaDto = new MascotaDto();
        mascotaDto.setNombre("PEPITO");
        mascotaDto.setTipo("PERRO");
        mascotaDto.setGenero("HEMBRA");

        return mascotaDto;
    }

    private Boolean cuandoIntentoGuardarLaMascota(MascotaDto mascota) {
        return servicioMascota.validarDatos(mascota);
    }

    private void entoncesDevuelveTrue(Boolean resultado) {
        assertThat(resultado).isTrue();

    }



}
