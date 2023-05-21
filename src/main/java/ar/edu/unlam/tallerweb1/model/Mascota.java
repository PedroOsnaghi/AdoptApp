package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.Genero;
import ar.edu.unlam.tallerweb1.Personalidad;
import ar.edu.unlam.tallerweb1.Tipo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.util.Date;
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Tipo tipo;
    private Genero genero;
    private String raza;
    private Float peso;
    private Date nacimiento;



    private Personalidad personalidad;
    private String obs;
    private File foto;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero;}
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
    public Personalidad getPersonalidad() { return personalidad;}
    public void setPersonalidad(Personalidad personalidad) { this.personalidad = personalidad; }
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
