package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.web.multipart.MultipartFile;

public class TestArchivo {

    private MultipartFile imagen;

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }
}
