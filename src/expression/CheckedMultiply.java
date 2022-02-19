package expression;

import expression.exceptions.OverflowException;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    protected int operation(int a, int b) {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b ||
            a < 0 && b < 0 && a < Integer.MAX_VALUE / b ||
            a > 0 && b < 0 && b < Integer.MIN_VALUE / a ||
            a < 0 && b > 0 && a < Integer.MIN_VALUE / b) {
            throw new OverflowException();
        }
        return a * b;
    }
}
