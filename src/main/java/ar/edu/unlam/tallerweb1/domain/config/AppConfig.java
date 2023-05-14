package ar.edu.unlam.tallerweb1.domain.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Paths;

@Service
public class AppConfig {

    final static String APP_CONTEXT = "proyecto_limpio_spring_war";
    private String dirRoot;
    private String imageFolder;


    @Autowired
    public void AppConfig() {

        this.dirRoot = System.getProperty("catalina.home") + File.separator + "webapps" + File.separator + APP_CONTEXT;
        this.imageFolder = Paths.get(this.dirRoot + File.separator + "images").toFile().getAbsolutePath();
    }

    public String getDirRoot() {
        return dirRoot;
    }

    public String getImageFolder() {
        return imageFolder;
    }


}
