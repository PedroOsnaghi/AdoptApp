package ar.edu.unlam.tallerweb1.delivery.dto;

import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.RolCalificacion;

import javax.persistence.*;

public class CalificacionDto {

    private Long id;

    private Usuario usuarioCalificado;


    private RolCalificacion rol;

    private Double calificacion;

    private String commentario;

    public CalificacionDto(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioCalificado() {
        return usuarioCalificado;
    }

    public void setUsuarioCalificado(Usuario usuarioCalificado) {
        this.usuarioCalificado = usuarioCalificado;
    }

    public RolCalificacion getRol() {
        return rol;
    }

    public void setRol(RolCalificacion rol) {
        this.rol = rol;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getCommentario() {
        return commentario;
    }

    public void setCommentario(String commentario) {
        this.commentario = commentario;
    }

}
