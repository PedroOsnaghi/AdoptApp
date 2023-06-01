package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IRepositorioPublicacion;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioPublicacionTest extends SpringTest {
    @Autowired
    private IRepositorioPublicacion repositorioPublicacion;

    @Test
    @Transactional
    @Rollback
    public void alBuscarUnaPublicacionExistentePuedoObtenerSuBio(){
        Publicacion publicacionExistente =  dadoQueExisteUnaPublicacionCreada();
        Publicacion publicacionEncontrada = alBuscarPorSuId(publicacionExistente.getId());
        assertThat(publicacionEncontrada.getBio()).isNotNull();
    }

    private Publicacion alBuscarPorSuId(Long idPublicacion) {
        return this.repositorioPublicacion.buscarPublicacionPorId(idPublicacion);
    }

    private Publicacion dadoQueExisteUnaPublicacionCreada() {
        Publicacion publicacion = new Publicacion();
        publicacion.setId(2L);
        publicacion.setBio("Bio de prueba");
        return publicacion;
    }
}
