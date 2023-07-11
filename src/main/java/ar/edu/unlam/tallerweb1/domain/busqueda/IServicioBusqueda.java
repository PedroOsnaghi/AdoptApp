package ar.edu.unlam.tallerweb1.domain.busqueda;

import ar.edu.unlam.tallerweb1.model.ResultadoBusqueda;

import java.util.List;

public interface IServicioBusqueda {

    List<ResultadoBusqueda> buscar(String textoBusqueda);

}
