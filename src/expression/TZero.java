package expression;

import java.math.BigInteger;

public class TZero extends UnaryOperation {
    public TZero(AllExpressions operand) {
        super(operand);
    }

    @Override
    public String getUnary() {
        return "t0";
    }

    @Override
    protected BigInteger operation(BigInteger a) {
        return BigInteger.valueOf(Integer.numberOfTrailingZeros(a.intValue()));
    }

    @Override
    protected int operation(int a) {
        return Integer.numberOfTrailingZeros(a);
    }
}
