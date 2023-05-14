package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario implements IServicioUsuario {


    IRepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuario(IRepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email){

        return this.repositorioUsuario.buscarUsuarioPorEmail(email);

    }

    @Override
    public Usuario crearUsuario(String nombre, String email, String password) {

        Usuario usuario = new Usuario(nombre, email, password);

        return repositorioUsuario.guardarUsuario(usuario);

    }
}
