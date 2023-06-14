package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IRepositorioSolicitud {

    void guardarSolicitud(Solicitud solicitud);

    Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario);
}
