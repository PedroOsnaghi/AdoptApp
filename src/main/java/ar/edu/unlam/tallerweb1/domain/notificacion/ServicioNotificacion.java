package ar.edu.unlam.tallerweb1.domain.notificacion;


import ar.edu.unlam.tallerweb1.infrastructure.RepositorioNotificacion;
import ar.edu.unlam.tallerweb1.model.Notificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ServicioNotificacion implements IServicioNotificacion
{
    IRepositorioNotificacion repositorioNotificacion;
    HttpServletRequest request;


    @Autowired
    public ServicioNotificacion(IRepositorioNotificacion repositorioNotificacion, HttpServletRequest request){
        this.repositorioNotificacion = repositorioNotificacion;
        this.request = request;
    }

    @Override
    public Long crearNotificacion(Notificacion notificacion){
        String path = request.getContextPath();
        String newUrl = path + notificacion.getUrl();
        notificacion.setUrl(newUrl);
        return this.repositorioNotificacion.crearNotificacion(notificacion);
    };

    @Override
    public void eliminarNotificacion(Long id){
        this.repositorioNotificacion.eliminarNotificacion(id);
    };

    @Override
    public List<Notificacion> listarNotificaciones (Usuario user){
        return this.repositorioNotificacion.listarNotificaciones(user.getId());
    };
}
