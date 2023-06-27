package ar.edu.unlam.tallerweb1.domain.exceptions;

public class SolicitudException extends RuntimeException{

    public SolicitudException(String errorMessage){
        super(errorMessage);
    }
}
