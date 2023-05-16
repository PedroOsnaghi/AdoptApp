package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.domain.config.FileResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

@Service
public class ServicioArchivo {

    private final FileResolver fileResolver;
    private final String defaultImage = "default.jpg";

    @Autowired
    public ServicioArchivo(FileResolver fr) {
        this.fileResolver = fr;
    }

    public String subirAvatarUsuario(MultipartFile multipart) {

        return this.guardarArchivo(multipart, this.getDir("user") )? multipart.getOriginalFilename() : defaultImage;

    }

    public String subirAvatarMascota(MultipartFile multipart) {

        return this.guardarArchivo(multipart, this.getDir("mascota") )? multipart.getOriginalFilename() : defaultImage;

    }

    public int subirImagenes(MultipartFile[] files) {

        int subidos = 0;

        for (MultipartFile file : files) {

            if (this.guardarArchivo(file, this.getDir("posts"))) {
                subidos++;

                //TODO: guardar en Tabla Archivos
            }
        }

        return subidos;
    }

    public String cambiarAvatarUsuario(MultipartFile file, String oldFile){
        return this.verificarAvatar(file,oldFile,"user");
    }

    public String cambiarAvatarMascota(MultipartFile file, String oldFile){
       return this.verificarAvatar(file,oldFile,"mascota");
    }

    private String verificarAvatar(MultipartFile file, String oldFile, String folder){
        if(!file.isEmpty()){
            this.eliminarArchivo(oldFile,folder);
            return this.guardarArchivo(file, this.getDir(folder) )? file.getOriginalFilename() : oldFile;
        }
        return oldFile;
    }

    private boolean eliminarArchivo(String fileName, String folder){
        File archivo = new File(this.getDir(folder) + File.separator + fileName);

        if(archivo.delete()){
            System.out.println("Se elimino del Archivo " + fileName);
            return true;
        }

        return false;
    }

  

    private boolean guardarArchivo(MultipartFile file, String folder) {
        boolean result = false;

        try {
            if (!file.isEmpty()) {
                //Creacion del directorio donde vamos a alojar el archivo
                File dir = new File(folder);

                //formamos el nombre completo del archivo a guardar
                File imageFile = new File(dir + File.separator + this.getPrefix() + "_" + file.getOriginalFilename());


                //guardamos fisicamente
                file.transferTo(imageFile);

                System.out.println("El Archivo se guardo en: " + imageFile.getAbsolutePath());

                result = true;
            }
        } catch (IOException e) {
            System.out.println("Error Al subir Archivo: " + e.getMessage());
        }


        return result;

    }

    private String getDir(String uploadFolder) {
        File dir = new File(fileResolver.getImageFolder() + File.separator + uploadFolder);

        if (!dir.exists()) dir.mkdirs();

        return dir.getAbsolutePath();
    }

    private String getPrefix(){
        Timestamp pre = new Timestamp(System.currentTimeMillis());

        return String.valueOf(pre.getTime());

    }


}
