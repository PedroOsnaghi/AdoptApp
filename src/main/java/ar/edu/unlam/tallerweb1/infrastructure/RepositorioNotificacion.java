package ar.edu.unlam.tallerweb1.infrastructure;

        import ar.edu.unlam.tallerweb1.domain.notificacion.IRepositorioNotificacion;
        import ar.edu.unlam.tallerweb1.model.Notificacion;
        import ar.edu.unlam.tallerweb1.model.PublicacionDetallada;
        import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
        import org.hibernate.SessionFactory;
        import org.hibernate.criterion.CriteriaSpecification;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

        import javax.persistence.Entity;
        import javax.persistence.EntityManager;
        import java.util.List;

@Repository
@Transactional
public class RepositorioNotificacion implements IRepositorioNotificacion {

    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioNotificacion(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Long crearNotificacion(Notificacion notificacion) {
        return (Long) this.sessionFactory.getCurrentSession().save(notificacion);
    }

    public void eliminarNotificacion(Notificacion notificacion) {

        this.sessionFactory.getCurrentSession().delete(notificacion);

    }

    public List<Notificacion> listarNotificaciones(Long idUsuario) {
        return (List<Notificacion>) this.sessionFactory.getCurrentSession()
                .createCriteria(Notificacion.class)
                .createAlias("usuario", "u")
                .add(Restrictions.eq("u.id",idUsuario))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public Notificacion getNotificacion(Long idNotificacion) {
        return this.sessionFactory.getCurrentSession().get(Notificacion.class, idNotificacion);
    }

    @Override
    public void marcarLeidas(Long id) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("UPDATE FROM Notificacion n SET n.leido = :value WHERE n.usuario.id = :idu")
                .setParameter("value", true)
                .setParameter("idu", id)
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Long getNewNotifications(Long idUsuario) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        Long news = entityManager.createQuery("SELECT new java.lang.Long(COUNT(n.id))  FROM Notificacion n WHERE n.usuario.id = :user AND n.leido = :value group BY n.id", Long.class)
                .setParameter("user", idUsuario)
                .setParameter("value", false)
                .getResultStream().count();

        return  news;
    }


}
