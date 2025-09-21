package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioArchivo;
import ar.edu.unlam.tallerweb1.model.Imagen;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioArchivoTest {

    private final String path_base = "src/test/java/ar/edu/unlam/tallerweb1/domain/archivos";


    private String imagenPost_subida = "1685422134652_02.jpg";

    private ServicioArchivo servicioArchivo;

    private RepositorioArchivo repositorioArchivo;



    @Before
    public void init(){
        this.repositorioArchivo = mock(RepositorioArchivo.class);
        this.servicioArchivo = new ServicioArchivo(repositorioArchivo);
    }


    @Test
    public void alSubirUnaImagenDebemosObtenerUnStringEnBase64() throws IOException {
        MultipartFile multipartFile = dadoQueExisteUnArchivoParaSerSubidoAlServidor();
        String encodedBase64 = alEnviarlo(multipartFile);
        obtenemosUnStringNoNulo(encodedBase64);
    }


    @Test
    public void alNoSubirUnaImagenNosDebeRetornarNull() {
        MultipartFile multipartFile = dadoQueNoHayArchivosParaSerSubidoAlServidor();
        String encodedBase64 = alEnviarlo(multipartFile);
        obtenemosNull(encodedBase64);
    }




    @Test
    public void paraUnaPublicacionSeDebePoderEliminarFotos() throws IOException {
        String imagen = dadoQueExisteUnaImagenSubida();
        boolean resultado = alEliminarseDelServidor(imagen);
        obtenemosElResutadoCorrecto(resultado);
    }



    private void obtenemosElResutadoCorrecto(boolean resultado) {
        assertThat(resultado).isEqualTo(true);
    }

    private boolean alEliminarseDelServidor(String imagen) {
        when(this.repositorioArchivo.obtenerImagen(imagen)).thenReturn(new Imagen(imagen,new Publicacion()));
        return this.servicioArchivo.eliminarImagenPost(2L);
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
        this.servicioArchivo.subirImagenesPost(files, post);

        return "";

    }

    private void debeObtenerElAvatarActual(String archivo) {
        assertThat(archivo).isEqualTo("avatar.png");
    }

    private String alVerificarEnElServidor(MultipartFile multipartFile, String tipo) {
        String avatarActual = "avatar.png";
        if(tipo.equals("user")){
            return "";
        }
        return "";
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


        return files;

    }

    private void obtenemosNull(String encodedString) {
        assertThat(encodedString).isNull();
    }

    private MultipartFile dadoQueNoHayArchivosParaSerSubidoAlServidor() {
        MultipartFile multipartFile = new MockMultipartFile("file", "".getBytes());

        return multipartFile;
    }

    private void obtenemosUnStringNoNulo(String encodedString) {
        assertThat(encodedString).isNotNull();
    }

    private String alEnviarlo(MultipartFile multipartFile) {
        return this.servicioArchivo.encodeImage(multipartFile);
    }


    private MultipartFile dadoQueExisteUnArchivoParaSerSubidoAlServidor() throws IOException {
        File archivo = new File(path_base + File.separator + "toupload"
                + File.separator + "01.jpg");
        FileInputStream fis = new FileInputStream(archivo);
        MultipartFile multipartFile = new MockMultipartFile("file", "01.jpg", "image/jpg", fis);

        return multipartFile;
    }



}
