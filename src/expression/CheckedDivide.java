package expression;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;

public class CheckedDivide extends Divide {
    public CheckedDivide(AllExpressions firstOperand, AllExpressions secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    protected int operation(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException();
        }
        return a / b;
    }
}
