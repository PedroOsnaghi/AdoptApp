package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioSolicitud {

    void enviarSolicitud(SolicitudDto solicitudDto);

    Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario);
}
