package expression;

import expression.exceptions.OverflowException;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    protected int operation(int a, int b) {
        if (b < 0 && Integer.MAX_VALUE + b < a || b > 0 && Integer.MIN_VALUE + b > a) {
            throw new OverflowException();
        }
        return a - b;
    }
}
