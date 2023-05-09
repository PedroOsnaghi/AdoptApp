package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Base64;

@Service
public class ServicioAuth {

    @Autowired
    private HttpSession session;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    // TODO: llamar a repositorio de usuarios y usar validarPasswordHasheada
    public boolean validarCredenciales(String email, String password) {

        Usuario usuario = repositorioUsuario.buscarPorEmail(email);
        String passwordHasheada = encriptarPassword(password);

        boolean passwordCorrecta = validarPasswordHasheada(password, usuario.getPassword());

        return passwordCorrecta;
    }

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

    public void eliminarSesion(HttpSession session) {
        session.invalidate();
    }

    public void setUsuarioAutenticado(Usuario usuario, HttpSession session) {
        session.setAttribute("usuarioAutenticado", usuario);
    }

    public Usuario getUsuarioAutenticado(HttpSession session) {
        return (Usuario) session.getAttribute("usuarioAutenticado");
    }

    public void setTiempoSesion(HttpSession session, int tiempo) {
        session.setMaxInactiveInterval(tiempo);
    }

    public boolean validarSesion(HttpSession session) {
        return session.getAttribute("usuarioAutenticado") != null;
    }

    public void guardarAtributoEnSesion(String clave, Object valor, HttpSession session) {
        session.setAttribute(clave, valor);
    }


}
