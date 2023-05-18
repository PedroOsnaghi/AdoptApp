package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.web.multipart.MultipartFile;

public class DatosArchivo {

    MultipartFile imagen;

    MultipartFile[] images;

    String nombre;

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public MultipartFile[] getImages() {
        return images;
    }

    public void setImages(MultipartFile[] images) {
        this.images = images;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
