package expression;

import java.math.BigInteger;

public class Const implements AllExpressions {
    private final Number value;

    public Const(final int value) {
        this.value = value;
    }

    public Const(final BigInteger value) {
        this.value = value;
    }

    @Override
    public String getSign() {
        return "const";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Const aConst = (Const) o;
        return aConst.value.equals(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public String toMiniString() {
        return value.toString();
    }

    @Override
    public int evaluate(final int x) {
        return value.intValue();
    }

    @Override
    public int evaluate(final int x, final int y, final int z) {
        return value.intValue();
    }

    @Override
    public BigInteger evaluate(final BigInteger x) {
        return (BigInteger) value;
    }
}
