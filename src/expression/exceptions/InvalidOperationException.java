package expression.exceptions;

public class InvalidOperationException extends InvalidException {
    public InvalidOperationException(String message, String expected) {
        super(message, expected);
    }
}
