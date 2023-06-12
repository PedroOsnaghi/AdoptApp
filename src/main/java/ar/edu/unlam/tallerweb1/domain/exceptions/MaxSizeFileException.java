package ar.edu.unlam.tallerweb1.domain.exceptions;

public class MaxSizeFileException extends RuntimeException{

    public MaxSizeFileException(String errorMessage){
        super(errorMessage);
    }
}
