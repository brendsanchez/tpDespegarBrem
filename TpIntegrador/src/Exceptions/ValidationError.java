package Exceptions;

public class ValidationError extends RuntimeException {
    public ValidationError(String mensaje) {
        super(mensaje);
    }
}
