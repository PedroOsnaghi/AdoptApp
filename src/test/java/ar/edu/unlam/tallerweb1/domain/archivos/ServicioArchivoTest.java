package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.domain.config.FileResolver;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioArchivoTest {

    private String archivoASubir = "loader.png";
    private MockMultipartFile multipartFile;

    private ServicioArchivo servicioArchivo;

    private FileResolver fr;

    @Before
    public void init(){
        this.fr = mock(FileResolver.class);
        this.servicioArchivo = new ServicioArchivo(fr);
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

    private void regresaElNombrePorDefecto(String archivo) {
        assertThat(archivo).isEqualTo("default.jpg");
    }

    private void dadoQueNoHayArchivosParaSerSubidoAlServidor() {
        multipartFile = new MockMultipartFile("file", "".getBytes());
        //when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
        when(fr.getImageFolder()).thenReturn("/Volumes/Datos/test-upload");
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
        when(fr.getImageFolder()).thenReturn("/volumes/Datos/test-upload");

    }
}
