package expression;

import java.math.BigInteger;

public class Subtract extends BinaryOperation {
    public Subtract(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public String getSign() {
        return "-";
    }

    @Override
    protected boolean isCommutative() {
        return false;
    }

    @Override
    protected boolean isAssociative() {
        return true;
    }

    @Override
    protected BigInteger operation(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    protected int operation(int a, int b) {
        return a - b;
    }
}
