package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.ServicioAuth;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String renderLogin() {
        return "/auth/login";
    }

    // NOTA: por ahora solo mete un usuario en la sesion.
    @RequestMapping(path = "/loginHandler", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String email, @RequestParam String password, HttpSession session) {

        boolean credencialesValidas = servicioAuth.validarCredenciales(email, password);

        if (!credencialesValidas) {
            ModelMap model = new ModelMap();
            model.put("error", "Credenciales invalidas");

            return new ModelAndView("redirect:/login", model);
        }

        servicioAuth.setTiempoSesion(session, 60 * 60 * 24);
        Usuario usuarioAutenticado = repositorioUsuario.buscarPorEmail(email);
        servicioAuth.setUsuarioAutenticado(usuarioAutenticado, session);

        return new ModelAndView("/index");
    }

    @RequestMapping(path = "/cerrarSesion", method = RequestMethod.POST)
    public String cerrarSesion(HttpSession session) {

        servicioAuth.eliminarSesion(session);

        return "auth/login";
    }

    @RequestMapping("/registrar")
    public String renderRegistrar() {
        return "/auth/registrar";
    }

    @RequestMapping(path = "/registrarHandler", method = RequestMethod.POST)
    public ModelAndView registrar(@RequestParam String email, @RequestParam String password) {

        String passwordHasheada = servicioAuth.encriptarPassword(password);
        Usuario usuarioCreado = servicioUsuario.crearUsuario(email, passwordHasheada);

        if (usuarioCreado != null) {
            ModelMap model = new ModelMap();
            model.put("error", "Error al crear usuario");

            return new ModelAndView("redirect:/registrar", model);
        }

        return new ModelAndView("/registro-exitoso");
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "test";
    }
}
