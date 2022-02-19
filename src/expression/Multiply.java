package expression;

import java.math.BigInteger;

public class Multiply extends BinaryOperation {
    public Multiply(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public String getSign() {
        return "*";
    }

    @Override
    protected boolean isCommutative() {
        return true;
    }

    @Override
    protected boolean isAssociative() {
        return true;
    }

    @Override
    protected BigInteger operation(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    protected int operation(int a, int b) {
        return a * b;
    }
}
