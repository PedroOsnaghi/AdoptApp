package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Solicitud.IRepositorioSolicitud;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.hibernate.SessionFactory;
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
                .add(Restrictions.eq("usuario.id", idUsuario))
                .list();
    }

    @Override
    public List<Solicitud> listarSolicitudesRecibidas(Long idUsuario) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        String queryString = "SELECT DISTINCT s.usuario, s.publicacion, s.estado, s.mensaje " +
                "FROM Solicitud s " +
                "WHERE s.publicacion IN " +
                "(   SELECT p.id " +
                "    FROM Publicacion p " +
                "    JOIN p.mascota m " +
                "    WHERE m.usuario = :idusuario " +
                ")";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("idusuario", idUsuario);

        return (List<Solicitud>) query.getResultList();
    }


}
