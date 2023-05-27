package ar.edu.unlam.tallerweb1.domain.mascota;

import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.util.List;

public interface IRepositorioMascota {

    void guardar(Mascota mascota);
    List<Mascota> buscarMascotaPorIdDueño(Usuario usuario);

    List<Mascota> listarMascotasaPublicar(Usuario usuario);
}
