package ar.edu.unlam.tallerweb1.domain.usuarios;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuarioDeprec {
	
	UsuarioDeprec buscarUsuario(String email, String password);
	void guardar(UsuarioDeprec usuarioDeprec);
    UsuarioDeprec buscar(String email);
	void modificar(UsuarioDeprec usuarioDeprec);
}
