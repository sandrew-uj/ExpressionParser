package expression.exceptions;

public class DivisionByZeroException extends ArithmeticException {
    @Override
    public String getMessage() {
        return "division by zero";
    }
}
