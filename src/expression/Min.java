package expression;


import java.math.BigInteger;

public class Min extends BinaryOperation {
    public Min(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public String getSign() {
        return "min";
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
        return a.min(b);
    }

    @Override
    protected int operation(int a, int b) {
        return a < b ? a : b;
    }
}
