package ar.edu.unlam.tallerweb1.domain.exceptions;

public class PostChangeException extends RuntimeException {
    private final String errorCode;

    public PostChangeException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return this.errorCode;
    }
}
