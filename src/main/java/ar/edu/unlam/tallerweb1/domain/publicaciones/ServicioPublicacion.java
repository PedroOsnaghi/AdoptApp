package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioPublicacion")
@Transactional
public class ServicioPublicacion implements IServicioPublicacion{

    private final RepositorioPublicacion repositorioPublicacion;

    @Autowired
    public ServicioPublicacion(RepositorioPublicacion repositorioPublicacion){
        this.repositorioPublicacion = repositorioPublicacion;
    }

    @Override
    public Publicacion findPublicacion (Long id) {
        return repositorioPublicacion.findPublicacion(id);
    }

    @Override
    public void guardarPublicacion(Publicacion publicacion) {

    }

    @Override
    public void modificarPublicacion(Publicacion publicacion) {

    }
}
