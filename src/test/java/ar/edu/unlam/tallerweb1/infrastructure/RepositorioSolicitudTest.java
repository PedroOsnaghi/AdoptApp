package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Solicitud.IRepositorioSolicitud;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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

   private Usuario dadoQueExisteUnUsuarioSolicitante() {
        return new Usuario("john doe", "test@test.com", "test");
    }

    private Publicacion dadoQueExisteUnaPublicacionCreada() {
        Usuario usuario = new Usuario("john", "test@email", "1234");
        session().save(usuario);

        Mascota mascota = new Mascota();
        mascota.setNombre("Doe");
        mascota.setUsuario(usuario);
        session().save(mascota);

        Publicacion publicacion = new Publicacion();
        publicacion.setBio("Test bio");
        publicacion.setMascota(mascota);
        session().save(publicacion);

        return publicacion;
    }


    private void alEnviarUnaSolicitud(Usuario u, Publicacion p, String mensaje) {
        Solicitud s = new Solicitud(u, p, mensaje);
        repositorioSolicitud.guardarSolicitud(s);
    }

    private void puedoObtenerLaSolicitudCreada(Usuario u, Publicacion p, String m) {
        Solicitud s = repositorioSolicitud.getSolicitudDeUsuarioPorPublicacion(p, u);
        assertNotNull(s);
        assertEquals(s.getMensaje(), m);
   }



}