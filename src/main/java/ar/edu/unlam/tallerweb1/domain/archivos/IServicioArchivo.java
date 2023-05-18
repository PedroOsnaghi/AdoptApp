package ar.edu.unlam.tallerweb1.domain.archivos;

import org.springframework.web.multipart.MultipartFile;

public interface IServicioArchivo {
    String subirAvatarUsuario(MultipartFile multipart);

    int subirImagenesPost(MultipartFile[] files);
}
