package ar.edu.unlam.tallerweb1.domain.adopcion;

import ar.edu.unlam.tallerweb1.model.Adopcion;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAdopcion implements IServicioAdopcion {
    private final IRepositorioAdopcion repositorioAdopcion;

    @Autowired
    public ServicioAdopcion(IRepositorioAdopcion repositorioAdopcion){
        this.repositorioAdopcion = repositorioAdopcion;
    }

    @Override
    public void registrarAdopcion(Usuario usuarioAdoptante, Publicacion publicacion) {
        Adopcion adopcion = new Adopcion(usuarioAdoptante, publicacion);
       repositorioAdopcion.registrarAdopcion(adopcion);
    }

    @Override
    public List<Adopcion> listarAdoptadasPorUsuario(Usuario usuarioAutenticado) {
        return this.repositorioAdopcion.listarAdoptadasPorUsuario(usuarioAutenticado.getId());
    }

    @Override
    public Long getAdoptadosPorUsuario(Long idUsuario) {
        return this.repositorioAdopcion.getAdoptadosPorUsuario(idUsuario);
    }
}
