package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.model.enumerated.RolCalificacion;

import java.text.DecimalFormat;

public class UsuarioConCalificacion {

    private Usuario usuario;

    private Double calificacion;



    public UsuarioConCalificacion(Double calificacion){
        this.calificacion = calificacion;

    }

    public UsuarioConCalificacion(Usuario usuario, Double calificacion){
        this.calificacion = calificacion;
        this.usuario = usuario;
    }

    public String getCalificacion() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format(calificacion);
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getCalToPercent(){
        double r = (this.calificacion * 100) / 5;
        return r;
    }

}
