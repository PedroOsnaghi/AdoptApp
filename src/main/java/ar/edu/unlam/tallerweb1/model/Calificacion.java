package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.model.enumerated.RolCalificacion;


import javax.persistence.*;

@Entity
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCalificado;

    @Enumerated(value = EnumType.STRING)
    private RolCalificacion rol;

    private Double calificacion;

    private String commentario;

    public Calificacion(){}

    public Calificacion(Usuario usuarioCalificado, RolCalificacion rol, Double calificacion, String commentario) {
        this.usuarioCalificado = usuarioCalificado;
        this.rol = rol;
        this.calificacion = calificacion;
        this.commentario = commentario;
    }

    public Calificacion(Double calificacion){
        this.calificacion = calificacion;
    }

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
