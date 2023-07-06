package ar.edu.unlam.tallerweb1.domain.exceptions;

public class NotFoundUserExcption extends RuntimeException {

    public NotFoundUserExcption(String errMessage){
        super(errMessage);
    }
}
