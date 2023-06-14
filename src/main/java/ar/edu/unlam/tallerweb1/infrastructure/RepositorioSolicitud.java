package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Solicitud.IRepositorioSolicitud;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RepositorioSolicitud implements IRepositorioSolicitud {

    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioSolicitud(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarSolicitud(Solicitud solicitud) {
        this.sessionFactory.getCurrentSession().save(solicitud);
    }

    @Override
    public Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario) {
        return (Solicitud) this.sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
                .createAlias("usuario", "user")
                .createAlias("publicacion", "pub")
                .add(Restrictions.and(Restrictions.eq("user.id",usuario.getId()), Restrictions.eq("pub.id",publicacion.getId())) )
                .uniqueResult();
    }
}
