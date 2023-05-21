package ar.edu.unlam.tallerweb1.domain.mascota;

import ar.edu.unlam.tallerweb1.Genero;
import ar.edu.unlam.tallerweb1.Personalidad;
import ar.edu.unlam.tallerweb1.Tipo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

@Service
public class ServicioIngresarMascota implements IServicioMascota {
    public boolean sonValidos(String nombre, Tipo tipo, Genero genero, String raza, Float peso, Date nacimiento , Personalidad personalidad, String obs , File foto) {
        return (nombre.length() > 0 && tipo != null);
    }



}
