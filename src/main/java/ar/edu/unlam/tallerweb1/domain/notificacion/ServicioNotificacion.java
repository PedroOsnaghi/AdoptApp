package ar.edu.unlam.tallerweb1.domain.notificacion;

import ar.edu.unlam.tallerweb1.model.Notificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.TipoNotificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioNotificacion implements IServicioNotificacion
{
    IRepositorioNotificacion repositorioNotificacion;



    @Autowired
    public ServicioNotificacion(IRepositorioNotificacion repositorioNotificacion){
        this.repositorioNotificacion = repositorioNotificacion;

    }

    @Override
    public Long crearNotificacion(TipoNotificacion tipo, Object object){
        Notificacion notificacion = new Notificacion(tipo, object);

        return this.repositorioNotificacion.crearNotificacion(notificacion);
    }

    @Override
    public void eliminarNotificacion(Notificacion notificacion){
        this.repositorioNotificacion.eliminarNotificacion(notificacion);
    }

    @Override
    public List<Notificacion> listarNotificaciones (Usuario user){
        return this.repositorioNotificacion.listarNotificaciones(user.getId());
    }

    @Override
    public Notificacion getNotificacion(Long idNotificacion) {
        return this.repositorioNotificacion.getNotificacion(idNotificacion);
    }

    @Override
    public void marcarLeidas(Usuario usuario) {
        this.repositorioNotificacion.marcarLeidas(usuario.getId());
    }

    @Override
    public Long getNewNotifications(Usuario usuario) {
        return this.repositorioNotificacion.getNewNotifications(usuario.getId());
    }


}
