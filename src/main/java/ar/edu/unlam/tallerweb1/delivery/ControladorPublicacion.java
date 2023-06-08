package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.delivery.dto.PublicacionDto;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.exceptions.DataValidationException;
import ar.edu.unlam.tallerweb1.domain.exceptions.EmptyFileException;
import ar.edu.unlam.tallerweb1.domain.exceptions.MaxSizeFileException;
import ar.edu.unlam.tallerweb1.domain.exceptions.PostCreationException;
import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;


@Controller
@RequestMapping("/publicacion")
public class ControladorPublicacion {

    private final IServicioAuth servicioAuth;
    private final IServicioPublicacion servicioPublicacion;
    private final IServicioMascota servicioMascota;
    private final IServicioMensajes servicioMesnaje;

    private Usuario userAuth;

    @Autowired
    public ControladorPublicacion(IServicioPublicacion servicioPublicacion, IServicioMascota servicioMascota, IServicioMensajes servicioMensaje, IServicioAuth servicioAuth) {
        this.servicioPublicacion = servicioPublicacion;
        this.servicioAuth = servicioAuth;
        this.servicioMascota = servicioMascota;
        this.servicioMesnaje = servicioMensaje;
    }

    private ModelMap iniciarModel() {
        this.userAuth = this.servicioAuth.getUsuarioAutenticado();
        ModelMap m = new ModelMap();
        m.put("usuario", this.userAuth);
        m.put("mascotas", this.servicioMascota.listarMascotasAPublicar(this.userAuth));
        return m;
    }

    @RequireAuth
    @RequestMapping(path = "/crear", method = RequestMethod.GET)
    public ModelAndView crear() {

        ModelMap model = this.iniciarModel();
        
        model.put("publicacionDto", new PublicacionDto());

        return new ModelAndView("new-post", model);
    }


    @RequireAuth
    @RequestMapping(path = "/publicar", method = RequestMethod.POST)
    public ModelAndView guardarPublicacion(@ModelAttribute("publicacionDto") PublicacionDto publicacionDto, HttpServletRequest request) {
        ModelMap model = this.iniciarModel();

        Long p_id;

        try{

           p_id = servicioPublicacion.guardarPublicacion(publicacionDto);

        }catch (DataValidationException | PostCreationException error){
            model.put("error", error.getMessage());
            return new ModelAndView("new-post",model);
        }


        return new ModelAndView("redirect: " + request.getContextPath() + "/home/mispublicaciones?pid=" + p_id);




    }

    @RequireAuth
    @RequestMapping(path = "/ver", method = RequestMethod.GET)
    public ModelAndView verPublicacion(@RequestParam Long pid, @RequestParam(required = false) String msj_response){
        ModelMap model = iniciarModel();

        model.put("publicacion", this.servicioPublicacion.findPublicacion(pid));

        model.put("mensajes", this.servicioMesnaje.listarMensajesPublicacion(pid));

        model.put("mensajeDto", new MensajeDto());

        model.put("msj_response", msj_response);

        return new ModelAndView("post-details", model);
    }






}
