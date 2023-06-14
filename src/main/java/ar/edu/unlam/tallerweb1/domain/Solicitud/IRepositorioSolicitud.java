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

    List<Solicitud> listarSolicitudesRecibidas(Long idUsuario);
}
