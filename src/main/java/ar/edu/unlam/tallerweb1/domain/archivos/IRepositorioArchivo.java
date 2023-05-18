package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.model.Imagen;

public interface IRepositorioArchivo {

    Long registrarImagen(Imagen img);

    Long eliminarImagen(String nombreImagen);
}
