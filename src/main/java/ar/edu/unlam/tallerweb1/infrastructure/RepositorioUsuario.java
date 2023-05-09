package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Base64;

@Repository
public class RepositorioUsuario {

    //TODO
    public Usuario guardar(Usuario usuario) {
        return usuario;
    }

    //TODO
    public Usuario buscarPorEmail(String email) {
        //TODO BORRAR TODO ESTO
        String password = "1234";
        byte[] jsonByte = password.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        String mockPassword = encoder.encodeToString(jsonByte);

        return new Usuario("usuario mock", email, mockPassword);
    }

    ;
    //void modificar(Usuario usuario){};
}