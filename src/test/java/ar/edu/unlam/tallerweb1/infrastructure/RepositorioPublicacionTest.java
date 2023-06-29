package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IRepositorioPublicacion;

import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioPublicacionTest extends SpringTest {
    @Autowired
    private IRepositorioPublicacion repositorioPublicacion;

    @Test
    @Transactional
    @Rollback
    public void alListarFavoritosDebenMostrarSoloPublicacionesDisponibles(){
        Long idUsuario = dadoQueExitenPublicacionesEnFavoritos();
        List<Publicacion_favorito> listaFavoritos = alListarFavoritos(idUsuario);
        SeDebenMostrarSoloLasDisponibles(listaFavoritos);
    }

    private List<Publicacion_favorito> alListarFavoritos(Long idUsuario) {
        return this.repositorioPublicacion.ListarFavoritosDeUsuario();
    }

    private Long dadoQueExitenPublicacionesEnFavoritos() {
        Publicacion p = new Publicacion();
        Publicacion p1 = new Publicacion();
        Publicacion p2 = new Publicacion();
        Mascota m = new Mascota();
        Mascota m1 = new Mascota();
        Mascota m2 = new Mascota();
        Usuario u = new Usuario("aldana", "a@a", "1234");

        session().save(u);
        p.setMascota(m);
        p.setEstado(EstadoPublicacion.PAUSADA);
        session().save(p);
        p1.setMascota(m1);
        p1.setEstado(EstadoPublicacion.DISPONIBLE);
        session().save(p1);
        p2.setMascota(m2);
        p2.setEstado(EstadoPublicacion.DISPONIBLE);
        session().save(p2);

        Publicacion_favorito pf = new Publicacion_favorito(u,p);
       session().save(pf);
        Publicacion_favorito pf1 = new Publicacion_favorito(u,p1);
        session().save(pf1);
        Publicacion_favorito pf2 = new Publicacion_favorito(u,p2);
        session().save(pf2);

        return u.getId();




    }


    @Test
    @Transactional
    @Rollback
    public void alCrearUnaPublicacionPuedoBuscarlaPorIdYObtenerSuBio(){
        Publicacion publicacionExistente =  dadoQueExisteUnaPublicacionCreada();
        Publicacion publicacionEncontrada = alBuscarPorSuId(publicacionExistente.getId());
        assertThat(publicacionEncontrada.getBio()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void alListarPublicacionesDisponiblesDebeDevolverSoloLasDisponibles(){
        dadoQueExistenPublicacionesCreadas();
        List<Publicacion> publicaciones = alListar(EstadoPublicacion.DISPONIBLE);
        assertThat(publicaciones).hasSize(2);
    }

    @Test
    @Transactional
    @Rollback
    public void alListarPublicacionesPorUsuario(){
        Usuario usuarioATestear = dadoQueExistenPublicacionesCreadasPorUsuarios();
        List<Publicacion> publicaciones = alListarPorUsuario(usuarioATestear.getId());
        assertThat(publicaciones).hasSize(1);
    }

    @Test
    @Transactional
    @Rollback
    public void testAlAgregarFavorito(){
        Publicacion publicacion = dadoQueExisteUnaPublicacionCreada();
        Publicacion_favorito publicacionFavorito = alAgregarAFavoritos(publicacion.getId());
        assertThat(publicacionFavorito.getPublicacion()).isNotNull();
        assertThat(publicacionFavorito.getUsuario()).isNotNull();
    }

    private Publicacion_favorito alAgregarAFavoritos(Long idPublicacion) {
        Publicacion publicacion = session().find(Publicacion.class, idPublicacion);
        Usuario usuario = new Usuario("pedro", "test@test.com", "test");
        session().save(usuario);

        Publicacion_favorito publicacionFavorito = new Publicacion_favorito();
        publicacionFavorito.setPublicacion(publicacion);
        publicacionFavorito.setUsuario(usuario);

        return this.repositorioPublicacion.agregarFavorito(publicacionFavorito);
    }

    private List<Publicacion> alListarPorUsuario(Long id) {
        return this.repositorioPublicacion.listarPublicacionesPorUsuarioId(id);
    }

    private List<Publicacion> alListar(EstadoPublicacion estado) {
        return this.repositorioPublicacion.listarPublicaciones(estado);
    }

    private void dadoQueExistenPublicacionesCreadas() {
        Usuario usuario = new Usuario("juan", "test@juan", "1234");
        session().save(usuario);

        Mascota mascota1 = new Mascota();
        mascota1.setNombre("Picha");
        mascota1.setUsuario(usuario);
        session().save(mascota1);

        Mascota mascota2 = new Mascota();
        mascota2.setNombre("Picho");
        mascota2.setUsuario(usuario);
        session().save(mascota2);

        Mascota mascota3 = new Mascota();
        mascota3.setNombre("Pichicho");
        mascota3.setUsuario(usuario);
        session().save(mascota3);

        Publicacion publicacion1 = new Publicacion();
        publicacion1.setBio("Bio de prueba 1");
        publicacion1.setMascota(mascota1);
        publicacion1.setEstado(EstadoPublicacion.DISPONIBLE);

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setBio("Bio de prueba 2");
        publicacion2.setMascota(mascota2);
        publicacion2.setEstado(EstadoPublicacion.DISPONIBLE);

        Publicacion publicacion3 = new Publicacion();
        publicacion3.setBio("Bio de prueba 3");
        publicacion3.setMascota(mascota3);
        publicacion3.setEstado(EstadoPublicacion.RESERVADO);

        this.repositorioPublicacion.guardarPublicacion(publicacion1);
        this.repositorioPublicacion.guardarPublicacion(publicacion2);
        this.repositorioPublicacion.guardarPublicacion(publicacion3);
    }

    private Usuario dadoQueExistenPublicacionesCreadasPorUsuarios() {
        Usuario usuario = new Usuario("juan", "test@juan", "1234");
        session().save(usuario);

        Usuario usuario2 = new Usuario("pedro", "test@pedro", "1234");
        session().save(usuario2);

        Mascota mascota1 = new Mascota();
        mascota1.setNombre("Picha");
        mascota1.setUsuario(usuario);
        session().save(mascota1);

        Mascota mascota2 = new Mascota();
        mascota2.setNombre("Picho");
        mascota2.setUsuario(usuario);
        session().save(mascota2);

        Mascota mascota3 = new Mascota();
        mascota3.setNombre("Pichicho");
        mascota3.setUsuario(usuario2);
        session().save(mascota3);

        Publicacion publicacion1 = new Publicacion();
        publicacion1.setBio("Bio de prueba 1");
        publicacion1.setMascota(mascota1);
        publicacion1.setEstado(EstadoPublicacion.DISPONIBLE);

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setBio("Bio de prueba 2");
        publicacion2.setMascota(mascota2);
        publicacion2.setEstado(EstadoPublicacion.DISPONIBLE);

        Publicacion publicacion3 = new Publicacion();
        publicacion3.setBio("Bio de prueba 3");
        publicacion3.setMascota(mascota3);
        publicacion3.setEstado(EstadoPublicacion.RESERVADO);

        this.repositorioPublicacion.guardarPublicacion(publicacion1);
        this.repositorioPublicacion.guardarPublicacion(publicacion2);
        this.repositorioPublicacion.guardarPublicacion(publicacion3);

        return usuario2;
    }

    private Publicacion alBuscarPorSuId(Long idPublicacion) {
        return this.repositorioPublicacion.buscarPublicacionPorId(idPublicacion);
    }

    private Publicacion dadoQueExisteUnaPublicacionCreada() {
        Usuario usuario = new Usuario("juan", "test@juan", "1234");
        session().save(usuario);

        Mascota mascota = new Mascota();
        mascota.setNombre("Picha");
        mascota.setUsuario(usuario);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setBio("Bio de prueba");
        publicacion.setMascota(mascota);

        this.repositorioPublicacion.guardarPublicacion(publicacion);
        return publicacion;
    }
}
