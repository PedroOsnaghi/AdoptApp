package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.domain.config.AppConfig;
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

    private AppConfig cfg;

    @Before
    public void init(){
        this.cfg = mock(AppConfig.class);
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
        regresaElNombrePorDefecto(archivo,"USER");
    }

    @Test
    public void alNoEncontrarArchivosDeSubidaDebeRetornarElAvatarPorDefecto_casoMascota() throws IOException {
        dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String archivo = alGuardarloEnelServidor("MASCOTA");
        regresaElNombrePorDefecto(archivo,"MASCOTA");
    }

    private void regresaElNombrePorDefecto(String archivo, String tipo) {
        if (tipo == "USER")  assertThat(archivo).isEqualTo("default.jpg");
        if (tipo == "MASCOTA")  assertThat(archivo).isEqualTo("default.webp");
    }

    private void dadoQueNoHayArchivosParaSerSubidoAlServidor() {
        multipartFile = new MockMultipartFile("file", "".getBytes());

        when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");
    }


    private void regresaElNombreDelArchivoGuardado(String archivo) {
        assertThat(archivo).isEqualTo(archivoASubir);
    }

    private String alGuardarloEnelServidor(String tipo) {
        if(tipo =="USER")
            return servicioArchivo.guardarAvatar(multipartFile, ServicioArchivo.avatarType.USER);
         return servicioArchivo.guardarAvatar(multipartFile, ServicioArchivo.avatarType.MASCOT);
    }

    private void dadoQueExisteUnArchivoParaSerSubidoAlServidor() throws IOException {
        File archivo = new File(System.getProperty("user.dir") + "\\src\\main\\webapp\\images\\brand\\" + archivoASubir);
        FileInputStream fis = new FileInputStream(archivo);
        multipartFile = new MockMultipartFile("file", archivoASubir, "image/png", fis);

        when(cfg.getImageFolder()).thenReturn("c:\\archivossubidos");

    }
}
