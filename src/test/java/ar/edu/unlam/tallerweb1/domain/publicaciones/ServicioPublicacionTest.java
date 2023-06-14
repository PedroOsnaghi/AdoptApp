package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;

import ar.edu.unlam.tallerweb1.domain.exceptions.DataValidationException;
import ar.edu.unlam.tallerweb1.domain.exceptions.PostCreationException;
import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    public void testListarPublicacionesConCantidadDeMensajesPorUsuarioId(){
        Long idUsuario = 10L;
        List<PublicacionMensajes> publicacionesConMensajes = dadoQueTengoUnaListaDePublicacionesConMensajes();
        List<PublicacionMensajes> resultado = alListarPublicacionesConMensajes(idUsuario, publicacionesConMensajes);
        assertThat(resultado).hasSize(2);
    }

    @Test
    public void testListarFavoritosDeUnUsuario(){
        Long idUsuario = 6L;
        List<Publicacion_favorito> publicacionFavoritos = dadoQueTengoUnaListaDeFavoritos();
        List<Publicacion_favorito> resultado = alListarFavoritos(idUsuario, publicacionFavoritos);
        assertThat(resultado).hasSize(3);
    }

    @Test
    public void testListarPublicacionesDisponibles(){
        List<Publicacion> publicacionesDisponibles = dadoQueTengoUnaListaDePublicacionesDisponibles();
        List<Publicacion> resultado = alListarPublicacionesDisponibles(publicacionesDisponibles);
        assertThat(resultado).hasSize(4);
    }

    private List<Publicacion> alListarPublicacionesDisponibles(List<Publicacion> publicacionesDisponibles) {
        when(this.repositorioPublicacion.listarPublicaciones(EstadoPublicacion.DISPONIBLE)).thenReturn(publicacionesDisponibles);
        return this.servicioPublicacion.listarPublicacionesDisponibles();
    }

    private List<Publicacion> dadoQueTengoUnaListaDePublicacionesDisponibles() {
        List<Publicacion> publicaciones = new ArrayList<>();

        Publicacion publicacion = new Publicacion();
        publicacion.setId(2L);
        publicacion.setEstado(EstadoPublicacion.DISPONIBLE);

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setId(3L);
        publicacion2.setEstado(EstadoPublicacion.DISPONIBLE);

        Publicacion publicacion3 = new Publicacion();
        publicacion3.setId(6L);
        publicacion3.setEstado(EstadoPublicacion.DISPONIBLE);

        Publicacion publicacion4 = new Publicacion();
        publicacion4.setId(7L);
        publicacion4.setEstado(EstadoPublicacion.DISPONIBLE);

        publicaciones.add(publicacion);
        publicaciones.add(publicacion2);
        publicaciones.add(publicacion3);
        publicaciones.add(publicacion4);

        return publicaciones;
    }

    private List<Publicacion_favorito> alListarFavoritos(Long idUsuario, List<Publicacion_favorito> publicacionFavoritos) {
        when(this.repositorioPublicacion.ListarFavoritosDeUsuario(anyLong())).thenReturn(publicacionFavoritos);
        return this.servicioPublicacion.listarFavoritosDeUsuario(idUsuario);
    }

    private List<Publicacion_favorito> dadoQueTengoUnaListaDeFavoritos() {
        List<Publicacion_favorito> publicacionFavoritos = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(6L);

        Publicacion publicacion = new Publicacion();
        publicacion.setId(2L);

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setId(3L);

        Publicacion publicacion3 = new Publicacion();
        publicacion3.setId(6L);

        Publicacion_favorito pf1 = new Publicacion_favorito(usuario, publicacion);
        Publicacion_favorito pf2 = new Publicacion_favorito(usuario, publicacion2);
        Publicacion_favorito pf3 = new Publicacion_favorito(usuario, publicacion3);

        publicacionFavoritos.add(pf1);
        publicacionFavoritos.add(pf2);
        publicacionFavoritos.add(pf3);

        return publicacionFavoritos;
    }

    private List<PublicacionMensajes> alListarPublicacionesConMensajes(Long idUsuario, List<PublicacionMensajes> publicacionesConMensajes) {
        when(this.repositorioPublicacion.listarPublicacionesConMensajesPorUsuarioId(anyLong())).thenReturn(publicacionesConMensajes);
        return this.servicioPublicacion.listarPublicacionesMensajesPorUsuarioId(idUsuario);
    }

    private List<PublicacionMensajes> dadoQueTengoUnaListaDePublicacionesConMensajes() {
        List<PublicacionMensajes> publicacionMensajes = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(10L);

        Mascota mascota1 = new Mascota();
        mascota1.setUsuario(usuario);

        Mascota mascota2 = new Mascota();
        mascota2.setUsuario(usuario);

        Publicacion publicacion = new Publicacion();
        publicacion.setId(2L);
        publicacion.setMascota(mascota1);

        Publicacion publicacion2 = new Publicacion();
        publicacion2.setId(2L);
        publicacion2.setMascota(mascota2);

        PublicacionMensajes publicacionMensajes1 = new PublicacionMensajes();
        publicacionMensajes1.setPublicacion(publicacion);
        publicacionMensajes1.setNew_messages(5L);

        PublicacionMensajes publicacionMensajes2 = new PublicacionMensajes();
        publicacionMensajes2.setPublicacion(publicacion2);
        publicacionMensajes2.setNew_messages(10L);

        publicacionMensajes.add(publicacionMensajes1);
        publicacionMensajes.add(publicacionMensajes2);

        return publicacionMensajes;
    }

    @Test
    public void alGuardarUnaPublicacionCorrectaRetornaElId(){
        PublicacionDto publicacion = dadoQueTengoDatosCorrectos();
        Long result = alGuardardeFormaCorrecta(publicacion);
        debeRetornarElIdDeLAPublicacionGuardada(result);
    }

    @Test(expected = DataValidationException.class)
    public void alQuererGuardarUnaPublicacionConDatosIncompletosRetornaNull(){
        PublicacionDto publicacion = dadoQueTengoDatosIncorrectos();
        alGuardarConErrorDeValidacion(publicacion);

    }

    @Test(expected = PostCreationException.class)
    public void alQuererGuardarUnaPublicacionYProducirseUnErrorenElGuardadoDebeRetornarError(){
        PublicacionDto publicacion = dadoQueTengoDatosCorrectos();
        alGuardarConError(publicacion);
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

    private void alGuardarConError(PublicacionDto publicacion)  {
        when(this.servicioArchivo.subirImagenesPost(anyObject(),anyObject())).thenReturn(0);
        when(this.repositorioPublicacion.guardarPublicacion(anyObject())).thenThrow(PostCreationException.class);
        this.servicioPublicacion.guardarPublicacion(publicacion);
    }

    private void debeRetornarElIdDeLAPublicacionGuardada(Long result) {

        assertThat(result).isNotNull();
    }


    private Long alGuardarConErrorDeValidacion(PublicacionDto publicacion) {
        when(this.servicioArchivo.subirImagenesPost(anyObject(),anyObject())).thenReturn(0);
        when(this.repositorioPublicacion.guardarPublicacion(anyObject())).thenThrow(DataValidationException.class);
        return this.servicioPublicacion.guardarPublicacion(publicacion);
    }

    private Long alGuardardeFormaCorrecta(PublicacionDto publicacion) {
        when(this.servicioArchivo.subirImagenesPost(anyObject(),anyObject())).thenReturn(0);
        when(this.repositorioPublicacion.guardarPublicacion(anyObject())).thenReturn(20L);
        return this.servicioPublicacion.guardarPublicacion(publicacion);
    }

    private PublicacionDto dadoQueTengoDatosCorrectos() {
        PublicacionDto p = new PublicacionDto();
        Mascota m = new Mascota();
        m.setId(5L);
        p.setMascota(m);
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
        return this.servicioPublicacion.getPublicacion(id);
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
