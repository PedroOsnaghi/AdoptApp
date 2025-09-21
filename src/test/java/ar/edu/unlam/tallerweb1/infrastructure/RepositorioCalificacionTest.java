package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Calificacion.IRepositorioCalificacion;
import ar.edu.unlam.tallerweb1.model.Calificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.RolCalificacion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioCalificacionTest extends SpringTest {

    @Autowired
    private IRepositorioCalificacion repositorioCalificacion;

    @Test
    @Transactional
    @Rollback
    public void AlGuardarCalificacionPuedoObtenerSuId(){
        Calificacion calificacion = dadoQueEsxisteUnaCalificacionDeUsuario();
        Long id = alGuardarla(calificacion);
        obtenemosUnId(id);
    }

    private void obtenemosUnId(Long id) {
        assertThat(id).isNotNull();
    }

    private Long alGuardarla(Calificacion calificacion) {
        return this.repositorioCalificacion.guardarCalificacion(calificacion);
    }

    private Calificacion dadoQueEsxisteUnaCalificacionDeUsuario() {
        Usuario user = new Usuario("juan", "juan@test", "1234");
        this.session().save(user);

        Calificacion cal = new Calificacion(user, RolCalificacion.PUBLICADOR,3D,"un comentario");

        return cal;

    }

}
