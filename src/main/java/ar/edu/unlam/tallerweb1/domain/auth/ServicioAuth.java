package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.domain.usuarios.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Base64;

@Service
public class ServicioAuth implements IServicioAuth {


    private  HttpSession session;
    IRepositorioUsuario repositorioUsuario;

    @Autowired
    public  ServicioAuth(IRepositorioUsuario repositorioUsuario, HttpSession session){
       this.repositorioUsuario = repositorioUsuario;
       this.session = session;
   }

    @Override
    public boolean validarCredenciales(String email, String password) {

        Usuario usuario = repositorioUsuario.buscarUsuarioPorEmail(email);

        if(usuario != null){
            boolean passwordCorrecta = validarPasswordHasheada(password, usuario.getPassword());

            return passwordCorrecta;
        }

        return false;


    }

    @Override
    public String encriptarPassword(String password) {
        byte[] jsonByte = password.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        String passwordHasheada = encoder.encodeToString(jsonByte);

        return passwordHasheada;
    }


    public boolean validarPasswordHasheada(String password, String passwordHasheada) {
        String _passwordHasheada = encriptarPassword(password);
        return _passwordHasheada.equals(passwordHasheada);
    }

    public void eliminarSesion() {
        session.invalidate();
    }

    public void setUsuarioAutenticado(Usuario usuario) {
        session.setAttribute("usuarioAutenticado", usuario);
    }

    public Usuario getUsuarioAutenticado() {
        return (Usuario) session.getAttribute("usuarioAutenticado");
    }

    @Override
    public void setTiempoSesion(int tiempo) {
        session.setMaxInactiveInterval(tiempo);
    }

    public boolean usuarioLoggeado() {
        return session.getAttribute("usuarioAutenticado") != null;
    }

    public void guardarAtributoEnSesion(String clave, Object valor) {
        session.setAttribute(clave, valor);
    }

    public Object getAtributoDeSesion(String clave) {
        return session.getAttribute(clave);
    }


}
