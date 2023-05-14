package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioUsuario {

    Usuario buscarUsuarioPorEmail(String email);
    Usuario crearUsuario(String nombre, String email, String passwordHasheada);

}
