package ar.edu.unlam.tallerweb1.domain.exceptions;

public class SendingMessageException extends RuntimeException{

    public SendingMessageException(String errorMessage){
        super(errorMessage);
    }
}
