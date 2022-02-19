package expression.parser;

public interface CharSource {
    boolean hasNext();
    boolean hasPrev();
    char next();
    char prev();
    IllegalArgumentException error(final String message);
}

