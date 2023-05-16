package ar.edu.unlam.tallerweb1.domain.archivos;
import ar.edu.unlam.tallerweb1.domain.config.FileResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class ServicioArchivo {

    private final FileResolver fileResolver;


    @Autowired
    public ServicioArchivo(FileResolver fr){
        this.fileResolver = fr;
   }


    public String subirAvatar(MultipartFile multipart, String folder){

        String defaultImage = "default.jpg";
        String nombreArchivo = defaultImage;

        if(!multipart.isEmpty()) {
            //obtenemos el nombre original del archivo
            nombreArchivo = multipart.getOriginalFilename();

            try {
                //Creacion del directorio donde vamos a alojar el archivo
                File dir = new File(this.getDir(folder));

                //formamos el nombre completo del archivo a guardar
                File imageFile = new File( dir + File.separator + nombreArchivo );


                //guardamos fisicamente
                multipart.transferTo(imageFile);

                System.out.println("El Archivo se guardo en: " + imageFile.getAbsolutePath());

            }catch (IOException e) {
                System.out.println("Error Al subir Archivo: " + e.getMessage());
                //retornamos imagen por defecto
                nombreArchivo = defaultImage;
            }

        }

        return nombreArchivo;

    }



    private String getDir(String uploadFolder) {
        File dir = new File(fileResolver.getImageFolder() + File.separator + uploadFolder);

        if(!dir.exists()) dir.mkdirs();

        return dir.getAbsolutePath();
    }





}
