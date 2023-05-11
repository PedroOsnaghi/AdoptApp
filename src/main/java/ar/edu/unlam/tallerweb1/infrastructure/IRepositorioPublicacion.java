package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;

public interface IRepositorioPublicacion {
    Publicacion findPublicacion(Long id);
    void guardarPublicacion(Publicacion publicacion);
    void modificarPublicacion(Publicacion publicacion);
}
