package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.IServicioIngresarMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Date;

@Controller
public class ControladorMascota {

    private IServicioIngresarMascota iServicioIngresarMascota;
    @Autowired
    public ControladorMascota(IServicioIngresarMascota iServicioIngresarMascota)
    {
        this.iServicioIngresarMascota = iServicioIngresarMascota;
    }
    @RequestMapping(path = "/new-mascot", method = RequestMethod.GET)
    public ModelAndView nuevaMascota() {
        ModelMap model = new ModelMap();
       // model.put("datosIngresoMascota", new DatosIngresoMascota());
        return new ModelAndView("new-mascot");
    }

    public ModelAndView ingresarMascota(String nombre, Enum tipo, Date nacimiento , String obs , File foto ) {

        ModelMap model = new ModelMap();
        String viewName = "";

        if (this.iServicioIngresarMascota.sonValidos(nombre, tipo,  nacimiento , obs ,  foto)) {

            model.put("msg", "Mascota Ingresada");
            viewName = "profile";


        } else {
            model.put("msg", "No se Pudo Ingresar La mascota");
            viewName = "new-mascot";



        }
        return new ModelAndView(viewName, model);
    }


}
