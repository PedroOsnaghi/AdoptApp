package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.IServicioIngresarMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMascota {
    @Autowired
    private IServicioIngresarMascota iServicioIngresarMascota;
    @Autowired
    public ControladorMascota(IServicioIngresarMascota iServicioIngresarMascota)
    {
        this.iServicioIngresarMascota = iServicioIngresarMascota;
    }

    @RequestMapping("/new-mascot")
    public ModelAndView irANewMascot() {

        ModelMap modelo = new ModelMap();

        modelo.put("datosIngresoMascota",new DatosIngresoMascota());

        return new ModelAndView("new-mascot", modelo);
    }


    @RequestMapping(path = "/ingresar-mascota", method=RequestMethod.POST)
    public ModelAndView ingresarMascota(@ModelAttribute DatosIngresoMascota datosIngresoMascota) {
        ModelMap model = new ModelMap();

        String viewName = "";

        if (this.iServicioIngresarMascota.sonValidos(datosIngresoMascota.getNombre(),datosIngresoMascota.getTipo(),
                datosIngresoMascota.getRaza(), datosIngresoMascota.getPeso(), datosIngresoMascota.getNacimiento() , datosIngresoMascota.getObs() ,  datosIngresoMascota.getFoto()))
        {
            model.put("msg", "Mascota Ingresada");
            viewName = "profile";

        } else {
            model.put("msg", "No se Pudo Ingresar La mascota, ingrese los campos mínimos");
            model.put("datosIngresoMascota",new DatosIngresoMascota());
            viewName = "new-mascot";

        }
        return new ModelAndView(viewName, model);
    }


}
