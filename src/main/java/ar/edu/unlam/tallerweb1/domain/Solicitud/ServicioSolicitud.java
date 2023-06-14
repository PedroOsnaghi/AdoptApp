package ar.edu.unlam.tallerweb1.domain.Solicitud;

import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioSolicitud implements IServicioSolicitud{

    private final IRepositorioSolicitud repositorioSolicitud;

    @Autowired
    public ServicioSolicitud(IRepositorioSolicitud respsitoriosolicitud){
        this.repositorioSolicitud = respsitoriosolicitud;
    }

    @Override
    public void enviarSolicitud(SolicitudDto solicitudDto) {
        Solicitud solicitud = new Solicitud(solicitudDto);
        this.repositorioSolicitud.guardarSolicitud(solicitud);
    }

    @Override
    public Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario) {
        return this.repositorioSolicitud.getSolicitudDeUsuarioPorPublicacion(publicacion, usuario);
    }
}
