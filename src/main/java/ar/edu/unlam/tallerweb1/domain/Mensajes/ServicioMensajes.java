package ar.edu.unlam.tallerweb1.domain.Mensajes;

import ar.edu.unlam.tallerweb1.domain.mascota.IRepositorioMascota;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMensajes implements IServicioMensajes{


    private final IRepositorioMensajes repositorioMensajes;

    @Autowired
    public ServicioMensajes(IRepositorioMensajes repositorioMensajes){
        this.repositorioMensajes = repositorioMensajes;
    }

    @Override
    public Long enviarMensaje(Mensaje msj) {
        return null;
    }

    @Override
    public void responderMensaje(Mensaje msj) {

    }

    @Override
    public void eliminarRespuesta(Mensaje msj) {

    }

    @Override
    public List<Mensaje> listarMensajesPublicacion(Long idPublicacion) {
        return null;
    }

    @Override
    public List<Mensaje> listarMensajesSinResponder(Long idUsuario) {
        return null;
    }

    @Override
    public List<Mensaje> listarMensajesRespondidos(Long idUsuario) {
        return null;
    }
}
