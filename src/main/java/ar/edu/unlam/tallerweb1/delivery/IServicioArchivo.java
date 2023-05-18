package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.web.multipart.MultipartFile;

public interface IServicioArchivo {
    String subirAvatarUsuario(MultipartFile multipart);
}
