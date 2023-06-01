package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


public class RepositorioMascotaTest extends SpringTest {

    @Autowired
    private RepositorioMascota repositorioMascota;

    @Autowired
    private RepositorioUsuario repositorioUsuario;



    @Test
    @Transactional
    @Rollback
    public void alGuardarUnaMascotaPuedoObtenerSuId(){
        Mascota mascota = dadoQueExisteUnaMascotaAGuardar();
        Mascota mascotaGuardada = alGuardarla(mascota);
        podemosObtenerSuId(mascotaGuardada);
    }

    private void podemosObtenerSuId(Mascota mascotaGuardada) {
        assertThat(mascotaGuardada.getId()).isNotNull();
    }

    private Mascota alGuardarla(Mascota mascota) {
        this.repositorioMascota.guardar(mascota);
        return mascota;
    }

    private Mascota dadoQueExisteUnaMascotaAGuardar() {
        Usuario user = this.repositorioUsuario.guardarUsuario(new Usuario("test", "test@test","1234"));

        Mascota m = new Mascota();
        m.setNombre("Lulu");
        m.setUsuario(user);

        return m;
    }


}
