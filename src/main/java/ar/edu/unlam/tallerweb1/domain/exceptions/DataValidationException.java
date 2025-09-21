package ar.edu.unlam.tallerweb1.domain.exceptions;

public class DataValidationException extends RuntimeException{

    public DataValidationException(String errorMessage){
        super(errorMessage);
    }

}
