package expression.parser;

public class StringSource implements CharSource {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public boolean hasPrev() {
        return pos > 0;
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public char prev() {
        return data.charAt(--pos-1);
    }

    @Override
    public IllegalArgumentException error(final String message) {
        return new IllegalArgumentException(pos + ": " + message);
    }
}

