package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.util.List;

public interface IRepositorioSolicitud {

    void guardarSolicitud(Solicitud solicitud);

    void cancelarSolicitud(Solicitud solicitud);

    Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario);

    List<Solicitud> listarSolicitudesEnviadas(Long idUsuario);

    List<Solicitud> listarSolicitudesRecibidas(Long idPublicacion);

    List<Solicitud> listarSolicitudesCerradasPorUsuario(Long idUsuario);

    Solicitud getSolicitud(String codigo);

    void aceptarSolicitud(Solicitud solicitud);

    void actualizarSolicitud(Solicitud solicitud);

    Solicitud getSolicitudAceptada(Long idPublicacion);

    Solicitud getSolicitudCanceladaSinInformar(Long idPublicacion);


    List<Solicitud> listarSolicitudesPendientes(Long idPublicacion);
}
