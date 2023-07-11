package ar.edu.unlam.tallerweb1.domain.busqueda;

import ar.edu.unlam.tallerweb1.domain.publicaciones.IRepositorioPublicacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.IRepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.IServicioUsuario;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.ResultadoBusqueda;
import ar.edu.unlam.tallerweb1.model.Usuario;
import ar.edu.unlam.tallerweb1.model.enumerated.TipoBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioBusqueda implements IServicioBusqueda{

    private IRepositorioUsuario repositorioUsuario;

    private IRepositorioPublicacion repositorioPublicacion;

    @Autowired
    public ServicioBusqueda(IRepositorioUsuario repositorioUsuario, IRepositorioPublicacion repositorioPublicacion){
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPublicacion = repositorioPublicacion;
    }


    @Override
    public List<ResultadoBusqueda> buscar(String textoBusqueda) {
        //Buscamos usuarios cuyo nombre incluya textoBusqueda
        List<Usuario> usuarios = this.repositorioUsuario.buscar(textoBusqueda);
        //Buscamos publicaciones de mascotas cuyo nombre contenga a textoBusqueda o el nombre de sus publicantes lo contengan
        List<Publicacion> publicaciones = this.repositorioPublicacion.buscar(textoBusqueda);

        //mapeamos ambas listas en una lista de busqueda
        List<ResultadoBusqueda> resultadoDeBusqueda = new ArrayList<>();

        //recorremos la primera y cargamos sus resultados
        for(Usuario user : usuarios){
            resultadoDeBusqueda.add(new ResultadoBusqueda(user.getImagen(),user.getNombre(),user.getEmail(), TipoBusqueda.USUARIO, user.getId()));
        }
        //recorremos la segunda y cargamos sus resultados
        for(Publicacion pub : publicaciones){
            resultadoDeBusqueda.add(new ResultadoBusqueda(pub.getMascota().getFoto(),pub.getMascota().getNombre(),pub.getMascota().getUsuario().getNombre(), TipoBusqueda.PUBLICACION, pub.getId()));
        }


        return resultadoDeBusqueda;
    }
}
