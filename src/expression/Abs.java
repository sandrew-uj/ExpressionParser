package expression;

import expression.exceptions.OverflowException;

import java.math.BigInteger;

public class Abs extends UnaryOperation {
    public Abs(AllExpressions operand) {
        super(operand);
    }

    @Override
    public String getUnary() {
        return "abs";
    }

    @Override
    protected BigInteger operation(BigInteger a) {
        return a.multiply(BigInteger.valueOf(-1));
    }

    @Override
    protected int operation(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return a > 0 ? a : -a;
    }
}
