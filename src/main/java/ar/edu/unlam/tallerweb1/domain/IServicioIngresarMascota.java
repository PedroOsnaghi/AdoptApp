package ar.edu.unlam.tallerweb1.domain;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
@Service
public interface IServicioIngresarMascota {


    boolean sonValidos(String nombre, String tipo, String Raza, Float peso, Date nacimiento , String obs , File foto);
}
