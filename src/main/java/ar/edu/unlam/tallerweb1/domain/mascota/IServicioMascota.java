package ar.edu.unlam.tallerweb1.domain.mascota;

import ar.edu.unlam.tallerweb1.delivery.MascotaDto;
import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioMascota {

    Long guardar(MascotaDto mascotaDto, Usuario usuario);

    String getErrorMessage();


}
