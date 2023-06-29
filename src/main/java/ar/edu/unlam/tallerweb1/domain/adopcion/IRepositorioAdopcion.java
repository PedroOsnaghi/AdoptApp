package ar.edu.unlam.tallerweb1.domain.adopcion;

import ar.edu.unlam.tallerweb1.model.Adopcion;

import java.util.List;

public interface IRepositorioAdopcion {
    void registrarAdopcion(Adopcion adopcion);

    List<Adopcion> listarAdoptadasPorUsuario(long id);
}
