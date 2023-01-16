package my.bank.usecase.exception;

public class ServiceErrorException extends RuntimeException {

    public ServiceErrorException(String message) {
        super(message);
    }
}
