package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.delivery.dto.UsuarioDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.domain.exceptions.NotFoundPostExcption;
import ar.edu.unlam.tallerweb1.domain.exceptions.NotFoundUserExcption;
import ar.edu.unlam.tallerweb1.model.Publicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario implements IServicioUsuario {


    private final IServicioArchivo servicioArchivo;
    private final IRepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuario(IRepositorioUsuario repositorioUsuario, IServicioArchivo servicioArchivo){
        this.repositorioUsuario = repositorioUsuario;
        this.servicioArchivo = servicioArchivo;
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email){
        return this.repositorioUsuario.buscarUsuarioPorEmail(email);
    }

    @Override
    public Usuario crearUsuario(String nombre, String email, String password) {
        Usuario usuario = new Usuario(nombre, email, password);
        usuario.setImagen(this.servicioArchivo.getDefaultUserImageEncoded());
        return repositorioUsuario.guardarUsuario(usuario);
    }

    @Override
    public Usuario actualizarDatos(UsuarioDto usuarioDto, Usuario oldUsuer) {
        Usuario usuario = this.setDatosUsuario(usuarioDto , oldUsuer);
        this.repositorioUsuario.actualizarDatos(usuario);
        return usuario;
    }

    @Override
    public Usuario getUsuario(Long idUsuario) {
        if(idUsuario == null) return null;

        Usuario u = this.repositorioUsuario.getUsuario(idUsuario);

        if(u == null) throw new NotFoundUserExcption("El usuario que búscas no existe");

        return u;
    }

    private Usuario setDatosUsuario(UsuarioDto uDto, Usuario user) {
        user.setNombre(uDto.getNombre());
        user.setF_nac(uDto.getF_nac());
        user.setDomicilio(uDto.getDomicilio());
        user.setCiudad(uDto.getCiudad());
        user.setProvincia(uDto.getProvincia());
        user.setLat(uDto.getLat());
        user.setLng(uDto.getLng());
        user.setPresentacion(uDto.getPresentacion());

        String nombreArchivo = this.servicioArchivo.encodeImage(uDto.getAvatar());
        if(nombreArchivo != null) user.setImagen(nombreArchivo);

        return user;

    }


}
