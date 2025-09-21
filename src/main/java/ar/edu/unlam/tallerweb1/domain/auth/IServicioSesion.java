package ar.edu.unlam.tallerweb1.domain.auth;

import ar.edu.unlam.tallerweb1.model.Usuario;

public interface IServicioSesion {
    void setTiempoSesion(int tiempo);

    void eliminarSesion();

    public void setAtributoEnSesion(String clave, Object valor);

    public Object getAtributoDeSesion(String clave);

}
