package my.bank.usecase.exception;

public class UserNotFoundException extends ServiceErrorException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
