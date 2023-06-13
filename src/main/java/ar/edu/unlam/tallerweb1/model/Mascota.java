package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.model.enumerated.GeneroMascota;
import ar.edu.unlam.tallerweb1.model.enumerated.TipoMascota;
import org.hibernate.annotations.Cascade;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String nombre;
    @Enumerated(value = EnumType.STRING)
    private TipoMascota tipo;
    @Enumerated(value = EnumType.STRING)
    private GeneroMascota genero;
    private String raza;
    private Float peso;
    private Date nacimiento;
    private String personalidad;
    private String salud;
    @Lob
    private String foto;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "mascota")
    private Publicacion publicacion;

    public Mascota(){}

    public Mascota(Long id){
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return StringUtils.capitalize(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }

    public GeneroMascota getGenero() {
        return genero;
    }

    public void setGenero(GeneroMascota genero) {
        this.genero = genero;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
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

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
