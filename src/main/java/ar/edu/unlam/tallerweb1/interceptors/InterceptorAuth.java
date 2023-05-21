package ar.edu.unlam.tallerweb1.interceptors;

import ar.edu.unlam.tallerweb1.annotations.RequireAuth;
import ar.edu.unlam.tallerweb1.domain.auth.IServicioAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptorAuth extends HandlerInterceptorAdapter {

    IServicioAuth servicioAuth;

    @Autowired
    public InterceptorAuth(IServicioAuth servicioAuth) {
        super();
        this.servicioAuth = servicioAuth;
    }

    //El handler es el controlador o metodo que se invoca para manejar un request
    // HandlerMethod es una subclase de Handler que representa un metodo de un controlador
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            // obtener el metodo en el que se uso la anotacion
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            // checkear si tiene la anotacion de RequireAuthentication
            RequireAuth requireAuthentication = handlerMethod.getMethodAnnotation(RequireAuth.class);

            // sin anotacion no hay restriccion
            if (requireAuthentication == null) {
                return true;
            }

            boolean usuarioLoggeado = servicioAuth.usuarioLoggeado();

            if (!usuarioLoggeado) {

                // como no usamos un view resolver, tenemos que hacer el redirect a mano
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/login");
                return false;
            }

        }
        return true;
    }

}

