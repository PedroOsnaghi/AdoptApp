package ar.edu.unlam.tallerweb1.infrastructure;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IRepositorioMensajes;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RepositorioMensajes implements IRepositorioMensajes {


    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioMensajes(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long guardarMensaje(Mensaje msj) {
        return null;
    }

    @Override
    public void actualizarMensaje(Mensaje msj) {

    }

    @Override
    public List<Mensaje> listarMensajesPublicacion(Long idPublicacion) {
        return null;
    }

    @Override
    public List<Mensaje> listarMensajesSinResponder(Long idUsuario) {
        return null;
    }

    @Override
    public List<Mensaje> listarMensajesRespondidos(Long idUsuario) {
        return null;
    }
}
