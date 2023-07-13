package ar.edu.unlam.tallerweb1.infrastructure;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IRepositorioMensajes;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
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
    public Mensaje obtenerMensaje(Long id){
        return this.sessionFactory.getCurrentSession().get(Mensaje.class, id);
    }
    @Override
    public Long guardarMensaje(Mensaje msj) {
        return  (Long) this.sessionFactory.getCurrentSession().save(msj);
    }

    @Override
    public Mensaje actualizarMensaje(Mensaje msj) {
        this.sessionFactory.getCurrentSession().update(msj);
        return msj;
    }

    @Override
    public List<Mensaje> listarMensajesPublicacion(Long idPublicacion) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<Mensaje> mensajes = entityManager.createQuery("select m from Mensaje m where  m.publicacion.id = :idp order by m.id desc ", Mensaje.class)
                .setParameter("idp",idPublicacion)
                .getResultList();

        return mensajes;
    }

    @Override
    public List<Mensaje> listarMensajesSinResponder(Long idPublicacion) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<Mensaje> mensajes = entityManager.createQuery("select m from Mensaje m where m.respuesta = null and  m.publicacion.id = :idp order by m.id desc ", Mensaje.class)
                .setParameter("idp",idPublicacion)
                .getResultList();

        return mensajes;
    }

    @Override
    public List<Mensaje> listarMensajesRespondidos(Long idPublicacion) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<Mensaje> mensajes = entityManager.createQuery("select m from Mensaje m where m.respuesta != null and m.publicacion.id = :idp order by m.id desc ", Mensaje.class)
                .setParameter("idp",idPublicacion)
                .getResultList();

        return mensajes;
    }

    @Override
    public Mensaje getMensaje(Long id) {
        return this.sessionFactory.getCurrentSession().get(Mensaje.class, id);
    }
}
