package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Solicitud.IRepositorioSolicitud;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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
    public void cancelarSolicitud(Solicitud solicitud) {
        this.sessionFactory.getCurrentSession().delete(solicitud);
    }


    @Override
    public Solicitud getSolicitudDeUsuarioPorPublicacion(Publicacion publicacion, Usuario usuario) {
        return (Solicitud) this.sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
                .createAlias("usuario", "user")
                .createAlias("publicacion", "pub")
                .add(Restrictions.and(Restrictions.eq("user.id",usuario.getId()), Restrictions.eq("pub.id",publicacion.getId())) )
                .uniqueResult();
    }

    @Override
    public List<Solicitud> listarSolicitudesEnviadas(Long idUsuario) {
        return (List<Solicitud>) this.sessionFactory.getCurrentSession()
                .createCriteria(Solicitud.class)
                .createAlias("publicacion", "p")
                .add(Restrictions.and(Restrictions.eq("usuario.id", idUsuario),Restrictions.not(Restrictions.eq("p.estado",EstadoPublicacion.CERRADA))))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public List<Solicitud> listarSolicitudesRecibidas(Long idPublicacion) {
        return (List<Solicitud>) this.sessionFactory.getCurrentSession()
                .createCriteria(Solicitud.class)
                .add(Restrictions.eq("publicacion.id", idPublicacion))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public Solicitud getSolicitud(String codigo) {
        return (Solicitud) this.sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
                .add(Restrictions.eq("codigo", codigo))
                .uniqueResult();
    }

    @Override
    public void aceptarSolicitud(Solicitud solicitud) {
        this.sessionFactory.getCurrentSession().update(solicitud);

    }

    @Override
    public void actualizarSolicitud(Solicitud solicitud) {
        this.sessionFactory.getCurrentSession().update(solicitud);
    }

    @Override
    public Solicitud getSolicitudAceptada(Long idPublicacion) {
        return (Solicitud) this.sessionFactory.getCurrentSession().createCriteria(Solicitud.class)
                .add(Restrictions.and(Restrictions.eq("estado", EstadoSolicitud.ACEPTADA), Restrictions.eq("publicacion.id", idPublicacion)))
                .uniqueResult();
    }
}
