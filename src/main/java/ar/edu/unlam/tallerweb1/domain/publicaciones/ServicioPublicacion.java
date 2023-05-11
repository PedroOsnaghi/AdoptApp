package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioPublicacion")
@Transactional
public class ServicioPublicacion implements IServicioPublicacion{

    private RepositorioPublicacion repositorioPublicacion;

    @Autowired
    public ServicioPublicacion(RepositorioPublicacion repositorioPublicacion){
        this.repositorioPublicacion = repositorioPublicacion;
    }

    @Override
    public Publicacion findPublicacion (Long id) {
        return repositorioPublicacion.buscarPublicacionPorId(id);
    }

    @Override
    public void guardarPublicacion(Publicacion publicacion) {

    }

    @Override
    public void modificarPublicacion(Publicacion publicacion) {

    }

    @Override
    public void eliminarPublicacion(Long IdPublicacion) {

    }

    @Override
    public List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario) {
        return repositorioPublicacion.listarPublicacionesPorUsuarioId(idUsuario);
    }

    @Override
    public List<Publicacion> listarPublicaciones() {
        return repositorioPublicacion.listarPublicaciones();
    }
}
