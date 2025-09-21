package ar.edu.unlam.tallerweb1.domain.exceptions;

public class FileValidationException extends RuntimeException {
    public FileValidationException(String errorMessage) {
        super(errorMessage);
    }
}
