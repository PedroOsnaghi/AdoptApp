package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioPublicacion")
public class RepositorioPublicacion implements IRepositorioPublicacion {

    @Autowired
    public RepositorioPublicacion(){
    }

    @Override
    public Publicacion findPublicacion(Long id) {
        return null;
    }

    @Override
    public void guardarPublicacion(Publicacion publicacion) {

    }

    @Override
    public void modificarPublicacion(Publicacion publicacion) {

    }
}
