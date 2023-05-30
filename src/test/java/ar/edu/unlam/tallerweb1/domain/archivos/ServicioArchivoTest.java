package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.domain.config.FileResolver;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioArchivo;
import ar.edu.unlam.tallerweb1.model.Imagen;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioArchivoTest {

    private final String path_base = "src/test/java/ar/edu/unlam/tallerweb1/domain/archivos";

    private final String path_upload = "src/test/java/ar/edu/unlam/tallerweb1/domain/archivos/upload";

    private String imagenPost_subida = "1685422134652_02.jpg";

    private ServicioArchivo servicioArchivo;

    private RepositorioArchivo repositorioArchivo;

    private FileResolver cfg;

    @Before
    public void init(){
        this.cfg = mock(FileResolver.class);
        this.repositorioArchivo = mock(RepositorioArchivo.class);
        this.servicioArchivo = new ServicioArchivo(repositorioArchivo, cfg);
    }


    @Test
    public void alSubirUnaFotoDeUsuarioSeDebePoderAccederAEllaPorSuNombre() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor(multipartFile,"user");
        podemosAccederlaPorSuNombre(archivo, "user");
    }

    @Test
    public void alSubirUnaFotoDeMascotaSeDebePoderAccederAEllaPorSuNombre() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor( multipartFile,"mascota");
        podemosAccederlaPorSuNombre(archivo, "mascota");
    }

    @Test
    public void alNoSubirUnaFotoDeUsuarioDebeRetornarLaImagenPorDefecto() {
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor(multipartFile,"user");
        regresaElNombrePorDefecto(archivo);
    }

    @Test
    public void alNoSubirUnaFotoDeMascotaDebeRetornarLaImagenPorDefecto() {
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor(multipartFile,"mascota");
        regresaElNombrePorDefecto(archivo);
    }

    @Test
    public void paraUnaPublicacionSeDebePoderSubirVariasFotosYObtenerlaCantidad() throws IOException {
        MultipartFile[] files = dadoQueHayVariosArchivosParaSubir();
        int cantidad = alGuardarLosArchivosEnElSrvidor(files);
        podemosSaberCuantosSeSubieron(cantidad);
    }

    @Test
    public void paraUnaPublicacionSeDebePoderEliminarFotos() throws IOException {
        String imagen = dadoQueExisteUnaImagenSubida();
        boolean resultado = alEliminarseDelServidor(imagen);
        obtenemosElResutadoCorrecto(resultado);
    }


    @Test
    public void cuandoNoSeSubeFotoParaUnUsuarioDebeREtornarLaImagenQueTenia(){
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "usuario");
        debeObtenerElAvatarActual(archivo);

    }

    @Test
    public void cuandoNoSeSubeFotoParaUnaMascotaDebeREtornarLaImagenQueTenia(){
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "mascota");
        debeObtenerElAvatarActual(archivo);

    }

    @Test
    public void alCambiarLaFotoDeUnaMascotaDebemosObtenerElNombreDeLaNuevaImagen() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "mascota");
        podemosAccederlaPorSuNombre(archivo, "mascota");

    }

    @Test
    public void alCambiarLaFotoDeUnUsuarioDebemosObtenerElNombreDeLaNuevaImagen() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "user");
        podemosAccederlaPorSuNombre(archivo, "user");

    }


    private void obtenemosElResutadoCorrecto(boolean resultado) {
        assertThat(resultado).isEqualTo(true);
    }

    private boolean alEliminarseDelServidor(String imagen) {
        when(this.repositorioArchivo.obtenerImagen(imagen)).thenReturn(new Imagen(imagen,new Publicacion()));
        when(this.cfg.getImageFolder()).thenReturn(path_upload);
        return this.servicioArchivo.eliminarImagenPost(imagen);
    }

    private String dadoQueExisteUnaImagenSubida() throws IOException {
        String path = path_base + File.separator + "toupload";
        //archivo 1
        File archivo = new File(path + File.separator + "02.jpg");

        FileInputStream fis = new FileInputStream(archivo);

        MockMultipartFile mf1  = new MockMultipartFile("file1", "02.jpg", "image/jpg", fis);

        MultipartFile[] files = {mf1};
        Publicacion post = new Publicacion();
        post.setId(1L);

        when(this.repositorioArchivo.registrarImagen(new Imagen("02.jpg",post))).thenReturn(10L);
        when(this.cfg.getImageFolder()).thenReturn(path_upload);
        this.servicioArchivo.subirImagenesPost(files, post);

        return this.servicioArchivo.getImagenesSubidas().get(0);

    }

    private void debeObtenerElAvatarActual(String archivo) {
        assertThat(archivo).isEqualTo("avatar.png");
    }

    private String alVerificarEnElServidor(MultipartFile multipartFile, String tipo) {
        String avatarActual = "avatar.png";
        if(tipo.equals("user")){
            return servicioArchivo.cambiarAvatarUsuario(multipartFile, avatarActual);
        }
        return servicioArchivo.cambiarAvatarMascota(multipartFile, avatarActual);
    }

    private void podemosSaberCuantosSeSubieron(int cantidad) {
        assertThat(cantidad).isEqualTo(3);
    }

    private int alGuardarLosArchivosEnElSrvidor(MultipartFile[] files) {
        Publicacion post = new Publicacion();
        post.setId(10L);
        return this.servicioArchivo.subirImagenesPost(files, post);
    }

    private MultipartFile[] dadoQueHayVariosArchivosParaSubir() throws IOException {
        String path = path_base + File.separator + "toupload";

        //archivo 1
        File archivo = new File(path + File.separator + "02.jpg");

        FileInputStream fis = new FileInputStream(archivo);

        MockMultipartFile mf1  = new MockMultipartFile("file1", "02.jpg", "image/jpg", fis);

        //archivo 2
        archivo = new File(path + File.separator + "03.jpg");

        fis = new FileInputStream(archivo);

        MockMultipartFile mf2  = new MockMultipartFile("file2", "03.jpg", "image/jpg", fis);

        //archivo 3
        archivo = new File(path + File.separator + "04.jpg");

        fis = new FileInputStream(archivo);

        MockMultipartFile mf3  = new MockMultipartFile("file3", "04.jpg", "image/jpg", fis);

        //arreglo MultiPartFile

        MultipartFile[] files = {mf1, mf2, mf3};

        when(cfg.getImageFolder()).thenReturn(path_upload);

        return files;

    }

    private void regresaElNombrePorDefecto(String archivo) {
        assertThat(archivo).isEqualTo("default.jpg");
    }

    private MultipartFile dadoQueNoHayArchivosParaSerSubidoAlServidor() {
        MultipartFile multipartFile = new MockMultipartFile("file", "".getBytes());
        when(cfg.getImageFolder()).thenReturn(path_upload);

        return multipartFile;
    }

    private void podemosAccederlaPorSuNombre(String archivo, String folder) {
        File archivoGuardado = new File(path_upload + File.separator + folder + File.separator + archivo);
        assertThat(archivo).isEqualTo(archivoGuardado.getName());
    }

    private String alGuardarloEnelServidor(MultipartFile multipartFile, String tipo) {
        if(tipo.equals("user"))
            return servicioArchivo.subirAvatarUsuario(multipartFile);
         return servicioArchivo.subirAvatarMascota(multipartFile);
    }

    private MultipartFile dadoQueExisteUnArchivoParaSerSubidoAlServidor() throws IOException {
        File archivo = new File(path_base + File.separator + "toupload"
                + File.separator + "01.jpg");
        FileInputStream fis = new FileInputStream(archivo);
        MultipartFile multipartFile = new MockMultipartFile("file", "01.jpg", "image/jpg", fis);

        when(cfg.getImageFolder()).thenReturn(path_upload);
        return multipartFile;
    }
}
