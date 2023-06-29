package ar.edu.unlam.tallerweb1.domain.adopcion;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ServicioAdopcionTest extends SpringTest {

    @Mock
    private IRepositorioAdopcion repositorioAdopcion;

    @InjectMocks
    private ServicioAdopcion servicioAdopcion;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAlRegistrarAdopcion() {
        Adopcion adopcion = dadoQueSeRegistraUnaAdopcion();

        this.repositorioAdopcion.registrarAdopcion(adopcion);

        seLLamaAlRepositorioParaGuardarLaAdopcion();
    }

    private Adopcion dadoQueSeRegistraUnaAdopcion() {
        Usuario usuario = new Usuario();
        Publicacion publicacion = new Publicacion();

        return new Adopcion(usuario, publicacion);
    }

    private void seLLamaAlRepositorioParaGuardarLaAdopcion() {
        verify(repositorioAdopcion, times(1)).registrarAdopcion(anyObject());
    }
}