package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.adopcion.IRepositorioAdopcion;
import ar.edu.unlam.tallerweb1.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioAdopcionTest extends SpringTest {

    @Autowired
    private IRepositorioAdopcion repositorioAdopcion;

    @Test
    @Transactional
    @Rollback
    public void testCrearAdopcion() {

        Usuario usuarioSolicitante = new Usuario("Marcos", "test2@email", "1234");
        usuarioSolicitante.setId(new Random().nextLong());
        session().save(usuarioSolicitante);

        Solicitud solicitud = dadoQueUnUsuarioCreaUnaSolicitud(usuarioSolicitante);

        Long idAdopcion = alConcretarseLaAdopcion(solicitud);

        puedoObtenerSuId(idAdopcion);
    }

    private Solicitud dadoQueUnUsuarioCreaUnaSolicitud(Usuario usuarioSolicitante) {
        Usuario usuarioDuenio = new Usuario("john", "test@email", "1234");
        usuarioDuenio.setId(new Random().nextLong());
        session().save(usuarioDuenio);

        Mascota mascota = new Mascota();
        mascota.setNombre("Doe");
        mascota.setUsuario(usuarioDuenio);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setId(new Random().nextLong());
        publicacion.setBio("Test bio");
        publicacion.setMascota(mascota);
        session().save(publicacion);

        Solicitud solicitud = new Solicitud();
        solicitud.setPublicacion(publicacion);
        solicitud.setUsuario(usuarioSolicitante);

        return solicitud;
    }

    private Long alConcretarseLaAdopcion(Solicitud solicitud) {
        Adopcion adopcion = new Adopcion(solicitud.getUsuario(), solicitud.getPublicacion());
        repositorioAdopcion.registrarAdopcion(adopcion);
        return adopcion.getId();
    }

    private void puedoObtenerSuId(Long idAdopcion) {
        assertThat(idAdopcion).isNotNull();
    }
}