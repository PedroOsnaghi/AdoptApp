package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.publicaciones.IRepositorioPublicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Publicacion_favorito;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ConstantException;
import org.springframework.stereotype.Repository;

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
    public List<Publicacion> listarPublicaciones(String state) {

        return (List<Publicacion>) this.sessionFactory.getCurrentSession()
                .createCriteria(Publicacion.class)
                .add(Restrictions.eq("estado", state))
                .addOrder(Order.desc("id"))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
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

    @Override
    public void agregarFavorito(Publicacion_favorito favorito){

            this.sessionFactory.getCurrentSession().save(favorito);


    }

    @Override
    public void eliminarFavorito(Publicacion_favorito favorito) {

        this.sessionFactory.getCurrentSession().remove(favorito);

    }

    @Override
    public List<Publicacion_favorito> ListarFavoritosDeUsuario(Long idUsuario) {
        return (List<Publicacion_favorito>) this.sessionFactory.getCurrentSession()
                .createCriteria(Publicacion_favorito.class)
                .createAlias("usuario", "user")
                .add(Restrictions.eq("user.id",idUsuario))
                .addOrder(Order.desc("id"))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }
}
