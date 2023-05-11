package ar.edu.unlam.tallerweb1.domain;

import java.io.File;
import java.util.Date;

public interface IServicioMascota {


    boolean sonValidos(String nombre, String tipo, String Raza, Float peso, Date nacimiento , String obs , File foto);
}
