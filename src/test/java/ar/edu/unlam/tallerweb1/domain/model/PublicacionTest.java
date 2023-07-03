package ar.edu.unlam.tallerweb1.domain.model;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PublicacionTest
{

    @Test
    public void dadoQueSeCreaUnaPublicacionLaPublicacionTieneEstadoDisponible(){
        Publicacion p=  dadoQueExisteUnaPublicacion();
        seDebeVerQueTieneEstadoDisponible(p);
    }

    private void seDebeVerQueTieneEstadoDisponible(Publicacion p) {
        assertThat(p.getEstado()).isEqualTo(EstadoPublicacion.DISPONIBLE);
    }

    private Publicacion dadoQueExisteUnaPublicacion() {
        PublicacionDto pdto = new PublicacionDto();
        pdto.setMascota(new Mascota());
        return new Publicacion(pdto);
    }
}
