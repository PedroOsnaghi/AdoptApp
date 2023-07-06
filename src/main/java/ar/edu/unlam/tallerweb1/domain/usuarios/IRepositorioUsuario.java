package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IRepositorioUsuario {

    Usuario guardarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorEmail(String email);

    void actualizarDatos(Usuario usuario);

    Usuario getUsuario(Long idUsuario);
}
