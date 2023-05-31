package ar.edu.unlam.tallerweb1.domain.archivos;

import ar.edu.unlam.tallerweb1.model.Imagen;

public interface IRepositorioArchivo {

    Long registrarImagen(Imagen img);

    void eliminarImagen(Imagen img);

    Imagen obtenerImagen(String fileName);


}
