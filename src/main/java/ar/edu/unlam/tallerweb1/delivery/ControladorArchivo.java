package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.archivos.IServicioArchivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/archivo")
public class ControladorArchivo {

    private IServicioArchivo servicioArchivo;

    @Autowired
    public ControladorArchivo(IServicioArchivo servicioArchivo){
        this.servicioArchivo = servicioArchivo;
    }


}
