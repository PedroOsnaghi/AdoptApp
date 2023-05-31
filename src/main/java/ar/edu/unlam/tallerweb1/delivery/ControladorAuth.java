package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.delivery.dto.LoginDto;
import ar.edu.unlam.tallerweb1.delivery.dto.RegistrarDto;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioSesion;
import ar.edu.unlam.tallerweb1.domain.usuarios.IServicioUsuario;
import ar.edu.unlam.tallerweb1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorAuth {

    private final IServicioUsuario servicioUsuario;
    private final IServicioAuth servicioAuth;
    private final IServicioSesion servicioSesion;

    @Autowired
    public ControladorAuth(IServicioAuth servicioAuth, IServicioUsuario servicioUsuario, IServicioSesion servicioSesion) {
        this.servicioAuth = servicioAuth;
        this.servicioUsuario = servicioUsuario;
        this.servicioSesion = servicioSesion;
    }


    @RequestMapping("/login")
    public ModelAndView renderLogin() {
        ModelMap model = new ModelMap();

        model.put("loginDto", new LoginDto());

        return new ModelAndView("/login", model);
    }

    @RequestMapping(path = "/loginHandler", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("loginDto") LoginDto loginDto) {

        boolean credencialesValidas = false;
        Usuario usuarioAutenticado = servicioUsuario.buscarUsuarioPorEmail(loginDto.getEmail());

        if(usuarioAutenticado != null){
            credencialesValidas = servicioAuth.validarCredenciales(usuarioAutenticado, loginDto.getPassword());
        }

        if (!credencialesValidas) {
            ModelMap model = new ModelMap();
            model.put("error", "Usuario y/o contraseña invalido");

            return new ModelAndView("/login", model);
        }

        servicioSesion.setTiempoSesion(60 * 60 * 24);
        servicioAuth.setUsuarioAutenticado(usuarioAutenticado);

        return new ModelAndView("redirect:/home/");
    }

    @RequestMapping(path = "/cerrarSesion", method = RequestMethod.POST)
    public ModelAndView cerrarSesion() {

        servicioSesion.eliminarSesion();

        return new ModelAndView("redirect:/login");
    }

    @RequestMapping("/registrar")
    public ModelAndView renderRegistrar() {
        ModelMap model = new ModelMap();

        model.put("registrarDto", new RegistrarDto());

        return new ModelAndView("register", model);
    }

    @RequestMapping(path = "/registrarHandler", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute("registrarDto") RegistrarDto registrarDto) {

        String nombre = registrarDto.getNombre();
        String email = registrarDto.getEmail();
        String password = registrarDto.getPassword();
        String password2 = registrarDto.getPassword2();


        if (!password.equals(password2)) {
            ModelMap model = new ModelMap();
            model.put("error", "Las contraseñas no coinciden");
            return new ModelAndView("/register", model);
        }

        String passwordHasheada = servicioAuth.encriptarPassword(password);
        Usuario usuarioCreado = servicioUsuario.crearUsuario(nombre, email, passwordHasheada);

        if (usuarioCreado == null) {
            ModelMap model = new ModelMap();
            model.put("error", "Error al crear usuario");

            return new ModelAndView("/register", model);
        }

        return new ModelAndView("/register-success");
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home/feed");
    }


}
