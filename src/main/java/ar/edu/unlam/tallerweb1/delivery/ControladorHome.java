package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Controller
public class ControladorHome {

    private Usuario userAuth;
    @RequestMapping(path = "/home",method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {

        userAuth = (Usuario) session.getAttribute("usuario-autenticado");

        if(userAuth == null)
            return new ModelAndView("redirect:/login");
        return new ModelAndView("index-feed");
    }
}
