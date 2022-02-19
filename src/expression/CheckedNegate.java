package expression;

import expression.exceptions.OverflowException;

public class CheckedNegate extends UnaryMinus {

    public CheckedNegate(AllExpressions operand) {
        super(operand);
    }

    @Override
    protected int operation(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return -a;
    }
}
