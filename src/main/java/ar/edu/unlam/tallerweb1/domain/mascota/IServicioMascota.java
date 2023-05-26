package ar.edu.unlam.tallerweb1.domain.mascota;

import ar.edu.unlam.tallerweb1.Genero;
import ar.edu.unlam.tallerweb1.Personalidad;
import ar.edu.unlam.tallerweb1.Tipo;
import ar.edu.unlam.tallerweb1.delivery.MascotaDto;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface IServicioMascota {

    Long guardar(MascotaDto mascotaDto, Usuario usuario);

    List<Mascota> listarMascotasAPublicar(Usuario usuario);

    String getErrorMessage();
}
