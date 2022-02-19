package expression;

import java.math.BigInteger;

public abstract class BinaryOperation implements AllExpressions {
    private final AllExpressions firstOperand, secondOperand;

    public BinaryOperation(final AllExpressions firstOperand, final AllExpressions secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    protected abstract boolean isCommutative();

    protected abstract boolean isAssociative();

    protected abstract BigInteger operation(BigInteger a, BigInteger b);

    protected abstract int operation(int a, int b);

    @Override
    public String toString() {
        return "(" + firstOperand + " " + getSign() + " " + secondOperand + ")";
    }

    @Override
    public int hashCode() {
        return firstOperand.hashCode() * 1023 + getSign().hashCode() + secondOperand.hashCode() * 777;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BinaryOperation that = (BinaryOperation) o;
        return firstOperand.equals(that.firstOperand) && secondOperand.equals(that.secondOperand);
    }


    @Override
    public int evaluate(final int x) {
        return operation(firstOperand.evaluate(x), secondOperand.evaluate(x));
    }

    @Override
    public int evaluate(final int x, final int y, final int z) {
        return operation(firstOperand.evaluate(x, y, z), secondOperand.evaluate(x, y, z));
    }

    @Override
    public BigInteger evaluate(final BigInteger x) {
        return operation(firstOperand.evaluate(x), secondOperand.evaluate(x));
    }

    @Override
    public String toMiniString() {
        String result;
        int first = priorities.get(firstOperand.getSign());
        int current = priorities.get(getSign());
        int second = priorities.get(secondOperand.getSign());

        if (first > current) {
            result = "(" + firstOperand.toMiniString() + ")";
        } else {
            result = firstOperand.toMiniString();
        }

        result += " " + getSign() + " ";
        int sign = current - second;

        if (sign < 0 || second > UNARY_OPERATION_PRIORITY && sign == 0 &&
           (!((BinaryOperation)secondOperand).isAssociative() && !secondOperand.getSign().equals(getSign()) || !isCommutative())) {
            result += "(" + secondOperand.toMiniString() + ")";
        } else {
            result += secondOperand.toMiniString();
        }

        return result;
    }
}
