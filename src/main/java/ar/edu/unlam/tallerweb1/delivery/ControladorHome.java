package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Controller
public class ControladorHome {

    private Usuario userAuth;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(path = "/home",method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {

        userAuth = (Usuario) session.getAttribute("usuarioAutenticado");

        if(userAuth != null){
            ModelMap model = new ModelMap();
            model.addAttribute("usuario", userAuth);
            return new ModelAndView("index-feed",model);
        }

        return new ModelAndView("redirect:/login");

    }
}
