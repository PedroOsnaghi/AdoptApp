package ar.edu.unlam.tallerweb1.delivery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class EjemploTDDTest {

    @Test
    public void deberiaDevolverDebilCuandoLaContraseniaEsVacia(){

        EjemploTDD ejemploTDD = new EjemploTDD();

        String nivelDeSeguridad = ejemploTDD.evaluarContrasenia();

        assertThat(nivelDeSeguridad).isEqualTo("DEBIL");
    }
}
