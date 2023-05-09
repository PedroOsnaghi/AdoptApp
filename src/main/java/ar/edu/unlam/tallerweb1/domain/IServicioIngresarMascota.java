package ar.edu.unlam.tallerweb1.domain;

import java.io.File;
import java.util.Date;

public interface IServicioIngresarMascota {


    boolean sonValidos(String nombre, Enum tipo,  Date nacimiento , String obs , File foto);
}
