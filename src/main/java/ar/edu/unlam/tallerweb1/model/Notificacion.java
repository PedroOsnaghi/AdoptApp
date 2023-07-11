package ar.edu.unlam.tallerweb1.model;

import ar.edu.unlam.tallerweb1.model.enumerated.TipoNotificacion;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TipoNotificacion tipo;
    private String params;
    private String param_mensaje;

    @Transient
    private String titulo;
    @Transient
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @CreationTimestamp
    private Timestamp fechaCreacion;

    public Notificacion() {
    }

    public Notificacion(TipoNotificacion tipo, Usuario usuario, String params) {
        this.tipo = tipo;
        this.params = params;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacion tipo) {
        this.tipo = tipo;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }


    public String getTitulo() {
        switch (this.tipo){
            case WELCOME: return "Te damos la bienvenida";
            case NUEVO_CHAT_ADOPT:
            case NUEVO_CHAT_PUB: return "Nuevo mensaje en chat";
            case NUEVA_PREGUNTA: return "Nueva pregunta";
            case NUEVA_SOLICITUD: return "Nueva solicitud de adopción";
            case ACEPT_SOLICITUD: return "Solicitud aceptada";
            case CANCEL_SOLICITUD: return "Se canceló la solicitud";
            default: return "Nueva Notificación";
        }
    }


    public String getMensaje() {
        switch (this.tipo){
            case WELCOME: return "Hola " + this.param_mensaje + ", te damos la bienvenida a AdoptApp";
            case NUEVO_CHAT_ADOPT:
            case NUEVO_CHAT_PUB: return "Tenés un nuevo mensaje de " + this.param_mensaje;
            case NUEVA_PREGUNTA: return "Tenés una nueva pregunta en la publicación de " + this.param_mensaje;
            case NUEVA_SOLICITUD: return "Recibiste una solicitud para " + this.param_mensaje;
            case ACEPT_SOLICITUD: return "Aceptaron tu solicitud en la publicación de " + this.param_mensaje;
            case CANCEL_SOLICITUD: return this.param_mensaje + " canceló la solicitud de adopción";
            default: return "Tenés una nueva notificación";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}