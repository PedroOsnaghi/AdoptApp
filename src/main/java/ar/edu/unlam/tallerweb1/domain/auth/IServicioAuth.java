package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioAuth {
    boolean validarCredenciales(Usuario usuario, String password);

    void setUsuarioAutenticado(Usuario usuario);
    Usuario getUsuarioAutenticado();

    String encriptarPassword(String password);

    boolean usuarioEsRol(String rol);

    boolean usuarioLoggeado();

}
