package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface IServicioPublicacion {

    Publicacion findPublicacion(Long id);
    void guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion);
}
