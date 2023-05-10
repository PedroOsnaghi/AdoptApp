package ar.edu.unlam.tallerweb1.delivery;

import java.io.File;
import java.util.Date;

public class DatosIngresoMascota {

    private String nombre;

    private Tipo tipo;

    private Date nacimiento;
    private String obs;
    private File foto;




    public DatosIngresoMascota() {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nacimiento = nacimiento;
        this.obs = obs;
        this.foto = foto;


    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Tipo getTipo(){
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }





}
