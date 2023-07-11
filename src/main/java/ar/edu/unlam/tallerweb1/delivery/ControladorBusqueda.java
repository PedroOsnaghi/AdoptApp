package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import ar.edu.unlam.tallerweb1.domain.busqueda.IServicioBusqueda;
import ar.edu.unlam.tallerweb1.domain.chat.IServicioChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

@RestController
@RequestMapping("/buscar")
public class ControladorBusqueda {

    private final IServicioBusqueda servicioBusqueda;


    @Autowired
    public ControladorBusqueda(IServicioBusqueda servicioBusqueda){
        this.servicioBusqueda = servicioBusqueda;
    }



    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ModelAndView searchAll(@RequestParam String searchText){
        ModelMap model = new ModelMap();

        model.put("result", this.servicioBusqueda.buscar(searchText));

        return new ModelAndView("partials/searchResult", model);
    }

}
