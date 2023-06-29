package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.adopcion.IRepositorioAdopcion;
import ar.edu.unlam.tallerweb1.model.Adopcion;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
