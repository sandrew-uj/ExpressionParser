package expression.exceptions;

public abstract class InvalidException extends ParsingException {
    protected final String expected;

    public InvalidException(String message, String expected) {
        super(message);
        this.expected = expected;
    }

    public InvalidException(String message) {
        super(message);
        this.expected = null;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + (expected != null ? ": expected = " + expected: "");
    }
}
