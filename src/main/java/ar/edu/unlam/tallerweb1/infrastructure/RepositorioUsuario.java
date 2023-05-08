package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuario {

    //TODO
    public Usuario guardar(Usuario usuario) {
        return usuario;
    }

    ;

    //TODO
    public Usuario buscarPorEmail(String email) {
        return new Usuario(email, "1234");
    }

    ;
    //void modificar(Usuario usuario){};
}