# ExpressionParser
Arithmetic expressions parser with exceptions
Задача:
1. ol Разработайте классы Const, Variable, Add, Subtract, Multiply, Divide для вычисления выражений с одной переменной в типе int (интерфейс Expression).
1. ol Классы должны позволять составлять выражения вида
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).evaluate(5)
```

При вычислении такого выражения вместо каждой переменной подставляется значение, переданное в качестве параметра методу evaluate. Таким образом, результатом вычисления приведенного примера должно стать число 7.
1. ol Метод toString должен выдавать запись выражения в полноскобочной форме. Например
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toString()
```

должен выдавать ((2 * x) - 3).
1. ol Сложный вариант. Метод toMiniString (интерфейс ToMiniString) должен выдавать выражение с минимальным числом скобок. Например
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toMiniString()
```

должен выдавать 2 * x - 3.
1. ol Реализуйте метод equals, проверяющий, что два выражения совпадают. Например,
```
new Multiply(new Const(2), new Variable("x"))
    .equals(new Multiply(new Const(2), new Variable("x")))
```            
должно выдавать true, а
```
new Multiply(new Const(2), new Variable("x"))
    .equals(new Multiply(new Variable("x"), new Const(2)))
```            
должно выдавать false.
1. ol Для тестирования программы должен быть создан класс Main, который вычисляет значение выражения x2−2x+1, для x, заданного в командной строке.
При выполнении задания следует обратить внимание на:
* Выделение общего интерфейса создаваемых классов.
* Выделение абстрактного базового класса для бинарных операций.
