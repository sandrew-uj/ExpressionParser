package expression;

import expression.exceptions.AAVException;

import java.math.BigInteger;

public class Pow extends BinaryOperation {
    public Pow(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public String getSign() {
        return "**";
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
        var mul = new CheckedMultiply(new Variable("x"), new Variable("y"));
        int result = 1;
        if (b < 0 || a == b && a == 0) {
            throw new AAVException();
        }
        while(b != 0) {
            if (b % 2 == 1) {
                result = mul.evaluate(result, a, 1);
            }
            b /= 2;
            if (b > 0) {
                a = mul.evaluate(a, a, 1);
            }

        }
        return result;
    }
}
