package ar.edu.unlam.tallerweb1.domain.exceptions;

public class PostCreationException extends RuntimeException {

    public PostCreationException(String errorMessage){
        super(errorMessage);
    }
}
