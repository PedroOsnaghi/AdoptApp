package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.delivery.Tipo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ServicioIngresarMascotaTest {
    private ServicioIngresarMascota servicioIngresarMascota = new ServicioIngresarMascota();
    @Test
    public void alIngresarLosDatosNecesariosDevuelveVerdadero()
    {
        Boolean sonValidos = servicioIngresarMascota.sonValidos("Juan", Tipo.PERRO, null , null , null);
        entoncesMisDatos(sonValidos);

    }

    private void entoncesMisDatos(Boolean sonValidos) {
        assertThat(sonValidos).isTrue();
    }

}
