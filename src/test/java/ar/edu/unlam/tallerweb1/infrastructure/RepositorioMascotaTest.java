package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Test
    @Transactional
    @Rollback
    public void alGuardar3MascotasCon2UsuariosDiferentesSoloMeDevuelveLasDelUsuarioBuscado(){
        Usuario user = dadoQueUserTiene2Mascotas();
        List<Mascota> mascotasDeUser = alListarLasMascotas(user);
        podemosObtenerSoloLasMascotasdeUser(mascotasDeUser);
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

    private Usuario dadoQueUserTiene2Mascotas() {
        Usuario user = this.repositorioUsuario.guardarUsuario(new Usuario("test", "test@test","1234"));
        Usuario user2 = this.repositorioUsuario.guardarUsuario(new Usuario("test2", "test2@test2","1234"));
        Mascota m = new Mascota();
        m.setNombre("Lulu");
        m.setUsuario(user);

        Mascota m2 = new Mascota();
        m2.setNombre("Lulu2");
        m2.setUsuario(user);

        Mascota m3 = new Mascota();
        m3.setNombre("Lulu3");
        m3.setUsuario(user2);
        this.repositorioMascota.guardar(m);
        this.repositorioMascota.guardar(m2);
        this.repositorioMascota.guardar(m3);
        return user;
    }

    private List<Mascota> alListarLasMascotas(Usuario user) {
        return this.repositorioMascota.listarMascotaPorUsuario(user);
    }

    private void podemosObtenerSoloLasMascotasdeUser(List<Mascota> mascotasSinPublicar) {
        assertThat(mascotasSinPublicar).hasSize(2);
    }
/*
    @Test
    @Transactional
    @Rollback
    public void alGuardar3MascotasMeDevuelveUnaListaDeLasQueNoEstanPublicadas(){
         Usuario user = dadoQueUnUsuarioTiene3MascotasGuardadasSinPublicar();
        List<Mascota> mascotasSinPublicar = alListarlas(user);
        podemosObtenerUnaListaDeLasMismas(mascotasSinPublicar);
    }

    private Usuario dadoQueUnUsuarioTiene3MascotasGuardadasSinPublicar() {
        Usuario user = this.repositorioUsuario.guardarUsuario(new Usuario("test", "test@test","1234"));

        Mascota m = new Mascota();
        m.setNombre("Lulu");
        m.setUsuario(user);

        Mascota m2 = new Mascota();
        m2.setNombre("Lulu2");
        m2.setUsuario(user);

        Mascota m3 = new Mascota();
        m3.setNombre("Lulu3");
        m3.setUsuario(user);
        this.repositorioMascota.guardar(m);
        this.repositorioMascota.guardar(m2);
        this.repositorioMascota.guardar(m3);
        return user;
    }

    private List<Mascota> alListarlas(Usuario user) {
        return this.repositorioMascota.listarMascotasaPublicar(user);


    }

    private void podemosObtenerUnaListaDeLasMismas(List<Mascota> mascotasSinPublicar) {
        assertThat(mascotasSinPublicar).hasSize(3);
    }
*/




}
