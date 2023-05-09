package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ControladorAuth {

    @Autowired
    ServicioAuth servicioAuth;

    @Autowired
    ServicioUsuario servicioUsuario;

    @Autowired
    RepositorioUsuario repositorioUsuario;


    @RequestMapping("/login")
    public ModelAndView renderLogin() {
        return new ModelAndView("/login");
    }

    // NOTA: por ahora solo mete un usuario en la sesion.
    @RequestMapping(path = "/loginHandler", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String email, @RequestParam String password, HttpSession session) {

        boolean credencialesValidas = servicioAuth.validarCredenciales(email, password);

        if (!credencialesValidas) {
            ModelMap model = new ModelMap();
            model.put("error", "Credenciales invalidas");

            return new ModelAndView("/login", model);
        }

        Usuario usuarioAutenticado = repositorioUsuario.buscarPorEmail(email);
        servicioAuth.setTiempoSesion(60 * 60 * 24);
        servicioAuth.setUsuarioAutenticado(usuarioAutenticado);

        return new ModelAndView("redirect:/test");
    }

    @RequestMapping(path = "/cerrarSesion", method = RequestMethod.POST)
    public ModelAndView cerrarSesion(HttpSession session) {

        servicioAuth.eliminarSesion();

        return new ModelAndView("redirect:/login");
    }

    @RequestMapping("/registrar")
    public ModelAndView renderRegistrar() {
        return new ModelAndView("register-sin-etiquetas");
    }

    @RequestMapping(path = "/registrarHandler", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute("registrarDto") RegistrarDto registrarDto) {

        String nombre = registrarDto.getNombre();
        String email = registrarDto.getEmail();
        String password = registrarDto.getPassword();
        String password2 = registrarDto.getPassword2();


        if (!password.equals(password2)) {
            ModelMap model = new ModelMap();
            model.put("error", "Passwords no coinciden");
            return new ModelAndView("/register-sin-etiquetas", model);
        }

        String passwordHasheada = servicioAuth.encriptarPassword(password);
        Usuario usuarioCreado = servicioUsuario.crearUsuario(nombre, email, passwordHasheada);

        if (usuarioCreado == null) {
            ModelMap model = new ModelMap();
            model.put("error", "Error al crear usuario");

            return new ModelAndView("/register-sin-etiquetas", model);
        }

        return new ModelAndView("/register-success");
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView loginRedirect() {
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        Usuario usuario = servicioAuth.getUsuarioAutenticado();
        String email = usuario.getEmail();
        String password = usuario.getPassword();
        boolean usuarioLoggeado = servicioAuth.usuarioLoggeado();
        return email + password + usuarioLoggeado;
    }
}
