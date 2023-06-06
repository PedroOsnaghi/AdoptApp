package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import org.springframework.web.multipart.MultipartFile;

public interface IServicioArchivo {
    String encodeImage(MultipartFile multipart);

    String getDefaultUserImageEncoded();

    String getDefaultMascotImageEncoded();

    int subirImagenesPost(MultipartFile[] files, Publicacion post);

    boolean eliminarImagenPost(Long idImagen);
}
