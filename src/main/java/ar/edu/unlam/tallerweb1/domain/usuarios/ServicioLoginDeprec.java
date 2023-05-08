package ar.edu.unlam.tallerweb1.domain.usuarios;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLoginDeprec {

	UsuarioDeprec consultarUsuario(String email, String password);
}
