package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.usuarios.UsuarioDeprec;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest{

    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void crearUsuario(){
        UsuarioDeprec usuarioDeprec = new UsuarioDeprec();
        usuarioDeprec.setEmail("seba@gmail.com");
        usuarioDeprec.setPassword("1234");
        usuarioDeprec.setRol("ADMIN");
        session().save(usuarioDeprec);
        assertThat(usuarioDeprec.getId()).isNotNull();
    }
}
