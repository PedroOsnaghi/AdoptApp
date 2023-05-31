package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.domain.usuarios.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Base64;

@Service
public class ServicioAuth implements IServicioAuth {
    private final IServicioSesion servicioSesion;
    IRepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioAuth(IRepositorioUsuario repositorioUsuario, IServicioSesion servicioSesion) {
        this.repositorioUsuario = repositorioUsuario;
        this.servicioSesion = servicioSesion;
    }

    @Override
    public boolean validarCredenciales(Usuario usuario, String password) {

        if (usuario != null) {
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

    public void setUsuarioAutenticado(Usuario usuario) {
        servicioSesion.setAtributoEnSesion("usuarioAutenticado", usuario);
    }

    public Usuario getUsuarioAutenticado() {
        return (Usuario) servicioSesion.getAtributoDeSesion("usuarioAutenticado");
    }

    public boolean usuarioLoggeado() {
        return servicioSesion.getAtributoDeSesion("usuarioAutenticado") != null;
    }

    public boolean usuarioEsRol(String rol) {
    	Usuario usuario = getUsuarioAutenticado();
    	return usuario.getRol().equals(rol);
    }


}
