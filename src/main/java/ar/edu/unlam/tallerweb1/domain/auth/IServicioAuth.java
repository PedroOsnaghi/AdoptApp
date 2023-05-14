package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioAuth {
    boolean validarCredenciales(String email, String password);

    void eliminarSesion();

    void setUsuarioAutenticado(Usuario usuario);

    Usuario getUsuarioAutenticado();

    String encriptarPassword(String password);

    void setTiempoSesion(int tiempo);
}
