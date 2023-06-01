package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioPublicacion;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion_favorito;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
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
        assertThat(resultado).hasSize(2);
    }

    @Test
    public void alGuardarUnaPublicacionCorrectaRetornaElId(){
        PublicacionDto publicacion = dadoQueTengoDatosCorrectos();
        Long result = alGuardar(publicacion);
        debeRetornarElIdDeLAPublicacionGuardada(result);
    }

    @Test
    public void alQuererGuardarUnaPublicacionConDatosIncompletosRetornaNull(){
        PublicacionDto publicacion = dadoQueTengoDatosIncorrectos();
        Long result = alGuardar(publicacion);
        debeRetornarNull(result);
    }

    @Test
    public void alQuererGuardarUnaPublicacionYProducirseUnErrorenElGuardadoDebeRetornarNull(){
        PublicacionDto publicacion = dadoQueTengoDatosCorrectos();
        Long result = alGuardarConError(publicacion);
        debeRetornarNull(result);
    }

    @Test
    public void alAgregarUnFavoritoDebemosObtenerUnObjeto(){
        Long idPublicacion = 2L;
        Usuario user = new Usuario();
        user.setId(1L);

        Publicacion_favorito pf = alGuardarFavorito(idPublicacion,user);
        obtengoUnObjetoNoNulo(pf);

    }

    private void obtengoUnObjetoNoNulo(Publicacion_favorito pf) {
        assertThat(pf).isNotNull();
    }

    private Publicacion_favorito alGuardarFavorito(Long idPublicacion, Usuario user) {
        Publicacion post = new Publicacion();
        post.setId(idPublicacion);
        Publicacion_favorito pf = new Publicacion_favorito(user, post);

        when(this.repositorioPublicacion.agregarFavorito(anyObject())).thenReturn(pf);
        return this.servicioPublicacion.agregarFavorito(idPublicacion, user);
    }

    private Long alGuardarConError(PublicacionDto publicacion) {
        when(this.servicioArchivo.subirImagenesPost(anyObject(),anyObject())).thenReturn(0);
        when(this.repositorioPublicacion.guardarPublicacion(anyObject())).thenReturn(null);
        return this.servicioPublicacion.guardarPublicacion(publicacion);
    }

    private void debeRetornarElIdDeLAPublicacionGuardada(Long result) {
        System.out.println(this.servicioPublicacion.getErrorMessage());
        assertThat(result).isNotNull();
    }

    private void debeRetornarNull(Long result) {
        System.out.println("Error obtenido: " + this.servicioPublicacion.getErrorMessage());
        assertThat(result).isNull();
    }

    private Long alGuardar(PublicacionDto publicacion) {
        when(this.servicioArchivo.subirImagenesPost(anyObject(),anyObject())).thenReturn(0);
        when(this.repositorioPublicacion.guardarPublicacion(anyObject())).thenReturn(20L);
        return this.servicioPublicacion.guardarPublicacion(publicacion);
    }

    private PublicacionDto dadoQueTengoDatosCorrectos() {
        PublicacionDto p = new PublicacionDto();
        p.setMascota_id(5L);
        p.setDireccion("Calle falsa 123");
        p.setDisponibilidad("todo el dia");

        return p;


    }

    private PublicacionDto dadoQueTengoDatosIncorrectos() {
        PublicacionDto p = new PublicacionDto();
       // p.setMascota_id(5L);
        p.setDireccion("Calle falsa 123");
        p.setDisponibilidad("todo el dia");

        return p;


    }

    private List<Publicacion> alListarPublicaciones(Long idUsuario, List<Publicacion> publicaciones) {
        when(repositorioPublicacion.listarPublicacionesPorUsuarioId(anyLong())).thenReturn(publicaciones);
        return servicioPublicacion.listarPublicacionesPorUsuarioId(idUsuario);
    }

    public Publicacion AlBuscarPorId(Long id)
    {
        Publicacion publicacion = dadoQueExisteUnaPublicacion();
        when(this.repositorioPublicacion.buscarPublicacionPorId(anyLong())).thenReturn(publicacion);
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
