package expression;

import java.math.BigInteger;

public class Variable implements AllExpressions {
    public final String var;
    private final int hash;

    public Variable(String var) {
        this.var = var;
        hash = var.hashCode();
    }

    @Override
    public String getSign() {
        return "var";
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public String toString() {
        return var;
    }

    @Override
    public String toMiniString() {
        return var;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return var.equals(variable.var);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return switch (var) {
            case "x" -> x;
            case "y" -> y;
            case "z" -> z;
            default -> 0;
        };
    }

    @Override
    public BigInteger evaluate(BigInteger x) {
        return x;
    }
}
