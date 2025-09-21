package ar.edu.unlam.tallerweb1.domain.Calificacion;

import ar.edu.unlam.tallerweb1.delivery.dto.CalificacionDto;
import ar.edu.unlam.tallerweb1.domain.exceptions.DataValidationException;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioCalificacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioCalificacionTest {

    private RepositorioCalificacion repositorioCalificacion;

    private ServicioCalificacion servicioCalificacion;

    @Before
    public void init(){
        this.repositorioCalificacion = mock(RepositorioCalificacion.class);
        this.servicioCalificacion = new ServicioCalificacion(this.repositorioCalificacion);
    }

    @Test
    public void AlIngresarTodosLosDatosDeUnaCalificacionComoAdoptanteRetornaElIdGenerado(){
        CalificacionDto cDto = dadoQueTengoUnaCalificacionCompleta();
        Long id = AlCalificarAdoptante(cDto);
        obtengoSuID(id);
    }

    @Test
    public void AlIngresarTodosLosDatosDeUnaCalificacionComoPublicadorRetornaElIdGenerado(){
        CalificacionDto cDto = dadoQueTengoUnaCalificacionCompleta();
        Long id = AlCalificarPublicador(cDto);
        obtengoSuID(id);
    }

    @Test(expected = DataValidationException.class)
    public void AlIngresarDatosIncompletosDeUnaCalificacionLanzaExcepcionDeValidacionDeDatos(){
        CalificacionDto cDto = dadoQueTengoUnaCalificacionIncompleta();
        Long id = AlCalificarAdoptante(cDto);
        obtengoSuID(id);
    }


    private CalificacionDto dadoQueTengoUnaCalificacionIncompleta() {
        CalificacionDto cDto = new CalificacionDto();
        //cDto.setUsuarioCalificado(new Usuario("juan", null, null));
        cDto.setCalificacion(3D);
        cDto.setCommentario("comentario test");
        return cDto;
    }

    private Long AlCalificarPublicador(CalificacionDto cDto) {
        when(this.repositorioCalificacion.guardarCalificacion(anyObject())).thenReturn(1L);

        return this.servicioCalificacion.calificarPublicador(cDto);
    }

    private void obtengoSuID(Long id) {
        assertThat(id).isEqualTo(1L);
    }

    private Long AlCalificarAdoptante(CalificacionDto cDto) {
        when(this.repositorioCalificacion.guardarCalificacion(anyObject())).thenReturn(1L);

        return this.servicioCalificacion.calificarAdoptante(cDto);

    }

    private CalificacionDto dadoQueTengoUnaCalificacionCompleta() {
        CalificacionDto cDto = new CalificacionDto();
        cDto.setUsuarioCalificado(new Usuario("juan", null, null));
        cDto.setCalificacion(3D);
        cDto.setCommentario("comentario test");

        return cDto;
    }


}
