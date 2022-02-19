package expression;

import java.util.HashMap;
import java.util.Map;

public interface AllExpressions extends Expression, TripleExpression, BigIntegerExpression {
    int UNARY_OPERATION_PRIORITY = 0;
    int MAX_PRIORITY = 4;
    int MIN_PRIORITY = 1;

    Map<String, Integer> priorities = new HashMap<>() {{
        put("const", -1);
        put("var", -1);
        put("unary", 0);
        put("**", 1);
        put("//", 1);
        put("*", 2);
        put("/", 2);
        put("+", 3);
        put("-", 3);
        put("min", 4);
        put("max", 4);
    }};

    String getSign();
}
