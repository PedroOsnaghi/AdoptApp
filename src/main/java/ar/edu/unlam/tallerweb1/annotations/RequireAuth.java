package ar.edu.unlam.tallerweb1.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
// @Retention define el tiempo de vida de la anotacion
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireAuth {
}