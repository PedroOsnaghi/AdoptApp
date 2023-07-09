package ar.edu.unlam.tallerweb1.domain.notificacion;


import ar.edu.unlam.tallerweb1.infrastructure.RepositorioNotificacion;
import ar.edu.unlam.tallerweb1.model.Notificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
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
    public Long crearNotificacion(Notificacion notificacion){
        return this.repositorioNotificacion.crearNotificacion(notificacion);
    };

    @Override
    public void eliminarNotificacion(Notificacion notificacion){
        this.repositorioNotificacion.eliminarNotificacion(notificacion);
    };

    @Override
    public List<Notificacion> listarNotificaciones (Usuario user){
        return this.repositorioNotificacion.listarNotificaciones(user.getId());
    };
}
