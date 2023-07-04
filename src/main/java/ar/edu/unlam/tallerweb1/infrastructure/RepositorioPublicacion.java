package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.publicaciones.IRepositorioPublicacion;
import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
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
    public Long guardarPublicacion(Publicacion publicacion) {
       return (Long) this.sessionFactory.getCurrentSession().save(publicacion);
    }

    @Override
    public void modificarPublicacion(Publicacion publicacion) {
        this.sessionFactory.getCurrentSession().update(publicacion);
    }

    @Override
    public void eliminarPublicacion(Publicacion publicacion) {
     this.sessionFactory.getCurrentSession().delete(publicacion);
    }

    @Override
    public List<Publicacion> listarPublicaciones(EstadoPublicacion state) {

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
    public List<PublicacionMensajes> listarPublicacionesConMensajesPorUsuarioId(Long idUsuario) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<PublicacionMensajes> publicaciones = entityManager.createQuery("select new ar.edu.unlam.tallerweb1.model.PublicacionMensajes(p, COUNT(m.id)) from Publicacion p left join Mensaje m on m.publicacion = p where  p.mascota.usuario.id = :iduser and p.estado <> :estado group by p.id order by p.id desc ", PublicacionMensajes.class)
                .setParameter("iduser", idUsuario)
                .setParameter("estado", EstadoPublicacion.CERRADA)
                .getResultList();

        return publicaciones;
    }

    @Override
    public List<PublicacionSolicitud> listarPublicacionesDisponiblesParaSolicitudPorUsuarioId(Long idUsuario) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<PublicacionSolicitud> publicaciones = entityManager.createQuery("select new ar.edu.unlam.tallerweb1.model.PublicacionSolicitud(p, COUNT(s.codigo)) from Publicacion p left join Solicitud s on s.publicacion = p where  p.mascota.usuario.id = :iduser and p.estado <> :estado  group by p.id  order by p.id desc ", PublicacionSolicitud.class)
                .setParameter("iduser", idUsuario)
                .setParameter("estado", EstadoPublicacion.CERRADA)
                .getResultList();

        return publicaciones;
    }

    @Override
    public List<PublicacionDetallada> listarPublicacionesDetalladasPorUsuarioId(Long idUsuario){
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        List<PublicacionDetallada> publicacion_detallada = entityManager.createQuery("SELECT new ar.edu.unlam.tallerweb1.model.PublicacionDetallada(p, COUNT(m.id))  FROM Publicacion p LEFT JOIN Mensaje m on m.publicacion.id = p.id WHERE p.mascota.usuario.id = :user AND p.estado <> :estado  group BY p.id", PublicacionDetallada.class)
                .setParameter("user", idUsuario)
                .setParameter("estado", EstadoPublicacion.CERRADA)
                .getResultList();

        return  publicacion_detallada;
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

    @Override
    public List<Solicitud> listarPublicacionesCerradasPorUsuario(Long idUsuario) {
        return (List<Solicitud>) this.sessionFactory.getCurrentSession()
                .createCriteria(Solicitud.class)
                .createAlias("publicacion", "post")
                .createAlias("publicacion.mascota.usuario", "u")
                .add(Restrictions.eq("post.estado",EstadoPublicacion.CERRADA))
                .add(Restrictions.eq("u.id", idUsuario))
                .addOrder(Order.desc("update_at"))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public Long getPublicacionesPorUsuario(Long idUsuario) {
        EntityManager entityManager = this.sessionFactory.createEntityManager();

        Long cantidad = entityManager.createQuery("SELECT new java.lang.Long(COUNT(p.id))  FROM Publicacion p  WHERE p.mascota.usuario.id = :user  group BY p.id", Long.class)
                .setParameter("user", idUsuario)
                .getResultStream().count();

        return  cantidad;
    }


    @Override
    public Publicacion_favorito agregarFavorito(Publicacion_favorito favorito){

        return (Publicacion_favorito) this.sessionFactory.getCurrentSession().save(favorito);

    }

    @Override
    public void eliminarFavorito(Publicacion_favorito favorito) {

        this.sessionFactory.getCurrentSession().remove(favorito);

    }
}
