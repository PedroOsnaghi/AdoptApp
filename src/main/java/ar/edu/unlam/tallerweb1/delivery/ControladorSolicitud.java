package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.delivery.dto.SolicitudDto;
import ar.edu.unlam.tallerweb1.domain.Solicitud.IServicioSolicitud;
import ar.edu.unlam.tallerweb1.domain.exceptions.DataValidationException;
import ar.edu.unlam.tallerweb1.model.Solicitud;
import ar.edu.unlam.tallerweb1.model.enumerated.EstadoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/solicitud")
public class ControladorSolicitud {


    private final IServicioSolicitud servicioSolicitud;

    @Autowired
    public ControladorSolicitud(IServicioSolicitud servicioSolicitud){
        this.servicioSolicitud = servicioSolicitud;
    }

    @RequireAuth
    @RequestMapping(path = "/enviar", method = RequestMethod.POST)
    public ModelAndView enviarSolicitud(@ModelAttribute("publicacionDto") SolicitudDto solicitudDto, HttpServletRequest request) {

        try{

            this.servicioSolicitud.enviarSolicitud(solicitudDto);

        }catch (DataValidationException error){
            return new ModelAndView("redirect: " + request.getContextPath() + "/publicacion/ver?pid=" + solicitudDto.getPublicacionSol().getId() + "&sol_response=error");
        }

        return new ModelAndView("redirect: " + request.getContextPath() + "/publicacion/ver?pid=" + solicitudDto.getPublicacionSol().getId() + "&sol_response=success");

    }

    @RequireAuth
    @RequestMapping(path = "/cancelar", method = RequestMethod.POST)
    public ModelAndView cancelarSolicitud(@ModelAttribute Solicitud solicitud, @RequestParam(required = false) String target, HttpServletRequest request) {

        try{
            solicitud.setEstado(EstadoSolicitud.PENDIENTE);
            this.servicioSolicitud.cancelarSolicitud(solicitud);

        }catch (DataValidationException error){
            return new ModelAndView("redirect: " + request.getContextPath() + "/publicacion/ver?pid=" + solicitud.getPublicacion().getId() + "&sol_response=error");
        }

        switch (target){
            case "publicacion":
                return new ModelAndView("redirect: " + request.getContextPath() + "/publicacion/ver?pid=" + solicitud.getPublicacion().getId());
            case "perfil":
                return new ModelAndView("redirect: " + request.getContextPath() + "/perfil/actividad/solicitudes");
            default:
                return new ModelAndView("redirect: " + request.getContextPath() + "/home");
        }


    }
}
