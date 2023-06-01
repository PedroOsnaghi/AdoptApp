package ar.edu.unlam.tallerweb1.domain.usuario;

import ar.edu.unlam.tallerweb1.delivery.dto.UsuarioDto;
import ar.edu.unlam.tallerweb1.domain.archivos.ServicioArchivo;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioUsuarioTest {

    private ServicioArchivo servicioArchivo;

    private RepositorioUsuario repositorioUsuario;

    private ServicioUsuario servicioUsuario;

    @Before
    public void init(){
        this.servicioArchivo = mock(ServicioArchivo.class);
        this.repositorioUsuario = mock(RepositorioUsuario.class);

        this.servicioUsuario = new ServicioUsuario(this.repositorioUsuario, this.servicioArchivo);
    }

    @Test
    public void cuandoBuscoUnUsuarioConUnEmailValidoPuedoAccederASuNombre(){
        String email = dadoQueExisteUnCorreoValido();
        Usuario usuarioObtenido = alBuscarPorEmail(email);
        puedoAccederAsuNombre(usuarioObtenido);
    }

    @Test
    public void cuandoCreoUnNuevoUsuarioPuedoObtenerSuId(){
        Usuario usuario = dadoQueExisteUnUsuarioACrear();
        Usuario usuarioCreado = alCrearUnNuevoUsuario(usuario);
        podemosAccederASuID(usuarioCreado);
    }

    @Test
    public void alActualizarDatosDelUsuarioDebemosObtenerUnUsuarioConLosNuevosDatos(){
        Usuario usuario = dadoQueExisteUnUsuario();
        Usuario usuarioModificado = alModificarSusDatos(usuario);
        podemosAccederAsuNuevoNombre(usuarioModificado);
    }

    private void podemosAccederAsuNuevoNombre(Usuario usuarioModificado) {
        assertThat(usuarioModificado.getNombre()).isEqualTo("test_modificado");
    }

    private Usuario alModificarSusDatos(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre("test_modificado");

        return this.servicioUsuario.actualizarDatos(usuarioDto , usuario);
    }

    private Usuario dadoQueExisteUnUsuario() {
        Usuario user = new Usuario("test", "test@test","1234");
        user.setId(10L);

        return user;
    }

    private void podemosAccederASuID(Usuario usuarioCreado) {
        assertThat(usuarioCreado.getId()).isEqualTo(10L);
    }

    private Usuario alCrearUnNuevoUsuario(Usuario user) {

        user.setId(10L);

        when(this.repositorioUsuario.guardarUsuario(anyObject())).thenReturn(user);
        return this.servicioUsuario.crearUsuario(user.getNombre(), user.getEmail(), user.getPassword());
    }

    private Usuario dadoQueExisteUnUsuarioACrear() {
        return new Usuario("test", "test@test","1234");

    }

    private void puedoAccederAsuNombre(Usuario usuarioObtenido) {
        assertThat(usuarioObtenido.getNombre()).isEqualTo("Aldana");
    }

    private Usuario alBuscarPorEmail(String email) {
       Usuario usuario = new Usuario("Aldana", "user@test","1234");

       when(this.repositorioUsuario.buscarUsuarioPorEmail(email)).thenReturn(usuario);
       return this.servicioUsuario.buscarUsuarioPorEmail(email);
    }

    private String dadoQueExisteUnCorreoValido() {
        return "user@test";
    }


}
