package expression;

import java.math.BigInteger;

public class UnaryMinus extends UnaryOperation {
    public UnaryMinus(AllExpressions operand) {
        super(operand);
    }

    @Override
    public String getUnary() {
        return "-";
    }

    @Override
    protected BigInteger operation(BigInteger a) {
        return a.multiply(BigInteger.valueOf(-1));
    }

    @Override
    protected int operation(int a) {
        return -a;
    }
}
