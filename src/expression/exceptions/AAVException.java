package expression.exceptions;

public class AAVException extends ArithmeticException {
    @Override
    public String getMessage() {
        return "Variables aren't in area of allowable values";
    }
}
