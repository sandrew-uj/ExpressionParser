package expression;

import java.math.BigInteger;

public class LZero extends UnaryOperation {
    public LZero(AllExpressions operand) {
        super(operand);
    }

    @Override
    public String getUnary() {
        return "l0";
    }

    @Override
    protected BigInteger operation(BigInteger a) {
        return BigInteger.valueOf(Integer.numberOfLeadingZeros(a.intValue()));
    }

    @Override
    protected int operation(int a) {
        return Integer.numberOfLeadingZeros(a);
    }
}
