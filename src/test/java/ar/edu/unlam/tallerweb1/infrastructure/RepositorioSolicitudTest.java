package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Solicitud.IRepositorioSolicitud;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class RepositorioSolicitudTest extends SpringTest {

    @Autowired
    private IRepositorioSolicitud repositorioSolicitud;

    @Test
    @Transactional
    @Rollback
    public void testCrearYGetSolicitud() {

        Publicacion publicacion = dadoQueExisteUnaPublicacionCreada();
        Usuario usuario = dadoQueExisteUnUsuarioSolicitante();
        String mensaje = "test";
        session().save(usuario);
        session().save(publicacion);

        alEnviarUnaSolicitud(usuario, publicacion, mensaje);

        puedoObtenerLaSolicitudCreada(usuario, publicacion, mensaje);
    }

    @Test
    @Transactional
    @Rollback
    public void testCancelarSolicitud() {

        Publicacion publicacion = dadoQueExisteUnaPublicacionCreada();
        Usuario usuario = dadoQueExisteUnUsuarioSolicitante();
        String mensaje = "test";
        session().save(usuario);
        session().save(publicacion);

        Solicitud solicitud = alEnviarUnaSolicitud(usuario, publicacion, mensaje);
        alCancelarUnaSolicitud(solicitud);

        noPuedoObtenerLaSolicitudCreada(usuario, publicacion);
    }

    //TODO NO FUNCIONO :(
    @Test
    @Transactional
    @Rollback
    public void testListarSolicitudesEnviadas() {

        Publicacion publicacion1 = dadoQueExisteUnaPublicacionCreada();
        Publicacion publicacion2 = dadoQueExisteOtraPublicacionCreada();
        Usuario usuario = dadoQueExisteUnUsuarioSolicitante();
        String mensaje = "test";
        session().save(usuario);
        session().save(publicacion1);
        session().save(publicacion2);

        Solicitud solicitud1 = alEnviarUnaSolicitud(usuario, publicacion1, mensaje);
        Solicitud solicitud2 = alEnviarUnaSolicitud(usuario, publicacion2, mensaje);
        session().save(solicitud1);
        session().save(solicitud2);

        puedoListarLasSolicitudesEnviadas(usuario, solicitud1, solicitud2);
    }

    //TODO NO FUNCIONO :(
//    @Test
//    @Transactional
//    @Rollback
//    public void testListarSolicitudesRecibidas() {
//
//        Publicacion publicacion1 = dadoQueExisteUnaPublicacionCreada(995L);
//        Publicacion publicacion2 = dadoQueExisteUnaPublicacionCreada(995L);
//        Usuario usuario = dadoQueExisteUnUsuarioSolicitante();
//        String mensaje = "test";
//        session().save(usuario);
//        session().save(publicacion1);
//        session().save(publicacion2);
//
//        Solicitud solicitud1 = alEnviarUnaSolicitud(usuario, publicacion1, mensaje);
//        Solicitud solicitud2 = alEnviarUnaSolicitud(usuario, publicacion2, mensaje);
//        session().save(solicitud1);
//        session().save(solicitud2);
//
//        puedoListarLasSolicitudesRecibidas(usuario, solicitud1, solicitud2);
//    }

    private void puedoListarLasSolicitudesRecibidas(Usuario usuario, Solicitud solicitud1, Solicitud solicitud2) {
        List<Solicitud> solicitudes = repositorioSolicitud.listarSolicitudesRecibidas(usuario.getId());
        assertEquals(2, solicitudes.size());
        assertTrue(solicitudes.contains(solicitud1));
        assertTrue(solicitudes.contains(solicitud2));
    }

    private void puedoListarLasSolicitudesEnviadas(Usuario usuario, Solicitud solicitud1, Solicitud solicitud2) {
        List<Solicitud> solicitudes = repositorioSolicitud.listarSolicitudesEnviadas(usuario.getId());
        assertEquals(2, solicitudes.size());
        assertTrue(solicitudes.contains(solicitud1));
        assertTrue(solicitudes.contains(solicitud2));
    }

    private void noPuedoObtenerLaSolicitudCreada(Usuario usuario, Publicacion publicacion) {
        Solicitud s = repositorioSolicitud.getSolicitudDeUsuarioPorPublicacion(publicacion, usuario);
        assertNull(s);
    }

    private void alCancelarUnaSolicitud(Solicitud solicitud) {
        repositorioSolicitud.cancelarSolicitud(solicitud);
    }


    private Usuario dadoQueExisteUnUsuarioSolicitante() {
        Usuario u = new Usuario("john doe", "test@test.com", "test");
        u.setId(new Random().nextLong());
        session().save(u);

        return u;
    }

    private Publicacion dadoQueExisteUnaPublicacionCreada() {
        Usuario usuario = new Usuario("john", "test@email", "1234");
        usuario.setId(new Random().nextLong());
        session().save(usuario);

        Mascota mascota = new Mascota();
        mascota.setNombre("Doe");
        mascota.setUsuario(usuario);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setId(new Random().nextLong());
        publicacion.setBio("Test bio");
        publicacion.setMascota(mascota);
        session().save(publicacion);

        return publicacion;
    }

    private Publicacion dadoQueExisteUnaPublicacionCreada(Long idUsuario) {
        Usuario usuario = new Usuario("john", "test@email", "1234");
        usuario.setId(idUsuario);
        session().save(usuario);

        Mascota mascota = new Mascota();
        mascota.setNombre("Doe");
        mascota.setUsuario(usuario);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setId(new Random().nextLong());
        publicacion.setBio("Test bio");
        publicacion.setMascota(mascota);
        session().save(publicacion);

        return publicacion;
    }

    private Publicacion dadoQueExisteOtraPublicacionCreada() {
        Usuario usuario = new Usuario("jane", "test2@email", "1234");
        usuario.setId(new Random().nextLong());
        session().save(usuario);

        Mascota mascota = new Mascota();
        mascota.setNombre("Dane");
        mascota.setUsuario(usuario);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setBio("Test bio");
        publicacion.setMascota(mascota);
        session().save(publicacion);

        return publicacion;
    }


    private Solicitud alEnviarUnaSolicitud(Usuario u, Publicacion p, String mensaje) {
        Solicitud s = new Solicitud(u, p, mensaje);
        repositorioSolicitud.guardarSolicitud(s);
        return s;
    }

    private void puedoObtenerLaSolicitudCreada(Usuario u, Publicacion p, String m) {
        Solicitud s = repositorioSolicitud.getSolicitudDeUsuarioPorPublicacion(p, u);
        assertNotNull(s);
        assertEquals(s.getMensaje(), m);
    }


}