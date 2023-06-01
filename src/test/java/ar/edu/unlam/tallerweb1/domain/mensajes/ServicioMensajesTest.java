package ar.edu.unlam.tallerweb1.domain.mensajes;

import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.domain.Mensajes.ServicioMensajes;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioMensajes;
import ar.edu.unlam.tallerweb1.model.Mensaje;
import ar.edu.unlam.tallerweb1.model.Publicacion;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.model.Usuario;
import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioMensajesTest {

    private RepositorioMensajes repositorioMensajes;

    private ServicioMensajes servicioMensajes;


    @Before
    public void init(){
        this.repositorioMensajes = mock(RepositorioMensajes.class);
        this.servicioMensajes = new ServicioMensajes(this.repositorioMensajes);
    }

    @Test
    public void alEnviarUnMensajeDebeDevolverSuId(){
        MensajeDto mensajeDto = dadoQueExisteUnMensajeParaSerEnviado();
        Long id = alEnviarlo(mensajeDto);
        obtenemosSuId(id);
    }

    @Test
    public void alResponderUnMensajeDebemosObtenerElMensajeCompleto(){
        MensajeDto mensajeDto = dadoQueExisteUnMensajeParaSerRespondido();
        Mensaje mensaje = alResponderlo(mensajeDto);
        obtenemosUnObjetoConTodosLosDatos(mensaje);
    }

    @Test
    public void alEliminarUnaRespuestaObtengoElMensajeSinLaRespuesta(){
        Long idMje = dadoQueExisteUnMensajeRespondido();
        Mensaje mensaje = alEliminarRespuesta(idMje);
        obtenemosUnObjetoSinRespuesta(mensaje);
    }

    private void obtenemosUnObjetoSinRespuesta(Mensaje mensaje) {
        assertThat(mensaje.getRespuesta()).isNull();
        assertThat(mensaje.getFechaRespuesta()).isNull();
    }

    private Mensaje alEliminarRespuesta(Long idMje) {

        return this.servicioMensajes.eliminarRespuesta(idMje);
    }

    private Long dadoQueExisteUnMensajeRespondido() {
        Publicacion p = new Publicacion();
        p.setId(10L);

        Mensaje msj = new Mensaje();
        msj.setId(20L);
        msj.setPublicacion(p);
        msj.setEmisor(new Usuario("test","test@test","1234"));
        msj.setFechaRespuesta(Timestamp.from(Instant.now()));
        msj.setPregunta("pasara el Test?");
        msj.setRespuesta("respuesta");

        when(this.repositorioMensajes.obtenerMensaje(any())).thenReturn(msj);
        when(this.repositorioMensajes.actualizarMensaje(anyObject())).thenReturn(msj);

        return msj.getId();
    }

    private void obtenemosUnObjetoConTodosLosDatos(Mensaje mensaje) {
        assertThat(mensaje.getRespuesta()).isNotNull();
        assertThat(mensaje.getFechaRespuesta()).isNotNull();
    }

    private Mensaje alResponderlo(MensajeDto mensajeDto) {
        Mensaje msj = new Mensaje();
        msj.setId(mensajeDto.getId());
        msj.setPublicacion(mensajeDto.getPublicacion());
        msj.setEmisor(mensajeDto.getEmisor());
        msj.setFechaRespuesta(Timestamp.from(Instant.now()));
        msj.setRespuesta("esto es respuesta");

        when(this.repositorioMensajes.obtenerMensaje(any())).thenReturn(msj);

        when(this.repositorioMensajes.actualizarMensaje(anyObject())).thenReturn(msj);

        return this.servicioMensajes.responderMensaje(mensajeDto);
    }

    private void obtenemosSuId(Long id) {
        assertThat(id).isEqualTo(20L);
    }

    private Long alEnviarlo(MensajeDto mensajeDto) {
        when(this.repositorioMensajes.guardarMensaje(anyObject())).thenReturn(20L);
        return this.servicioMensajes.enviarMensaje(mensajeDto);
    }

    private MensajeDto dadoQueExisteUnMensajeParaSerEnviado() {
        Publicacion p = new Publicacion();
        MensajeDto msjDto = new MensajeDto();
        msjDto.setPublicacion(p);
        msjDto.setPregunta("pasara el Test?");
        msjDto.setRespuesta("respuesta");
        return msjDto;
    }

    private MensajeDto dadoQueExisteUnMensajeParaSerRespondido() {
        Publicacion p = new Publicacion();
        p.setId(10L);

        MensajeDto msjDto = new MensajeDto();
        msjDto.setId(20L);
        msjDto.setPublicacion(p);
        msjDto.setEmisor(new Usuario("test","test@test","1234"));
        msjDto.setFechaRespuesta(Timestamp.from(Instant.now()));
        msjDto.setPregunta("pasara el Test?");
        msjDto.setRespuesta("respuesta");
        return msjDto;
    }


}
