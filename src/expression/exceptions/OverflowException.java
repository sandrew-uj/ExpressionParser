package expression.exceptions;

public class OverflowException extends ArithmeticException {
    @Override
    public String getMessage() {
        return "overflow";
    }
}
