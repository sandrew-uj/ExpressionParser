package expression;

import java.math.BigInteger;

public class Max extends BinaryOperation {
    public Max(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public String getSign() {
        return "max";
    }

    @Override
    protected boolean isCommutative() {
        return true;
    }

    @Override
    protected boolean isAssociative() {
        return false;
    }

    @Override
    protected BigInteger operation(BigInteger a, BigInteger b) {
        return a.max(b);
    }

    @Override
    protected int operation(int a, int b) {
        return a > b ? a : b;
    }


}
