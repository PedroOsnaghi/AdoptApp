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

    private boolean leido;

    @Transient
    private String titulo;
    @Transient
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @CreationTimestamp
    private Timestamp fechaCreacion;

    @Transient
    private Publicacion publicacion;

    @Transient
    private Solicitud solicitud;

    @Transient
    private Mensaje mensajeObj;

    public Notificacion() {
    }

    public Notificacion(TipoNotificacion tipo, Object object) {
        this.create(tipo,object);
    }

    private void create(TipoNotificacion tipo, Object object) {
        if(object instanceof Publicacion) this.publicacion = (Publicacion) object;
        if(object instanceof Solicitud) this.solicitud = (Solicitud) object;
        if(object instanceof Usuario) this.usuario = (Usuario) object;
        if(object instanceof Mensaje) this.mensajeObj = (Mensaje) object;
        this.tipo = tipo;

        this.setNotification();
    }

    private void setNotification() {
        switch (this.tipo){
            case NUEVA_SOLICITUD:
            case NUEVA_PREGUNTA:
                this.usuario = this.publicacion.getMascota().getUsuario();
                this.params = this.publicacion.getId().toString();
                this.param_mensaje = this.publicacion.getMascota().getNombre();
                break;
            case NUEVA_RESPUESTA:
                this.usuario = this.mensajeObj.getEmisor();
                this.params = this.mensajeObj.getPublicacion().getId().toString();
                this.param_mensaje = this.mensajeObj.getPublicacion().getMascota().getNombre();
                break;
            case NUEVO_CHAT_ADOPT:
            case CANCEL_SOLICITUD:
                this.usuario = this.solicitud.getPublicacion().getMascota().getUsuario();
                this.params = this.solicitud.getCodigo();
                this.param_mensaje = this.solicitud.getUsuario().getNombre();
                break;
            case NUEVO_CHAT_PUB:
                this.usuario = this.solicitud.getUsuario();
                this.params = this.solicitud.getCodigo();
                this.param_mensaje = this.solicitud.getPublicacion().getMascota().getUsuario().getNombre();
                break;
            case ACEPT_SOLICITUD:
                this.usuario = this.solicitud.getUsuario();
                this.params = this.solicitud.getCodigo();
                this.param_mensaje = this.solicitud.getPublicacion().getMascota().getNombre();
                break;



        }
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
            case NUEVA_RESPUESTA: return "Respondieron tu pregunta";
            case NUEVA_SOLICITUD: return "Nueva solicitud de adopción";
            case ACEPT_SOLICITUD: return "Solicitud aceptada";
            case CANCEL_SOLICITUD: return "Se canceló el proceso de Adopción";
            default: return "Nueva Notificación";
        }
    }


    public String getMensaje() {
        switch (this.tipo){
            case WELCOME: return "Hola " + this.usuario.getNombre() + ", te damos la bienvenida a AdoptApp. Ya podes buscar tu proxima mascota.";
            case NUEVO_CHAT_ADOPT:
            case NUEVO_CHAT_PUB: return "Tenés un nuevo mensaje de " + this.param_mensaje;
            case NUEVA_PREGUNTA: return "Tenés una nueva pregunta en la publicación de " + this.param_mensaje;
            case NUEVA_RESPUESTA: return "Respondieron tu pregunta en la publicación de " + this.param_mensaje;
            case NUEVA_SOLICITUD: return "Recibiste una solicitud para " + this.param_mensaje;
            case ACEPT_SOLICITUD: return "Aceptaron tu solicitud en la publicación de " + this.param_mensaje;
            case CANCEL_SOLICITUD: return this.param_mensaje + " canceló el proceso de adopción";
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

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}