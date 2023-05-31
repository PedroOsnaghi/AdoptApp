package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.delivery.dto.UsuarioDto;
import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioUsuario {

    Usuario buscarUsuarioPorEmail(String email);
    Usuario crearUsuario(String nombre, String email, String passwordHasheada);
    Usuario actualizarDatos(UsuarioDto usuarioDto, Usuario oldUser);
}
