package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.chat.IRepositorioChat;
import ar.edu.unlam.tallerweb1.model.ChatMensaje;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class RepositorioChat implements IRepositorioChat {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioChat(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<ChatMensaje> listarMensajesDeSolicitud(String codigo) {
        return (List<ChatMensaje>) this.sessionFactory.getCurrentSession().createCriteria(ChatMensaje.class)
                .add(Restrictions.eq("codigo_solicitud", codigo))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public Timestamp enviarMensaje(ChatMensaje mensaje) {

        this.sessionFactory.getCurrentSession().save(mensaje);

        return mensaje.getCreate_at();

    }
}
