package ar.edu.unlam.tallerweb1.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class ChatMensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String codigo_solicitud;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String contenido;

    @CreationTimestamp
    private Timestamp create_at;

    public ChatMensaje(){
    }

    public ChatMensaje(String codigo_solicitud, Usuario usuario, String mensaje){
        this.codigo_solicitud = codigo_solicitud;
        this.usuario = usuario;
        this.contenido = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo_solicitud() {
        return codigo_solicitud;
    }

    public void setCodigo_solicitud(String codigo_solicitud) {
        this.codigo_solicitud = codigo_solicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMensaje)) return false;
        ChatMensaje that = (ChatMensaje) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCodigo_solicitud(), that.getCodigo_solicitud()) && Objects.equals(getUsuario(), that.getUsuario()) && Objects.equals(getContenido(), that.getContenido()) && Objects.equals(getCreate_at(), that.getCreate_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo_solicitud(), getUsuario(), getContenido(), getCreate_at());
    }
}
