package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.model.enumerated.TipoBusqueda;

public class ResultadoBusqueda {

    public String imagen;

    public String nombre;
    public String descripcion;
    public TipoBusqueda tipo;
    public Long idResultado;

    public ResultadoBusqueda(String imagen, String nombre, String descripcion, TipoBusqueda tipo, Long idResultado) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idResultado = idResultado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoBusqueda getTipo() {
        return tipo;
    }

    public void setTipo(TipoBusqueda tipo) {
        this.tipo = tipo;
    }

    public Long getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Long idResultado) {
        this.idResultado = idResultado;
    }
}
