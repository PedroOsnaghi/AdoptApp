package ar.edu.unlam.tallerweb1.domain.exceptions;

public class NotFoundPostExcption extends RuntimeException {

    public NotFoundPostExcption(String errMessage){
        super(errMessage);
    }
}
