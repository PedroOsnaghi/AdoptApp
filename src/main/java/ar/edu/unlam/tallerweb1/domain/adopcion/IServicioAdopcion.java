package ar.edu.unlam.tallerweb1.domain.adopcion;

import ar.edu.unlam.tallerweb1.model.Adopcion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;

import java.util.List;

public interface IServicioAdopcion {
    void registrarAdopcion(Usuario usuarioAdoptante, Publicacion publicacion);

    List<Adopcion> listarAdoptadasPorUsuario(Usuario usuarioAutenticado);

    Long getAdoptadosPorUsuario(Long idUsuario);
}
