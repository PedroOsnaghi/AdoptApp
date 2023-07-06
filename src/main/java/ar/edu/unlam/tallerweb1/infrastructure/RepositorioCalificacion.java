package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Calificacion.IRepositorioCalificacion;
import ar.edu.unlam.tallerweb1.model.Calificacion;
import ar.edu.unlam.tallerweb1.model.UsuarioConCalificacion;
import ar.edu.unlam.tallerweb1.model.enumerated.RolCalificacion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class RepositorioCalificacion implements IRepositorioCalificacion {

    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioCalificacion(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long guardarCalificacion(Calificacion calificacion) {
        return (Long) this.sessionFactory.getCurrentSession().save(calificacion);
    }

    @Override
    public UsuarioConCalificacion getCalificacionUsuario(Long idUsuario, RolCalificacion rol) {

        EntityManager entityManager = this.sessionFactory.createEntityManager();

        UsuarioConCalificacion calificacion = entityManager.createQuery("SELECT  new ar.edu.unlam.tallerweb1.model.UsuarioConCalificacion(avg(c.calificacion))  FROM Calificacion c where c.usuarioCalificado.id = :user AND c.rol = :rol  GROUP BY c.usuarioCalificado, c.rol", UsuarioConCalificacion.class)
                .setParameter("user", idUsuario)
                .setParameter("rol", rol)
                .getResultStream().findFirst().orElse(null);
        return calificacion;

    }

    @Override
    public List<Calificacion> getComentariosComoAdoptante(Long idUsuario) {
        return (List<Calificacion>) this.sessionFactory.getCurrentSession().createCriteria(Calificacion.class)
                .add(Restrictions.and(Restrictions.eq("usuarioCalificado.id",idUsuario), Restrictions.eq("rol", RolCalificacion.ADOPTANTE)))
                .addOrder(Order.desc("id"))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public List<Calificacion> getComentariosComoPublicador(Long idUsuario) {
        return (List<Calificacion>) this.sessionFactory.getCurrentSession().createCriteria(Calificacion.class)
                .add(Restrictions.and(Restrictions.eq("usuarioCalificado.id",idUsuario), Restrictions.eq("rol", RolCalificacion.PUBLICADOR)))
                .addOrder(Order.desc("id"))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
