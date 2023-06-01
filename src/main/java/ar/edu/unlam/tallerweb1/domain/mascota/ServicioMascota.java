package ar.edu.unlam.tallerweb1.domain.mascota;
import ar.edu.unlam.tallerweb1.delivery.dto.MascotaDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicioMascota implements IServicioMascota {


    private final IServicioArchivo servicioArchivo;
    private final IRepositorioMascota repositorioMascota;
    private String errorMessage;

    @Autowired
    public ServicioMascota(IRepositorioMascota repositorioMascota, IServicioArchivo servicioArchivo){
        this.servicioArchivo = servicioArchivo;
        this.repositorioMascota = repositorioMascota;
    }

    @Override
    public Long guardar(MascotaDto mascotaDto, Usuario usuario){
        if (!this.validarDatos(mascotaDto))
            return null;
        return this.registrarMascota(mascotaDto,usuario);
    }

    @Override
    public List<Mascota> listarMascotasAPublicar(Usuario usuario) {
        return this.repositorioMascota.listarMascotasaPublicar(usuario);
    }

    @Override
    public List<Mascota> listarMascotaPorUsuario(Usuario usuario) {
        return repositorioMascota.listarMascotaPorUsuario(usuario);
    }



    public boolean validarDatos(MascotaDto mascotaDto) {
        if (mascotaDto.getNombre() == null || mascotaDto.getNombre().length() == 0){
            this.errorMessage = "Debe especificar un nombre";
            return false;
        }
        if (mascotaDto.getGenero() == null){
            this.errorMessage = "Debe especificar el g�nero de la mascota";
            return false;
        }
        if(mascotaDto.getTipo() == null){
            this.errorMessage = "Debe especificar un Tipo de mascota";
            return false;
        }

        return true;

    }

    private Long registrarMascota(MascotaDto mDto, Usuario user){
        Mascota mascota = this.setearMascota(mDto, user);

        this.repositorioMascota.guardar(mascota);

        return mascota.getId();
    }

    private Mascota setearMascota(MascotaDto mDto, Usuario user) {
        Mascota m = new Mascota();
        m.setUsuario(user);
        m.setNombre(mDto.getNombre());
        m.setGenero(mDto.getGenero());
        m.setPersonalidad(mDto.getPersonalidad());
        m.setNacimiento(mDto.getNacimiento());
        m.setRaza(mDto.getRaza());
        m.setPeso(mDto.getPeso());
        m.setTipo(mDto.getTipo());
        m.setSalud(mDto.getSalud());
        String nombreImagen = this.servicioArchivo.subirAvatarMascota(mDto.getImagen());
        m.setFoto(nombreImagen);


        return m;
    }

    @Override
    public String getErrorMessage(){
        return this.errorMessage;
    }
    

}
