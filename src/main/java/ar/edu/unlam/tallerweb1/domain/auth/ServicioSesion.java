package ar.edu.unlam.tallerweb1.domain.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ServicioSesion implements IServicioSesion {
    private final HttpSession session;

    @Autowired
    public ServicioSesion(HttpSession session) {
        this.session = session;
    }

    @Override
    public void eliminarSesion() {
        session.invalidate();
    }

    @Override
    public void setTiempoSesion(int tiempo) {
        session.setMaxInactiveInterval(tiempo);
    }

    public void setAtributoEnSesion(String clave, Object valor) {
        session.setAttribute(clave, valor);
    }

    public Object getAtributoDeSesion(String clave) {
        return session.getAttribute(clave);
    }
}
