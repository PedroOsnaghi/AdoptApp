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

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioArchivoTest {

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
    public void alSubirUnAvatarDebeRetornarElNombreDelArchivoGuardado_casoUsuario() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor(multipartFile,"USER");
        regresaElNombreDelArchivoGuardado(archivo);
    }

    @Test
    public void alSubirUnAvatarDebeRetornarElNombreDelArchivoGuardado_casoMascota() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor( multipartFile,"MASCOTA");
        regresaElNombreDelArchivoGuardado(archivo);
    }

    @Test
    public void alNoEncontrarArchivosDeSubidaDebeRetornarElAvatarPorDefecto_casoUsuario() {
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor(   multipartFile,"USER");
        regresaElNombrePorDefecto(archivo);
    }

    @Test
    public void alNoEncontrarArchivosDeSubidaDebeRetornarElAvatarPorDefecto_casoMascota() {
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor(multipartFile,"MASCOTA");
        regresaElNombrePorDefecto(archivo);
    }

    @Test
    public void alSubirVariosArchivosAlServidorDebemosObtenerLaCantidadDeArchivosGuardados() throws IOException {
        MultipartFile[] files = dadoQueHayVariosArchivosParaSubir();
        int cantidad = alGuardarLosArchivosEnElSrvidor(files);
        podemosSaberCuantosSeSubieron(cantidad);
    }

    @Test
    public void alTenerAvatarYNoHaberImagenesDeSubidaDebeRetornarElAvatarActual_usuario(){
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "usuario");
        debeObtenerElAvatarActual(archivo);

    }

    @Test
    public void alTenerAvatarYNoHaberImagenesDeSubidaDebeRetornarElAvatarActual_mascota(){
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "mascota");
        debeObtenerElAvatarActual(archivo);

    }

    @Test
    public void alTenerAvatarYHaberImagenesDeSubidaDebeRetornarLaImagenSubida_mascota() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "mascota");
        regresaElNombreDelArchivoGuardado(archivo);

    }

    @Test
    public void alTenerAvatarYHaberImagenesDeSubidaDebeRetornarLaImagenSubida_usuario() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alVerificarEnElServidor(multipartFile, "usuario");
        regresaElNombreDelArchivoGuardado(archivo);

    }

    @Test
    public void alExistirUnaImagenEnElServidorDebePoderEliminarse() throws IOException {
        Long id_imagen = dadoQueExisteUnaImagenSubida();
        boolean resultado = alEliminarseDelServidor(id_imagen);
        obtenemosElResutadoCorrecto(resultado);
    }

    private void obtenemosElResutadoCorrecto(boolean resultado) {
        assertThat(resultado).isEqualTo(true);
    }

    private boolean alEliminarseDelServidor(Long idImagen) {
        return this.servicioArchivo.eliminarImagenPost(idImagen);
    }

    private Long dadoQueExisteUnaImagenSubida() throws IOException {
        String path = System.getProperty("user.dir")
                + File.separator +  "src"
                + File.separator + "main"
                + File.separator + "webapp"
                + File.separator + "images"
                + File.separator + "user";


        //archivo 1
        File archivo = new File(path + File.separator + "01.jpg");

        FileInputStream fis = new FileInputStream(archivo);

        MockMultipartFile mf1  = new MockMultipartFile("file1", "01.jpg", "image/jpg", fis);

        //arreglo MultiPartFile

        MultipartFile[] files = {mf1};

        //when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
        when(cfg.getImageFolder()).thenReturn("/volumes/Datos/test-upload");

        Publicacion post = new Publicacion();
        post.setId(10L);

        this.servicioArchivo.subirImagenesPost(files, post);

        Imagen img = new Imagen();
        img.setId(1L);
        img.setNombre(this.servicioArchivo.getImagenesSubidas().get(0));

        when(repositorioArchivo.obtenerImagen(1L)).thenReturn(img);


        return img.getId();

    }

    private void debeObtenerElAvatarActual(String archivo) {
        assertThat(archivo).isEqualTo("avatar.png");
    }

    private String alVerificarEnElServidor(MultipartFile multipartFile, String tipo) {
        String avatarActual = "avatar.png";
        if(tipo.equals("usuario")){
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
        String path = System.getProperty("user.dir")
                + File.separator +  "src"
                + File.separator + "main"
                + File.separator + "webapp"
                + File.separator + "images"
                + File.separator + "user";


        //archivo 1
        File archivo = new File(path + File.separator + "01.jpg");

        FileInputStream fis = new FileInputStream(archivo);

        MockMultipartFile mf1  = new MockMultipartFile("file1", "01.jpg", "image/jpg", fis);

        //archivo 2
        archivo = new File(path + File.separator + "02.jpg");

        fis = new FileInputStream(archivo);

        MockMultipartFile mf2  = new MockMultipartFile("file2", "02.jpg", "image/jpg", fis);

        //archivo 3
        archivo = new File(path + File.separator + "03.jpg");

        fis = new FileInputStream(archivo);

        MockMultipartFile mf3  = new MockMultipartFile("file3", "03.jpg", "image/jpg", fis);

        //arreglo MultiPartFile

        MultipartFile[] files = {mf1, mf2, mf3};

        //when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
        when(cfg.getImageFolder()).thenReturn("/volumes/Datos/test-upload");

        return files;

    }

    private void regresaElNombrePorDefecto(String archivo) {
        assertThat(archivo).isEqualTo("default.jpg");
    }

    private MultipartFile dadoQueNoHayArchivosParaSerSubidoAlServidor() {
        MultipartFile multipartFile = new MockMultipartFile("file", "".getBytes());
        //when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
        when(cfg.getImageFolder()).thenReturn("/Volumes/Datos/test-upload");

        return multipartFile;
    }

    private void regresaElNombreDelArchivoGuardado(String archivo) {
        assertThat(archivo).isEqualTo("loader.png");
    }

    private String alGuardarloEnelServidor(MultipartFile multipartFile, String tipo) {
        if(tipo.equals("USER"))
            return servicioArchivo.subirAvatarUsuario(multipartFile);
         return servicioArchivo.subirAvatarMascota(multipartFile);
    }

    private MultipartFile dadoQueExisteUnArchivoParaSerSubidoAlServidor() throws IOException {
        File archivo = new File(System.getProperty("user.dir")
                + File.separator +  "src"
                + File.separator + "main"
                + File.separator + "webapp"
                + File.separator + "images"
                + File.separator + "brand"
                + File.separator + "loader.png");
        FileInputStream fis = new FileInputStream(archivo);
        MultipartFile multipartFile = new MockMultipartFile("file", "loader.png", "image/png", fis);

        //when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
        when(cfg.getImageFolder()).thenReturn("/volumes/Datos/test-upload");
        return multipartFile;
    }
}
