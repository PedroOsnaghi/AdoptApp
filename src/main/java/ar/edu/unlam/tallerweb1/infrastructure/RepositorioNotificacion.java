package ar.edu.unlam.tallerweb1.infrastructure;

        import ar.edu.unlam.tallerweb1.domain.notificacion.IRepositorioNotificacion;
        import ar.edu.unlam.tallerweb1.model.Notificacion;
        import org.hibernate.SessionFactory;
        import org.hibernate.criterion.CriteriaSpecification;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

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


}
