package ar.edu.unlam.tallerweb1.domain.publicaciones;

import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.domain.exceptions.*;
import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Publicacion getPublicacion (Long id) {

        if(id == null) return null;

        Publicacion p = repositorioPublicacion.buscarPublicacionPorId(id);

        if(p == null) throw new NotFoundPostExcption("El resurso no se encuentra disponible o no existe");

        return p;
    }


    @Override
    public Long  guardarPublicacion(PublicacionDto publicacionDto) {

        this.validarPublicacion(publicacionDto);

        return this.publicar(publicacionDto);
    }

    @Override
    public void modificarPublicacion(Publicacion publicacion) {
        //TODO Implementar modificar Publicacion
    }

    @Override
    public void actualizarPublicacion(PublicacionDto publicacionDto) {

            this.validarPublicacion(publicacionDto);
            Publicacion pub = this.repositorioPublicacion.buscarPublicacionPorId(publicacionDto.getId());

            //valida que la publicacion tenga los estados validos para pausar o reanudar
            if(pub.getEstado() != EstadoPublicacion.DISPONIBLE) throw new PostChangeException("Operación no permitida para esta publicacion","3001");

            pub.merge(publicacionDto);



        try{
            this.repositorioPublicacion.modificarPublicacion(pub);
            this.servicioArchivo.subirImagenesPost(publicacionDto.getFiles(), pub);

        }catch (RuntimeException error){
            throw new PostCreationException("No se Pudo generar la Publicación debido a un error");
        }
    }

    @Override
    public void reservar(Publicacion publicacion) {
        publicacion.setEstado(EstadoPublicacion.RESERVADO);
        this.repositorioPublicacion.modificarPublicacion(publicacion);
    }

    @Override
    public void cerrar(Publicacion publicacion) {
        publicacion.setEstado(EstadoPublicacion.CERRADA);
        this.repositorioPublicacion.modificarPublicacion(publicacion);
    }

    @Override
    public List<Solicitud> listarPublicacionesCerradasPorUsuario(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesCerradasPorUsuario(idUsuario);
    }



    @Override
    public void reanudar(Publicacion publicacion) {
        publicacion.setEstado(EstadoPublicacion.DISPONIBLE);
        this.repositorioPublicacion.modificarPublicacion(publicacion);
    }

    @Override
    public Long getPublicacionesPorUsuario(Long idUsuario) {
        return this.repositorioPublicacion.getPublicacionesPorUsuario(idUsuario);
    }


    @Override
    public void pausarPublicacion(Long pid, Usuario userAuth) {

        Publicacion p = this.repositorioPublicacion.buscarPublicacionPorId(pid);
        //valida que la publicacion tenga los estados validos para pausar o reanudar
        if(p.getEstado() != EstadoPublicacion.DISPONIBLE) throw new PostChangeException("Operación no permitida para esta publicacion","3001");



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



    @Override
    public void eliminarPublicacion(Long idPublicacion, Usuario userAuth) {
        Publicacion p = this.repositorioPublicacion.buscarPublicacionPorId(idPublicacion);

        //valida que la publicacion tenga los estados validos para pausar o reanudar
        if(p.getEstado() != EstadoPublicacion.DISPONIBLE) throw new PostChangeException("Operación no permitida para esta publicacion","3001");

        if(this.validarUsuario(p, userAuth))
            this.repositorioPublicacion.eliminarPublicacion(p);
    }

    @Override
    public List<Publicacion> listarPublicacionesPorUsuarioId(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesPorUsuarioId(idUsuario);
    }

    @Override
    public List<PublicacionDetallada> listarPublicacionesDetalladasPorUsuarioId(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesDetalladasPorUsuarioId(idUsuario);
    }

    @Override
    public List<PublicacionMensajes> listarPublicacionesMensajesPorUsuarioId(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesConMensajesPorUsuarioId(idUsuario);
    }

    @Override
    public List<PublicacionSolicitud> listarPublicacionesDisponiblesParaSolicitudPorUsuarioId(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesDisponiblesParaSolicitudPorUsuarioId(idUsuario);
    }

    @Override
    public List<Publicacion> listarPublicacionesDisponiblesPorUsuarioId(Long idUsuario) {
        return this.repositorioPublicacion.listarPublicacionesDisponiblesPorUsuarioId(idUsuario);
    }

    @Override
    public List<Publicacion_favorito> listarFavoritosDeUsuario(Long idUsuario) {
        return this.repositorioPublicacion.ListarFavoritosDeUsuario(idUsuario);
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



    private boolean validarPublicacion(PublicacionDto pd) {
        if(pd.getMascota() == null ||  pd.getMascota().getId() == null) throw new DataValidationException("Debe seleccionar una mascota");

        if(pd.getBio().isEmpty() || pd.getBio().length() == 0) throw new DataValidationException("Debe especificar un contenido en la Bio de la publicación");

        if(pd.getDireccion().isEmpty() || pd.getDireccion().length() == 0) throw new DataValidationException("Debe especificar una dirección de entrega");

        if(pd.getDisponibilidad().isEmpty() || pd.getDisponibilidad().length() == 0) throw new DataValidationException("Debe especificar su disponibilidad horaria");



        //validacion de archivos
        try{

            this.servicioArchivo.validarArchivos(pd.getFiles());

        }catch (EmptyFileException error){
           if(pd.getImagenes() == null || pd.getImagenes().size() == 0) throw new DataValidationException("Es necesario que suba al menos una imagen para poder generar la Publicación");
        }catch (MaxSizeFileException error){
            throw new DataValidationException(error.getMessage());
        }


        return true;
    }



    private Long publicar(PublicacionDto publicacionDto) {

        Publicacion pub = new Publicacion(publicacionDto);

        try {

            Long pid = repositorioPublicacion.guardarPublicacion(pub);

            this.servicioArchivo.subirImagenesPost(publicacionDto.getFiles(), pub);

            return pid;

        }catch (RuntimeException error){
            throw new PostCreationException("No se Pudo generar la Publicación debido a un error");
        }


    }







}
