package expression;

import expression.exceptions.AAVException;

import java.math.BigInteger;

public class Log extends BinaryOperation {
    public Log(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public String getSign() {
        return "//";
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
        return a.multiply(b);
    }

    @Override
    protected int operation(int a, int b) {
        var div = new CheckedDivide(new Variable("x"), new Variable("y"));
        int result = -1;
        if (b == 1) {
            throw new AAVException();
        }
        if (a <= 0 || b <= 0) {
            throw new AAVException();
        }
        while(a > 0) {
            a = div.evaluate(a, b, 1);
            result++;
        }
        return result;
    }
}
