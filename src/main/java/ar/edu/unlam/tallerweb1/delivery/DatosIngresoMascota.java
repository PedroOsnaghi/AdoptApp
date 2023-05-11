package ar.edu.unlam.tallerweb1.delivery;

import java.io.File;
import java.util.Date;

public class DatosIngresoMascota {

    private String nombre;
    private String tipo;

    private String raza;



    private Float peso;
    private Date nacimiento;
    private String obs;
    private File foto;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getObs() {
        return obs;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
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
