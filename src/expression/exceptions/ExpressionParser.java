package expression.exceptions;

import expression.*;
import expression.parser.BaseParser;
import expression.parser.CharSource;
import expression.parser.StringSource;

import static expression.AllExpressions.*;

public final class ExpressionParser extends BaseParser implements TripleParser {
    private int balance = 0;

    public ExpressionParser() {
        super();
    }

    public TripleExpression parse(final String source) {
        TripleExpression result = null;
        try {
            result = parse(new StringSource(source));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (ParsingException e) {
            throw error("Parsing error: " + e.getMessage());
        }

        return result;
    }

    public static TripleExpression parse(final CharSource source) throws ParsingException {
        return new ExpressionParser(source).parseExpression();
    }

    public ExpressionParser(final CharSource source) {
        super(source);
    }

    public AllExpressions parseExpression() throws ParsingException {
        final AllExpressions result = parsePriority(null, MAX_PRIORITY);
        skipWhitespace();
        if (balance != 0) {
            throw new NotACBSException("It's not a correct brace sequence");
        }
        if (result == null) {
            throw new NotAnExpressionException("It's not an expression");
        }
        if (eof()) {
            return result;
        }
        throw error("End of expression expected");
    }

    private AllExpressions parsePriority(AllExpressions firstOperand, int priority) throws ParsingException {
        String op = "";
        skipWhitespace();
        if (firstOperand != null) {
            if (priority == priorities.get("min") && take('m')) {
                if (take('i') && take('n') && !Character.isLetterOrDigit(current())) {
                    op = "min";
                } else if (take('a') && take('x') && !Character.isLetterOrDigit(current())) {
                    op = "max";
                } else {
                    throw new InvalidOperationException("Invalid operation", "min/max");
                }
            } else if (priority == priorities.get("+")) {
                if(take('+')) {
                    op = "+";
                } else if (take('-')) {
                    op = "-";
                }
            } else if (priority <= priorities.get("*")) {
                if (take('*')) {
                    if (take('*')) {
                        op = "**";
                    } else if (priority == priorities.get("*")){
                        op = "*";
                    } else {
                        takePrev();
                    }
                } else if (take('/')) {
                    if (take('/')) {
                        op = "//";
                    } else if (priority == priorities.get("/")){
                        op = "/";
                    } else {
                        takePrev();
                    }
                }
            }
        }
        priority = priorities.getOrDefault(op, priority);

        skipWhitespace();
        AllExpressions operand;
        if (priority > MIN_PRIORITY && (firstOperand == null || !op.isEmpty())) {
            operand = parsePriority(null, priority - 1);
        } else {
            operand = firstOperand == null || !op.isEmpty() ? parse1stPriority() : null;
        }

        if(firstOperand == null && operand != null) {
            return parsePriority(operand, priority);
        } else if (operand != null) {
            return switch (op) {
                case "*" -> parsePriority(new CheckedMultiply(firstOperand, operand), priority);
                case "/" -> parsePriority(new CheckedDivide(firstOperand, operand), priority);
                case "+" -> parsePriority(new CheckedAdd(firstOperand, operand), priority);
                case "-" -> parsePriority(new CheckedSubtract(firstOperand, operand), priority);
                case "min" -> parsePriority(new Min(firstOperand, operand), priority);
                case "max" -> parsePriority(new Max(firstOperand, operand), priority);
                case "**" -> parsePriority(new Pow(firstOperand, operand), priority);
                case "//" -> parsePriority(new Log(firstOperand, operand), priority);
                default -> throw new InvalidSymbolException("Invalid symbol");
            };
        } else if (!op.isEmpty()) {
            throw new EndOfExpressionException("End of expression expected");
        } else {
            if (priority == MAX_PRIORITY && take(')')) {
                balance--;
            }
            return firstOperand;
        }
    }

    private AllExpressions parse1stPriority() throws ParsingException {
        skipWhitespace();
        char minus = test('-') ? take() : 0;
        if (between('0', '9')) {
            return parseConst(minus);
        } else if (minus != 0) {
            return new CheckedNegate(parse1stPriority());
        } else if (take('l') && take('0')) {
            if (Character.isLetterOrDigit(current())) {
                throw new InvalidOperationException("Invalid operation", "l0");
            }
            return new LZero(parse1stPriority());
        } else if (take('t') && take('0')) {
            if (Character.isLetterOrDigit(current())) {
                throw new InvalidOperationException("Invalid operation", "t0");
            }
            return new TZero(parse1stPriority());
        } else if (test('x') || test('y') || test('z')) {
            return parseVariable();
        } else if (take('(')) {
            balance++;
            return parsePriority(null, 4);
        } else if (eof() || test(')') || test('m')) {
            return null;
        } else if (take('a')) {
            if (take('b') && take('s') && !Character.isLetterOrDigit(current())) {
                return new Abs(parse1stPriority());
            }
            throw new InvalidOperationException("Invalid operation", "abs");
        }
        throw new InvalidSymbolException("Invalid symbol exception");
    }

    private AllExpressions parseConst(char first) throws InvalidNumberException {
        final StringBuilder sb = new StringBuilder();
        if (first != 0) {
            sb.append(first);
        }
        takeInteger(sb);
        try {
            return new Const(Integer.parseInt(sb.toString()));
        } catch (final NumberFormatException e) {
            throw new InvalidNumberException("Invalid number", "integer");
        }
    }

    private void takeInteger(final StringBuilder sb) {
        while (between('0', '9')) {
            sb.append(take());
        }
    }

    private AllExpressions parseVariable() {
        return new Variable(Character.toString(take()));
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(current())) {
            take();
        }
    }
}