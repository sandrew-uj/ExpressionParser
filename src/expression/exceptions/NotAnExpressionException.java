package expression.exceptions;

public class NotAnExpressionException extends ParsingException {
    public NotAnExpressionException(String message) {
        super(message);
    }
}
