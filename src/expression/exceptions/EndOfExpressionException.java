package expression.exceptions;

public class EndOfExpressionException extends ParsingException {
    public EndOfExpressionException(String message) {
        super(message);
    }
}
