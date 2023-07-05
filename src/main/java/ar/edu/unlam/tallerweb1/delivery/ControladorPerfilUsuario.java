package ar.edu.unlam.tallerweb1.delivery;
import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.delivery.dto.MensajeDto;
import ar.edu.unlam.tallerweb1.delivery.dto.UsuarioDto;
import ar.edu.unlam.tallerweb1.domain.Calificacion.IServicioCalificacion;
import ar.edu.unlam.tallerweb1.domain.Mensajes.IServicioMensajes;
import ar.edu.unlam.tallerweb1.domain.Solicitud.IServicioSolicitud;
import ar.edu.unlam.tallerweb1.domain.adopcion.IServicioAdopcion;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.mascota.IServicioMascota;
import ar.edu.unlam.tallerweb1.domain.publicaciones.IServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.IServicioUsuario;
import ar.edu.unlam.tallerweb1.model.Solicitud;
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
    private final IServicioCalificacion servicioCalificacion;
    private final IServicioMascota servicioMascota;
    private final IServicioSolicitud servicioSolicitud;
    private final IServicioAdopcion servicioAdopcion;

    @Autowired
    public ControladorPerfilUsuario(IServicioUsuario servicioUsuario, IServicioPublicacion servicioPublicacion, IServicioMensajes servicioMensajes, IServicioAuth servicioAuth,
                                    IServicioCalificacion servicioCalificacion, IServicioMascota servicioMascota, IServicioSolicitud servicioSolicitud, IServicioAdopcion servicioAdopcion) {
        this.servicioUsuario = servicioUsuario;
        this.servicioAuth = servicioAuth;
        this.servicioPublicacion = servicioPublicacion;
        this.servicioMensajes = servicioMensajes;
        this.servicioCalificacion = servicioCalificacion;
        this.servicioMascota = servicioMascota;
        this.servicioSolicitud = servicioSolicitud;
        this.servicioAdopcion = servicioAdopcion;
    }


    private ModelMap iniciarModel(String target){
        ModelMap model = new ModelMap();

        model.put("usuario", this.servicioAuth.getUsuarioAutenticado());
        model.put("publicados", this.servicioPublicacion.getPublicacionesPorUsuario(this.servicioAuth.getUsuarioAutenticado().getId()));
        model.put("adoptados", this.servicioAdopcion.getAdoptadosPorUsuario(this.servicioAuth.getUsuarioAutenticado().getId()));
        model.put("target", target);

        return model;
    }


    @RequireAuth
    @RequestMapping("/actividad/posts")
    public ModelAndView misPublicaciones(){

        ModelMap model = this.iniciarModel("actividad");

        model.put("seccion", "posts");

        model.put("cal_publicador", this.servicioCalificacion.getCalificacionPublicador(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("cal_adoptante", this.servicioCalificacion.getCalificacionAdoptante(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("publicaciones", this.servicioPublicacion.listarPublicacionesDetalladasPorUsuarioId(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("publicaciones_cerradas", this.servicioPublicacion.listarPublicacionesCerradasPorUsuario(this.servicioAuth.getUsuarioAutenticado().getId()));

        return new ModelAndView("user-profile-activity-posts", model);

    }

    @RequireAuth
    @RequestMapping("/actividad/favoritos")
    public ModelAndView misFavoritos(){

        ModelMap model = this.iniciarModel("actividad");

        model.put("seccion", "favoritos");

        model.put("cal_publicador", this.servicioCalificacion.getCalificacionPublicador(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("cal_adoptante", this.servicioCalificacion.getCalificacionAdoptante(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("publicaciones", this.servicioPublicacion.listarFavoritosDeUsuario(this.servicioAuth.getUsuarioAutenticado().getId()));

        return new ModelAndView("user-profile-activity-favorites", model);


    }

    @RequireAuth
    @RequestMapping("/actividad/solicitudes")
    public ModelAndView misSolicitudes(){

        ModelMap model = this.iniciarModel("actividad");

        model.put("seccion", "solicitudes");

        model.put("cal_publicador", this.servicioCalificacion.getCalificacionPublicador(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("cal_adoptante", this.servicioCalificacion.getCalificacionAdoptante(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("solicitudes", this.servicioSolicitud.listarSolicitudesEnviadas(this.servicioAuth.getUsuarioAutenticado()));

        model.put("solicitudes_cerradas", this.servicioSolicitud.listarSolicitudesCerradasPorUsuario(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("ma_solicitud", new Solicitud());

        return new ModelAndView("user-profile-activity-solicitudes", model);

    }

    @RequireAuth
    @RequestMapping("/actividad/mismascotas")
    public ModelAndView misMascotas(){

        ModelMap model = this.iniciarModel("actividad");

        model.put("seccion", "mascotas");

        model.put("cal_publicador", this.servicioCalificacion.getCalificacionPublicador(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("cal_adoptante", this.servicioCalificacion.getCalificacionAdoptante(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("mascotas", this.servicioMascota.listarMascotaPorUsuario(this.servicioAuth.getUsuarioAutenticado()));

        model.put("adopciones", this.servicioAdopcion.listarAdoptadasPorUsuario(this.servicioAuth.getUsuarioAutenticado()));

        return new ModelAndView("user-profile-activity-mascot", model);

    }

    @RequireAuth
    @RequestMapping("/info")
    public ModelAndView infoUsuario(){

        ModelMap model = this.iniciarModel("info");

        return new ModelAndView("user-profile-info", model);

    }

    @RequireAuth
    @RequestMapping("/solicitud")
    public ModelAndView solicitudesUsuario(@RequestParam(required = false) Long pid){

        ModelMap model = this.iniciarModel("solicitud");

        model.put("publicaciones", this.servicioPublicacion.listarPublicacionesDisponiblesParaSolicitudPorUsuarioId(this.servicioAuth.getUsuarioAutenticado().getId()));

        model.put("solicitud_aceptada", this.servicioSolicitud.getSolicitudAceptada(pid));

        model.put("solicitud_cancelada", this.servicioSolicitud.getSolicitudCanceladaSinInformar(pid));

        model.put("solicitudes", this.servicioSolicitud.listarSolicitudesRecibidas(pid));

        model.put("selected_pub", pid);

        model.put("ma_solicitud", new Solicitud());

        return new ModelAndView("user-profile-request", model);


    }

    @RequireAuth
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


    @RequireAuth
    @RequestMapping("/info/editar")
    public ModelAndView irAEditarDatos() {

        ModelMap model = this.iniciarModel("info");

        UsuarioDto usuarioDto = this.setearDatos(this.servicioAuth.getUsuarioAutenticado());

        model.put("usuarioDto", usuarioDto);

        return new ModelAndView("user-profile-edit", model);


    }


    @RequireAuth
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


