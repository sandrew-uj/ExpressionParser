package expression;

import java.math.BigInteger;

public class Divide extends BinaryOperation {
    public Divide(final AllExpressions firstOperand, final AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }
    @Override
    public String getSign() {
        return "/";
    }

    @Override
    protected boolean isCommutative() {
        return false;
    }

    @Override
    protected boolean isAssociative() {
        return false;
    }

    @Override
    protected BigInteger operation(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

    @Override
    protected int operation(int a, int b) {
        return a / b;
    }
}
