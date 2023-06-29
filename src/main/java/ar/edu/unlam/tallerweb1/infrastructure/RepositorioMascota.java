package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.mascota.IRepositorioMascota;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
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
    public void guardar(Mascota mascota){this.sessionFactory.getCurrentSession().save(mascota);
    }

    @Override
    public List<Mascota> listarMascotasaPublicar(Usuario usuario) {

        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<Mascota> mascota = entityManager.createQuery("select p from Mascota p where p.id not IN ( select pc.mascota.id from Publicacion pc) AND p.usuario = :user order by p.id desc ", Mascota.class)
                .setParameter("user",usuario)
                .getResultList();

        return mascota;
    }

    @Override
    public List<Mascota> listarMascotaPorUsuario(Usuario usuario)
    {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<Mascota> mascota = entityManager.createQuery("select m from Mascota m where m.id not IN ( select a.publicacion.mascota.id from Adopcion a) AND m.usuario = :user order by m.id desc ", Mascota.class)
                .setParameter("user",usuario)
                .getResultList();

        return mascota;
    }
}
