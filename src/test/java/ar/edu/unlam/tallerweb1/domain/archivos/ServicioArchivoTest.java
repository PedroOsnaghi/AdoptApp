package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.domain.config.FileResolver;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioArchivoTest {

    private String archivoASubir = "loader.png";
    private MockMultipartFile multipartFile;

    private ServicioArchivo servicioArchivo;

    private FileResolver cfg;

    @Before
    public void init(){
        this.cfg = mock(FileResolver.class);
        this.servicioArchivo = new ServicioArchivo(cfg);
    }

    @Test
    public void alSubirUnAvatarDebeRetornarElNombreDelArchivoGuardado_casoUsuario() throws IOException {
        dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor("USER");
        regresaElNombreDelArchivoGuardado(archivo);
    }

    @Test
    public void alSubirUnAvatarDebeRetornarElNombreDelArchivoGuardado_casoMascota() throws IOException {
        dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor("MASCOTA");
        regresaElNombreDelArchivoGuardado(archivo);
    }

    @Test
    public void alNoEncontrarArchivosDeSubidaDebeRetornarElAvatarPorDefecto_casoUsuario() throws IOException {
        dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor("USER");
        regresaElNombrePorDefecto(archivo);
    }

    @Test
    public void alNoEncontrarArchivosDeSubidaDebeRetornarElAvatarPorDefecto_casoMascota() throws IOException {
        dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor("MASCOTA");
        regresaElNombrePorDefecto(archivo);
    }

    @Test
    public void alSubirVariosArchivosAlServidorDebemosObtenerLaCantidadDeArchivosGuardados() throws IOException {
        MultipartFile[] files = dadoQueHayVariosArchivosParaSubir();
        int cantidad = alGuardarLosArchivosEnElSrvidor(files);
        podemosSaberCuantosSeSubieron(cantidad);
    }

    private void podemosSaberCuantosSeSubieron(int cantidad) {
        assertThat(cantidad).isEqualTo(3);
    }

    private int alGuardarLosArchivosEnElSrvidor(MultipartFile[] files) {
        return this.servicioArchivo.subirImagenes(files);
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

    private void dadoQueNoHayArchivosParaSerSubidoAlServidor() {
        multipartFile = new MockMultipartFile("file", "".getBytes());
        //when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
        when(cfg.getImageFolder()).thenReturn("/Volumes/Datos/test-upload");
    }


    private void regresaElNombreDelArchivoGuardado(String archivo) {
        assertThat(archivo).isEqualTo(archivoASubir);
    }

    private String alGuardarloEnelServidor(String tipo) {
        if(tipo =="USER")
            return servicioArchivo.subirAvatar(multipartFile, "user");
         return servicioArchivo.subirAvatar(multipartFile, "mascota");
    }

    private void dadoQueExisteUnArchivoParaSerSubidoAlServidor() throws IOException {
        File archivo = new File(System.getProperty("user.dir")
                + File.separator +  "src"
                + File.separator + "main"
                + File.separator + "webapp"
                + File.separator + "images"
                + File.separator + "brand"
                + File.separator + archivoASubir);
        FileInputStream fis = new FileInputStream(archivo);
        multipartFile = new MockMultipartFile("file", archivoASubir, "image/png", fis);

        //when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
        when(cfg.getImageFolder()).thenReturn("/volumes/Datos/test-upload");

    }
}
