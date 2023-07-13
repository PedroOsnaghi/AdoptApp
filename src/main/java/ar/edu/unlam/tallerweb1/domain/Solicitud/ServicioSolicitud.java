package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.domain.adopcion.IServicioAdopcion;
import ar.edu.unlam.tallerweb1.domain.exceptions.SolicitudException;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ServicioSolicitud implements IServicioSolicitud{

    private final IRepositorioSolicitud repositorioSolicitud;
    private final IServicioPublicacion servcioPublicacion;

    private final IServicioAdopcion servicioAdopcion;

    @Autowired
    public ServicioSolicitud(IServicioPublicacion servicioPublicacion, IRepositorioSolicitud respsitoriosolicitud, IServicioAdopcion servicioAdopcion){
        this.repositorioSolicitud = respsitoriosolicitud;
        this.servcioPublicacion = servicioPublicacion;
        this.servicioAdopcion = servicioAdopcion;
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
    public List<Solicitud> listarSolicitudesCerradasPorUsuario(Long idUsuario) {
        return this.repositorioSolicitud.listarSolicitudesCerradasPorUsuario(idUsuario);
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
    public Solicitud getSolicitudAceptada(Long idPublicacion) {
        return this.repositorioSolicitud.getSolicitudAceptada(idPublicacion);
    }

    @Override
    public Solicitud getSolicitudCanceladaSinInformar(Long idPublicacion) {
        return this.repositorioSolicitud.getSolicitudCanceladaSinInformar(idPublicacion);
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

    @Override
    public void confirmarEntrega(Solicitud solicitud, Usuario usuarioAutenticado) {
        if(solicitud.getPublicacion().getMascota().getUsuario().getId() != usuarioAutenticado.getId())
            throw new SolicitudException("Operación no permitida.");

        //cerramos publicacion publicacion
        this.servcioPublicacion.cerrar(solicitud.getPublicacion());

        //generamos la adopcion
        this.servicioAdopcion.registrarAdopcion(solicitud.getUsuario(), solicitud.getPublicacion());
    }

    @Override
    public void confirmarCierre(Solicitud solicitud, Usuario usuarioAutenticado) {
        if(solicitud.getPublicacion().getMascota().getUsuario().getId() != usuarioAutenticado.getId())
            throw new SolicitudException("Operación no permitida.");

        solicitud.setEstado(EstadoSolicitud.CERRADA);
        this.repositorioSolicitud.actualizarSolicitud(solicitud);

        //reanudamos publicacion
        this.servcioPublicacion.reanudar(solicitud.getPublicacion());


    }

    @Override
    public List<Solicitud> listarSolicitudesPendientes(Long idPublicacion) {
        return this.repositorioSolicitud.listarSolicitudesPendientes(idPublicacion);
    }

    @Override
    public void actualizarSolicitud(Solicitud solicitud) {
        this.repositorioSolicitud.actualizarSolicitud(solicitud);
    }

    @Override
    public void cancelarProcesoDeAdopcion(SolicitudDto solicitudDto) {

        Solicitud solicitud = this.repositorioSolicitud.getSolicitud(solicitudDto.getCodigo());
        solicitud.setEstado(EstadoSolicitud.CANCELADA);
        solicitud.setMotivo_cancelacion(solicitudDto.getMotivo_cancelacion());

        this.repositorioSolicitud.actualizarSolicitud(solicitud);

    }
}
