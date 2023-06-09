package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.domain.exceptions.*;
import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.ValidationException;
import java.util.List;

@Service
public class ServicioPublicacion implements IServicioPublicacion{

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
    public void eliminarPublicacion(Long idPublicacion, Usuario userAuth) {
        Publicacion p = this.repositorioPublicacion.buscarPublicacionPorId(idPublicacion);

        if(this.validarUsuario(p, userAuth))
            this.repositorioPublicacion.eliminarPublicacion(p);
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
    public void pausarPublicacion(Long pid, Usuario userAuth) {
        Publicacion p = this.repositorioPublicacion.buscarPublicacionPorId(pid);
        //seteamos nuevo estado
        p.setEstado(EstadoPublicacion.PAUSADA);

        if(this.validarUsuario(p, userAuth))
            this.repositorioPublicacion.modificarPublicacion(p);
    }

    @Override
    public void reanudarPublicacion(Long pid, Usuario userAuth) {
        Publicacion p = this.repositorioPublicacion.buscarPublicacionPorId(pid);
        //seteamos nuevo estado
        p.setEstado(EstadoPublicacion.DISPONIBLE);
        if(this.validarUsuario(p, userAuth))
            this.repositorioPublicacion.modificarPublicacion(p);
    }

    private boolean validarUsuario(Publicacion p, Usuario userAuth) {
        if(p.getMascota().getUsuario().getId() != userAuth.getId()) throw new PostChangeException("Accion no permitida", "invalid_operation");
        return true;
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
        return repositorioPublicacion.listarPublicaciones(EstadoPublicacion.DISPONIBLE);
    }



    private boolean validarDatos(PublicacionDto pd) {
        if(pd.getMascota_id() == null) throw new DataValidationException("Debe seleccionar una mascota");

        if(pd.getDireccion().isEmpty()) throw new DataValidationException("Debe especificar una dirección de entrega");

        if(pd.getDisponibilidad().isEmpty()) throw new DataValidationException("Debe especificar su disponibilidad horaria");

        //validacion de archivos
        try{

            this.servicioArchivo.validarArchivos(pd.getFiles());

        }catch (EmptyFileException error){
            throw new DataValidationException("Es necesario que suba al menos una imagen para poder generar la Publicación");
        }catch (MaxSizeFileException error){
            throw new DataValidationException(error.getMessage());
        }


        return true;
    }

    private Long publicar(PublicacionDto publicacionDto) {
        Publicacion pub = this.setearPublicacion(publicacionDto);

        try {

            Long pid = repositorioPublicacion.guardarPublicacion(pub);

            this.servicioArchivo.subirImagenesPost(publicacionDto.getFiles(), pub);

            return pid;

        }catch (RuntimeException error){
            throw new PostCreationException("No se Pudo generar la Publicación debido a un error");
        }


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
