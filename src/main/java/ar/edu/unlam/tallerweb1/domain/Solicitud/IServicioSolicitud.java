package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import java.util.List;

public interface IServicioSolicitud {

    void enviarSolicitud(SolicitudDto solicitudDto);

    void cancelarSolicitud(Solicitud solicitud);

    Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario);

    List<Solicitud> listarSolicitudesCerradasPorUsuario(Long idUsuario);

    List<Solicitud> listarSolicitudesEnviadas(Usuario usuario);

    List<Solicitud> listarSolicitudesRecibidas(Long idPublicacion);


    Solicitud getSolicitud(String codigo);

    Solicitud getSolicitudAceptada(Long idPublicacion);

    Solicitud getSolicitudCanceladaSinInformar(Long idPublicacion);

    void aceptarSolicitud(Solicitud solicitud, Usuario usuarioAutenticado);

    void confirmarEntrega(Solicitud solicitud, Usuario usuarioAutenticado);

    void actualizarSolicitud(Solicitud solicitud);

    void cancelarProcesoDeAdopcion(SolicitudDto solicitudDto);

    void confirmarCierre(Solicitud solicitud, Usuario usuarioAutenticado);

    List<Solicitud> listarSolicitudesPendientes(Long idPublicacion);
}
