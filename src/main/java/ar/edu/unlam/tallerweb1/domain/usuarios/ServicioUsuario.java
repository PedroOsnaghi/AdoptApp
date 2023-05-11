package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario {


    @Autowired
    RepositorioUsuario repositorioUsuario;

    public Usuario crearUsuario(String nombre, String email, String password) {
        Usuario usuario = new Usuario(nombre, email, password);
        Usuario usuarioGuardado = repositorioUsuario.guardar(usuario);

        return usuarioGuardado;
    }
}
