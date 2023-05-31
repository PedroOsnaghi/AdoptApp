package ar.edu.unlam.tallerweb1.domain.Mensajes;

import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class ServicioMensajes implements IServicioMensajes{


    private final IRepositorioMensajes repositorioMensajes;

    @Autowired
    public ServicioMensajes(IRepositorioMensajes repositorioMensajes){
        this.repositorioMensajes = repositorioMensajes;
    }

    @Override
    public Long enviarMensaje(MensajeDto msjDto) {

        Mensaje msj = new Mensaje(msjDto.getPublicacion(), msjDto.getEmisor(), msjDto.getPregunta());

        this.repositorioMensajes.guardarMensaje(msj);

        return msj.getId();

    }

    @Override
    public void responderMensaje(MensajeDto msjDto) {
        Mensaje msj = this.repositorioMensajes.obtenerMensaje(msjDto.getId());

        msj.setRespuesta(msjDto.getRespuesta());
        msj.setFechaRespuesta(Timestamp.from(Instant.now()));

        this.repositorioMensajes.actualizarMensaje(msj);
    }

    @Override
    public void eliminarRespuesta(Long idMensaje) {
        Mensaje msj = this.repositorioMensajes.obtenerMensaje(idMensaje);

        msj.setRespuesta(null);
        msj.setFechaRespuesta(null);

        this.repositorioMensajes.actualizarMensaje(msj);
    }

    @Override
    public List<Mensaje> listarMensajesPublicacion(Long idPublicacion) {
        return this.repositorioMensajes.listarMensajesPublicacion(idPublicacion);
    }

    @Override
    public List<Mensaje> listarMensajesSinResponder(Long idPublicacion) {

        return idPublicacion == null ? null : this.repositorioMensajes.listarMensajesSinResponder(idPublicacion);
    }

    @Override
    public List<Mensaje> listarMensajesRespondidos(Long idPublicacion) {

        return idPublicacion == null ? null : this.repositorioMensajes.listarMensajesRespondidos(idPublicacion);
    }
}
