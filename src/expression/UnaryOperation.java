package expression;

import java.math.BigInteger;

public abstract class UnaryOperation implements AllExpressions {
    protected final AllExpressions operand;
    private final int hash;

    public UnaryOperation(AllExpressions operand) {
        this.operand = operand;
        hash = (1023 * operand.hashCode() + getUnary().hashCode()) % Integer.MAX_VALUE;
    }

    protected abstract String getUnary();

    protected abstract BigInteger operation(BigInteger a);

    protected abstract int operation(int a);

    @Override
    public String getSign() {
        return "unary";
    }

    @Override
    public int evaluate(int x) {
        return operation(operand.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return operation(operand.evaluate(x, y, z));
    }

    @Override
    public BigInteger evaluate(BigInteger x) {
        return null;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnaryOperation that = (UnaryOperation) o;
        return operand.equals(that.operand);
    }

    @Override
    public String toString() {
        return getUnary() + "(" + operand + ")";
    }

    @Override
    public String toMiniString() {
        return getUnary() + (priorities.get(operand.getSign()) > UNARY_OPERATION_PRIORITY ? "(" : " ")
                + operand.toMiniString() + (priorities.get(operand.getSign()) > UNARY_OPERATION_PRIORITY ? ")" : "");
    }
}
