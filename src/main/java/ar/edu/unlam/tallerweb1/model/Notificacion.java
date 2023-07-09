package ar.edu.unlam.tallerweb1.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String mensaje;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @CreationTimestamp
    private Date fechaCreacion;

    public Notificacion() {
    }

    public Notificacion(Usuario usuario, String url, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Long getId() {
        return id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}