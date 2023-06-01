package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioPublicacionTest {
    private IRepositorioPublicacion repositorioPublicacion;
    private IServicioArchivo servicioArchivo;

    private ServicioPublicacion servicioPublicacion;

    @Before
    public void init() {
        this.repositorioPublicacion = mock(IRepositorioPublicacion.class);
        this.servicioArchivo = mock(IServicioArchivo.class);
        this.servicioPublicacion = new ServicioPublicacion(this.repositorioPublicacion, this.servicioArchivo);
    }

    @Test
    public void cuandoBuscoUnaPublicacionExistentePuedoAccederASuBio(){
        Long idPublicacion = 4L;
        Publicacion publicacion = AlBuscarPorId(idPublicacion);
        puedoAccederAsuBio(publicacion);
    }

    @Test
    public void testListarPublicacionesPorUsuarioId(){
        Long idUsuario = 1L;
        List<Publicacion> publicaciones = dadoQueTengoUnaListaDePublicaciones();
        List<Publicacion> resultado = alListarPublicaciones(idUsuario, publicaciones);
        assertThat(resultado).isEqualTo(publicaciones);
    }

    private List<Publicacion> alListarPublicaciones(Long idUsuario, List<Publicacion> publicaciones) {
        when(repositorioPublicacion.listarPublicacionesPorUsuarioId(idUsuario)).thenReturn(publicaciones);
        return servicioPublicacion.listarPublicacionesPorUsuarioId(idUsuario);
    }

    public Publicacion AlBuscarPorId(Long id)
    {
        Publicacion publicacion = dadoQueExisteUnaPublicacion();
        when(this.repositorioPublicacion.buscarPublicacionPorId(id)).thenReturn(publicacion);
        return this.servicioPublicacion.findPublicacion(id);
    }

    private void puedoAccederAsuBio(Publicacion publicacionObtenida) {
        Assertions.assertThat(publicacionObtenida.getBio()).isEqualTo("Esto es un test");
    }

    private Publicacion dadoQueExisteUnaPublicacion() {
        Publicacion publicacion = new Publicacion();
        publicacion.setId(4L);
        publicacion.setBio("Esto es un test");
        return publicacion;
    }

    private List<Publicacion> dadoQueTengoUnaListaDePublicaciones() {
        List<Publicacion> publicacions = new ArrayList<>();

        Publicacion publicacion = new Publicacion();
        publicacion.setId(1L);
        publicacion.setBio("Prueba Publicacion");

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setId(2L);
        publicacion2.setBio("Prueba Publicacion 2");

        publicacions.add(publicacion);
        publicacions.add(publicacion2);

        return publicacions;
    }
}
