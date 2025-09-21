package ar.edu.unlam.tallerweb1.domain.mascota;
import ar.edu.unlam.tallerweb1.delivery.dto.MascotaDto;
import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import ar.edu.unlam.tallerweb1.domain.exceptions.DataValidationException;
import ar.edu.unlam.tallerweb1.domain.exceptions.EmptyFileException;
import ar.edu.unlam.tallerweb1.domain.exceptions.MaxSizeFileException;
import ar.edu.unlam.tallerweb1.model.Mascota;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicioMascota implements IServicioMascota {


    private final IServicioArchivo servicioArchivo;
    private final IRepositorioMascota repositorioMascota;


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
        if(mascotaDto.getNombre().isEmpty()) throw new DataValidationException( "Debe especificar un nombre");

        if(mascotaDto.getGenero() == null) throw new DataValidationException( "Debe especificar el género de la mascota");

        if(mascotaDto.getTipo() == null) throw new DataValidationException( "Debe especificar un Tipo de mascota");

        return true;

    }

    private Long registrarMascota(MascotaDto mDto, Usuario user){
        Mascota mascota = this.setearMascota(mDto, user);

        this.repositorioMascota.guardar(mascota);

        return mascota.getId();
    }

    private Mascota setearMascota(MascotaDto mDto, Usuario user) {
        Mascota m = new Mascota();

        String encodeImage;

        m.setUsuario(user);
        m.setNombre(mDto.getNombre());
        m.setGenero(mDto.getGeneroToEnum());
        m.setPersonalidad(mDto.getPersonalidad());
        m.setNacimiento(mDto.getNacimiento());
        m.setRaza(mDto.getRaza());
        m.setPeso(mDto.getPeso());
        m.setTipo(mDto.getTipoToEnum());
        m.setSalud(mDto.getSalud());

        try{
            encodeImage = this.servicioArchivo.encodeImage(mDto.getImagen());
        }catch (MaxSizeFileException error){
            throw new DataValidationException(error.getMessage());
        }

        m.setFoto(encodeImage == null ? this.servicioArchivo.getDefaultMascotImageEncoded() : encodeImage);


        return m;
    }



}
