package ar.edu.unlam.tallerweb1.domain.adopcion;

import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioAdopcion {
    void registrarAdopcion(Usuario usuarioAdoptante, Publicacion publicacion);
}
