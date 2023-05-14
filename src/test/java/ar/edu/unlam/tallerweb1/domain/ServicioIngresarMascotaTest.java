package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.mascota.ServicioIngresarMascota;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ServicioIngresarMascotaTest {
    private ServicioIngresarMascota servicioIngresarMascota = new ServicioIngresarMascota();
    @Test
    public void alIngresarLosDatosNecesariosDevuelveVerdadero()
    {
        Boolean sonValidos = servicioIngresarMascota.sonValidos("Juan", "Perro", null , null , null, null, null);
        entoncesMisDatos(sonValidos);

    }

    private void entoncesMisDatos(Boolean sonValidos) {
        assertThat(sonValidos).isTrue();
    }

}
