package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.publicaciones.IRepositorioPublicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public class RepositorioPublicacion implements IRepositorioPublicacion {
    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioPublicacion(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Publicacion buscarPublicacionPorId(Long id) {
        return (Publicacion) this.sessionFactory.getCurrentSession().find(Publicacion.class, id);
    }

    @Override
    public void guardarPublicacion(Publicacion publicacion) {
         this.sessionFactory.getCurrentSession().save(publicacion);
    }

    @Override
    public void modificarPublicacion(Publicacion publicacion) {
    }

    @Override
    public void eliminarPublicacion(Long IdPublicacion) {

    }

    @Override
    public List<Publicacion> listarPublicaciones() {
        return null;
    }

    @Override
    public List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario) {
        return (List<Publicacion>) this.sessionFactory.getCurrentSession()
                .createCriteria(Publicacion.class)
                .createAlias("mascota", "m")
                .add(Restrictions.eq("m.usuario.id", idUsuario))
                .addOrder(Order.desc("id"))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
