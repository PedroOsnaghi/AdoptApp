package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.archivos.IRepositorioArchivo;
import ar.edu.unlam.tallerweb1.model.Imagen;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class RepositorioArchivo implements IRepositorioArchivo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long registrarImagen(Imagen img){
        return (Long) this.sessionFactory.getCurrentSession().save(img);
    }

    @Override
    public void eliminarImagen(Imagen img){
          this.sessionFactory.getCurrentSession().delete(img);
    }

    @Override
    public Imagen obtenerImagen(Long idImagen){
        return (Imagen) this.sessionFactory.getCurrentSession().createCriteria(Imagen.class)
                .add(Restrictions.eq("id", idImagen)).uniqueResult();
    }


}
