package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.mascota.IRepositorioMascota;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Mascota> buscarMascotaPorIdDueño(Usuario usuario)
    {
        return (List<Mascota>) this.sessionFactory.getCurrentSession().createCriteria(Mascota.class)
                .add(Restrictions.eq("usuario", usuario)).list();
    }
}
