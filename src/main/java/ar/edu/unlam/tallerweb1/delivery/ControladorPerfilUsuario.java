package ar.edu.unlam.tallerweb1.delivery;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.IServicioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/perfil")
public class ControladorPerfilUsuario {


    private final IServicioAuth servicioAuth;
    private final IServicioUsuario servicioUsuario;
    private final IServicioPublicacion servicioPublicacion;
    private final IServicioMensajes servicioMensajes;

    @Autowired
    public ControladorPerfilUsuario(IServicioUsuario servicioUsuario, IServicioPublicacion servicioPublicacion, IServicioMensajes servicioMensajes, IServicioAuth servicioAuth) {
        this.servicioUsuario = servicioUsuario;
        this.servicioAuth = servicioAuth;
        this.servicioPublicacion = servicioPublicacion;
        this.servicioMensajes = servicioMensajes;
    }


    private ModelMap iniciarModel(String target){
        ModelMap model = new ModelMap();

        model.put("usuario", this.servicioAuth.getUsuarioAutenticado());

        model.put("target", target);

        return model;
    }

    @RequestMapping("/actividad/posts")
    public ModelAndView misPublicaciones(){
        ModelMap model = this.iniciarModel("actividad");

        model.put("seccion", "posts");

        //TODO Implementar sevicio de Calificaciones

        //TODO implementar Listado de publicaciones del usuario

        return new ModelAndView("user-profile-activity-posts", model);
    }

    @RequestMapping("/actividad/favoritos")
    public ModelAndView misFavoritos(){
        ModelMap model = this.iniciarModel("actividad");

        model.put("seccion", "favoritos");

        //TODO Implementar sevicio de Calificaciones

        //TODO implementar Listado de favoritos de usuario

        return new ModelAndView("user-profile-activity-favorites", model);
    }

    @RequestMapping("/actividad/solicitudes")
    public ModelAndView misSolicitudes(){
        ModelMap model = this.iniciarModel("actividad");

        model.put("seccion", "solicitudes");

        //TODO Implementar sevicio de Calificaciones

        //TODO implementar Listado de mis solicitudes de adopcion

        return new ModelAndView("user-profile-activity-solicitudes", model);
    }

    @RequestMapping("/actividad/mismascotas")
    public ModelAndView misMascotas(){
        ModelMap model = this.iniciarModel("actividad");


        model.put("seccion", "mascotas");

        //TODO Implementar sevicio de Calificaciones

        //TODO implementar Listado de mis mascotas

        return new ModelAndView("user-profile-activity-mascot", model);
    }

    @RequestMapping("/info")
    public ModelAndView infoUsuario(){
        ModelMap model = this.iniciarModel("info");

        //TODO enviar datos del usuario a la vista

        return new ModelAndView("user-profile-info", model);
    }

    @RequestMapping("/solicitud")
    public ModelAndView solicitudesUsuario(){
        ModelMap model = this.iniciarModel("solicitud");

        //TODO mostrar solicitudes de adopcion

        return new ModelAndView("user-profile-request", model);
    }

    @RequestMapping("/mensajes")
    public ModelAndView verMensajes(@RequestParam(required = false) Long pid, String response){
        ModelMap model = this.iniciarModel("mensajes");


        model.put("publicaciones", this.servicioPublicacion.listarPublicacionesMensajesPorUsuarioId(this.servicioAuth.getUsuarioAutenticado().getId()));
        model.put("mensajes_nuevos", this.servicioMensajes.listarMensajesSinResponder(pid));
        model.put("mensajes_respondidos", this.servicioMensajes.listarMensajesRespondidos(pid));
        model.put("selected_pub", pid);
        model.put("mensajeDto", new MensajeDto());
        model.put("response", response);





        return new ModelAndView("user-profile-messages", model);
    }


    @RequestMapping("/info/editar")
    public ModelAndView irAEditarDatos(HttpSession session) {
        ModelMap model = this.iniciarModel("info");

        UsuarioDto usuarioDto = this.setearDatos(this.servicioAuth.getUsuarioAutenticado());

        model.put("usuarioDto", usuarioDto);

        return new ModelAndView("user-profile-edit", model);
    }


    @RequestMapping(value = "/info/actualizar", method = RequestMethod.POST)
    public ModelAndView guardarDatos(@ModelAttribute UsuarioDto usuarioDto) {

        Usuario usuarioActualizado = this.servicioUsuario.actualizarDatos(usuarioDto, this.servicioAuth.getUsuarioAutenticado());

        this.servicioAuth.setUsuarioAutenticado(usuarioActualizado);

        ModelMap modelo = this.iniciarModel(null);

        return new ModelAndView("user-profile-info", modelo);
    }

    private UsuarioDto setearDatos(Usuario usuario) {
        UsuarioDto udto = new UsuarioDto();
        udto.setId(usuario.getId());
        udto.setNombre(usuario.getNombre());
        udto.setF_nac(usuario.getF_nac());
        udto.setImagen(usuario.getImagen());
        udto.setPresentacion(usuario.getPresentacion());
        udto.setDomicilio(usuario.getDomicilio());
        udto.setCiudad(usuario.getCiudad());
        udto.setProvincia(usuario.getProvincia());
        udto.setLat(usuario.getLat());
        udto.setLng(usuario.getLng());

        return udto;

    }


}


