package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.domain.exceptions.SolicitudException;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ServicioSolicitud implements IServicioSolicitud{

    private final IRepositorioSolicitud repositorioSolicitud;
    private final IServicioPublicacion servcioPublicacion;

    @Autowired
    public ServicioSolicitud(IServicioPublicacion servicioPublicacion, IRepositorioSolicitud respsitoriosolicitud){
        this.repositorioSolicitud = respsitoriosolicitud;
        this.servcioPublicacion = servicioPublicacion;
    }

    @Override
    public void enviarSolicitud(SolicitudDto solicitudDto) {
        Solicitud solicitud = new Solicitud(solicitudDto);
        this.repositorioSolicitud.guardarSolicitud(solicitud);
    }

    @Override
    public void cancelarSolicitud(Solicitud solicitud) {
        this.repositorioSolicitud.cancelarSolicitud(solicitud);
    }

    @Override
    public Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario) {
        return this.repositorioSolicitud.getSolicitudDeUsuarioPorPublicacion(publicacion, usuario);
    }

    @Override
    public List<Solicitud> listarSolicitudesEnviadas(Usuario usuario) {
        return this.repositorioSolicitud.listarSolicitudesEnviadas(usuario.getId());
    }

    @Override
    public List<Solicitud> listarSolicitudesRecibidas(Long idPublicacion) {
        return this.repositorioSolicitud.listarSolicitudesRecibidas(idPublicacion);
    }

    @Override
    public Solicitud getSolicitud(String codigo) {
        return this.repositorioSolicitud.getSolicitud(codigo);
    }

    @Override
    public void aceptarSolicitud(Solicitud solicitud, Usuario usuarioAutenticado) {
        if(solicitud.getPublicacion().getMascota().getUsuario().getId() != usuarioAutenticado.getId())
            throw new SolicitudException("Operación no permitida.");

        //aceptamos solicitud
        solicitud.setEstado(EstadoSolicitud.ACEPTADA);
        this.repositorioSolicitud.aceptarSolicitud(solicitud);

        //resrvamos publicacion
        this.servcioPublicacion.reservar(solicitud.getPublicacion());
    }
}
