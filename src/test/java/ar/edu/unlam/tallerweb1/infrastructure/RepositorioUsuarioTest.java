package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.usuarios.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


public class RepositorioUsuarioTest extends SpringTest {

    @Autowired
    private IRepositorioUsuario repositorioUsuario;



    @Test
    @Transactional
    @Rollback
    public void alCrearUnNuevoUsuarioPodemosObtenerSuId(){
        Usuario usuario = new Usuario("test", "test@test", "1234");
        Usuario usuarioNuevo = this.repositorioUsuario.guardarUsuario(usuario);
        assertThat(usuarioNuevo.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void alBuscarUnUsuarioPorEmailExistentePudeoObtenerSuId(){
        Usuario usuarioRegistrado =  dadoQueExisteUnUsuarioRegistrado();
        Usuario usuarioEncontrado = alBuscarPorSuEmail(usuarioRegistrado.getEmail());
        assertThat(usuarioEncontrado.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void alActualizarDatosDeUnUsuarioExistentePodemosVerSusNuevosDatos(){
        Usuario usuarioExistente = dadoQueExisteUnUsuarioRegistrado();
        Usuario usuarioModificado = alModificarSuNombre(usuarioExistente, "nuevo_nombre");
        assertThat(usuarioModificado.getNombre()).isEqualTo("nuevo_nombre");
    }

    private Usuario alModificarSuNombre(Usuario usuarioExistente, String nuevoNombre) {
        usuarioExistente.setNombre(nuevoNombre);
        this.repositorioUsuario.actualizarDatos(usuarioExistente);

        return usuarioExistente;
    }

    private Usuario alBuscarPorSuEmail(String email) {
        return this.repositorioUsuario.buscarUsuarioPorEmail(email);
    }

    private Usuario dadoQueExisteUnUsuarioRegistrado() {
        Usuario usuario = new Usuario("test", "test@test", "1234");
        Usuario usuarioNuevo = this.repositorioUsuario.guardarUsuario(usuario);
        return usuarioNuevo;
    }


}
