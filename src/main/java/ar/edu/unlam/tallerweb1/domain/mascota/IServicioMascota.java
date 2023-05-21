package ar.edu.unlam.tallerweb1.domain.mascota;

import ar.edu.unlam.tallerweb1.Genero;
import ar.edu.unlam.tallerweb1.Personalidad;
import ar.edu.unlam.tallerweb1.Tipo;

import java.io.File;
import java.util.Date;

public interface IServicioMascota {


    boolean sonValidos(String nombre, Tipo tipo, Genero genero, String Raza, Float peso, Date nacimiento , Personalidad personalidad, String obs , File foto);
}
