package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.mascota.IRepositorioMascota;
import ar.edu.unlam.tallerweb1.model.Mascota;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RepositorioMascota implements IRepositorioMascota {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioMascota(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Mascota mascota){
        this.sessionFactory.getCurrentSession().save(mascota);
    }
}
