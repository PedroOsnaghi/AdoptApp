package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.adopcion.IRepositorioAdopcion;
import ar.edu.unlam.tallerweb1.model.Adopcion;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RepositorioAdopcion implements IRepositorioAdopcion {
    private final SessionFactory sessionFactory;

    @Autowired
    public RepositorioAdopcion(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void registrarAdopcion(Adopcion adopcion) {
        this.sessionFactory.getCurrentSession().save(adopcion);
    }

    @Override
    public List<Adopcion> listarAdoptadasPorUsuario(long id) {
        return (List<Adopcion>) this.sessionFactory.getCurrentSession().createCriteria(Adopcion.class)
                .add(Restrictions.eq("usuarioAdoptante.id", id))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
