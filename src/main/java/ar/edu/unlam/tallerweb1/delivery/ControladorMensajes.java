package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.Mensajes.IServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorMensajes {

    private final IServicioMensajes servicioMensajes;
    private final IServicioAuth servicioAuth;

    @Autowired
    public ControladorMensajes(IServicioMensajes servicioMensajes, IServicioAuth servicioAuth){
        this.servicioMensajes = servicioMensajes;
        this.servicioAuth = servicioAuth;
    }
}
