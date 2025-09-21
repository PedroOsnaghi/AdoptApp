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

    List<Solicitud> listarSolicitudesEnviadas(Usuario usuario);

    List<Solicitud> listarSolicitudesRecibidas(Usuario usuario);
}
