package ar.edu.unlam.tallerweb1.domain;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

@Service
public class ServicioIngresarMascota implements IServicioIngresarMascota {
    public boolean sonValidos(String nombre, Enum tipo, Date nacimiento , String obs , File foto) {
        return nombre.length() > 0 && tipo != null;
    }


}
