package ar.edu.unlam.tallerweb1.infrastructure;
import ar.edu.unlam.tallerweb1.domain.usuarios.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class RepositorioUsuario implements IRepositorioUsuario {


    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioUsuario(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        this.sessionFactory.getCurrentSession().save(usuario);
        return usuario;
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return (Usuario) this.sessionFactory.getCurrentSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    @Override
    public void actualizarDatos(Usuario usuario) {
        this.sessionFactory.getCurrentSession().update(usuario);
    }

    @Override
    public Usuario getUsuario(Long idUsuario) {
        return this.sessionFactory.getCurrentSession().get(Usuario.class, idUsuario);
    }


}