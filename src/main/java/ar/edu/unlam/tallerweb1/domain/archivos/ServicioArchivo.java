package ar.edu.unlam.tallerweb1.domain.archivos;
import ar.edu.unlam.tallerweb1.domain.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class ServicioArchivo {

    private AppConfig config;
    private final String defaultImage = "default.jpg";

    public enum avatarType{
        USER,
        MASCOT
    }

    @Autowired
    public ServicioArchivo(AppConfig cfg){
        this.config = cfg;
   }


    public String subirAvatar(MultipartFile multipart, avatarType type){

        String nombreArchivo = this.defaultImage;
        String uploadFolder = this.getFolder(type);

        if(!multipart.isEmpty()) {
            //obtenemos el nombre original del archivo
            nombreArchivo = multipart.getOriginalFilename();

            try {
                //Creacion del directorio donde vamos a alojar el archivo
                File dir = new File(this.getDir(uploadFolder));

                //formamos el nombre completo del archivo a guardar
                File imageFile = new File( dir + File.separator + nombreArchivo );


                //guardamos fisicamente
                multipart.transferTo(imageFile);


            }catch (IOException e) {
                System.out.println("Error Al subir Archivo: " + e.getMessage());
                //retornamos imagen por defecto
                nombreArchivo = this.defaultImage;
            }

        }

        return nombreArchivo;



    }

    private String getDir(String uploadFolder) {
        File dir = new File(config.getImageFolder() + File.separator + uploadFolder);
        System.out.println("Dir" + config.getImageFolder());
        System.out.println("Directorio a guardar: " + dir.getAbsolutePath());
        if(!dir.exists()) dir.mkdirs();



        return dir.getAbsolutePath();
    }

    private String getFolder(avatarType type) {
        return (type == avatarType.USER) ? "user" : "mascota";
    }




}
