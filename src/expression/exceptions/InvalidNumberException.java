package expression.exceptions;

public class InvalidNumberException extends InvalidException {
    public InvalidNumberException(String message, String expected) {
        super(message, expected);
    }
}
