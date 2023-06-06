package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioPublicacion;
import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPublicacion implements IServicioPublicacion{

    private String errorMessage;
    private final IServicioArchivo servicioArchivo;
    private IRepositorioPublicacion repositorioPublicacion;

    @Autowired
    public ServicioPublicacion(IRepositorioPublicacion repositorioPublicacion, IServicioArchivo servicioArchivo){
        this.repositorioPublicacion = repositorioPublicacion;
        this.servicioArchivo = servicioArchivo;
    }

    @Override
    public Publicacion findPublicacion (Long id) {
        return repositorioPublicacion.buscarPublicacionPorId(id);
    }

    @Override
    public Long  guardarPublicacion(PublicacionDto publicacionDto) {

        if (!this.validarDatos(publicacionDto))
            return null;
        return this.publicar(publicacionDto);
    }

    @Override
    public void modificarPublicacion(Publicacion publicacion) {
        //TODO Implementar modificar Publicacion
    }

    @Override
    public void eliminarPublicacion(Long IdPublicacion) {
        //TODO Implementar Eliminar Publicacion
    }

    @Override
    public List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesPorUsuarioId(idUsuario);
    }

    @Override
    public List<PublicacionMensajes> listarPublicacionesMensajesPorUsuarioId(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesConMensajesPorUsuarioId(idUsuario);
    }

    @Override
    public List<Publicacion_favorito> listarFavoritosDeUsuario(Long idUsuario) {
        return this.repositorioPublicacion.ListarFavoritosDeUsuario(idUsuario);
    }

    @Override
    public Publicacion_favorito agregarFavorito(Long idPublicacion, Usuario usuario) {

        Publicacion p = new Publicacion();

        p.setId(idPublicacion);

        Publicacion_favorito pf = new Publicacion_favorito(usuario, p);

        return this.repositorioPublicacion.agregarFavorito(pf);

    }

    @Override
    public void eliminarFavorito(Long idPublicacion, Usuario usuario) {
        Publicacion p = new Publicacion();

        p.setId(idPublicacion);

        Publicacion_favorito pf = new Publicacion_favorito(usuario, p);

        this.repositorioPublicacion.eliminarFavorito(pf);
    }

    @Override
    public List<Publicacion> listarPublicacionesDisponibles() {
        return repositorioPublicacion.listarPublicaciones("disponible");
    }

    @Override
    public String getErrorMessage(){
        return this.errorMessage;
    }


    private boolean validarDatos(PublicacionDto pd) {
        if(pd.getMascota_id() == null){
            this.errorMessage = "Debe seleccionar una mascota";
            return false;
        }
        if(pd.getDireccion() == null){
            this.errorMessage = "Debe especificar una dirección de entrega";
            return false;
        }
        if(pd.getDisponibilidad() == null){
            this.errorMessage = "Debe especificar su disponibilidad horaria";
            return false;
        }

        return true;
    }

    private Long publicar(PublicacionDto publicacionDto) {
        Publicacion pub = this.setearPublicacion(publicacionDto);

        Long pid = repositorioPublicacion.guardarPublicacion(pub);

        if(pid != null){

            this.servicioArchivo.subirImagenesPost(publicacionDto.getFiles(), pub);
            return pid;

        }

        this.errorMessage = "No se pudo guardar la publicacion debido a un error";
        return null;

    }

    private Publicacion setearPublicacion(PublicacionDto publicacionDto) {
        Publicacion p = new Publicacion();
        p.setBio(publicacionDto.getBio());
        p.setMascota(new Mascota(publicacionDto.getMascota_id()));
        p.setDireccion(publicacionDto.getDireccion());
        p.setDisponibilidad(publicacionDto.getDisponibilidad());
        p.setLatitud(publicacionDto.getLatitud());
        p.setLongitud(publicacionDto.getLongitud());
        p.setDireccion(publicacionDto.getDireccion());
        p.setProvincia(publicacionDto.getProvincia());
        p.setCiudad(publicacionDto.getCiudad());

        p.setEstado(EstadoPublicacion.DISPONIBLE);

        return p;
    }



}
