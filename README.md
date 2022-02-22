# ExpressionParser
## Задача №1 (реализация классов для выражений):
1. Разработайте классы `Const`, `Variable`, `Add`, `Subtract`, `Multiply`, `Divide` для вычисления выражений с одной переменной в типе `int` (интерфейс `Expression`), а также `BigInteger` (интерфейс `BigIntegerExpression`).

2. Классы должны позволять составлять выражения вида
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).evaluate(5)
``` 
При вычислении такого выражения вместо каждой переменной подставляется значение, переданное в качестве параметра методу `evaluate`. Таким образом, результатом вычисления приведенного примера должно стать число 7.

3. Метод `toString` должен выдавать запись выражения в полноскобочной форме. Например
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

4. Сложный вариант. Метод `toMiniString` (интерфейс `ToMiniString`) должен выдавать выражение с минимальным числом скобок. Например
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

5. Реализуйте метод equals, проверяющий, что два выражения совпадают. Например,
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

6. Для тестирования программы должен быть создан класс `Main`, который вычисляет значение выражения x\*x−2\*x+1, для x, заданного в командной строке.
При выполнении задания следует обратить внимание на:
* Выделение общего интерфейса создаваемых классов.
* Выделение абстрактного базового класса для бинарных операций.

## Задача №2 (реализация парсера):
1. Доработайте предыдущую задачу, так чтобы выражение строилось по записи вида
x \* (x - 2)\*x + 1
2. В записи выражения могут встречаться:
* бинарные операции: умножение \*, деление /, сложение \+ и вычитание \-;
* унарный минус \-;
* переменные x, y и z;
* целочисленные константы в десятичной системе счисления, помещающиеся в 32-битный знаковый целочисленный тип;
* круглые скобки для явного обозначения приоритета операций;
* произвольное число пробельных символов в любом месте, не влияющем на однозначность понимания формулы (например, между операцией и переменной, но не внутри констант).
3. Приоритет операций, начиная с наивысшего
  1. унарный минус;
  2. умножение и деление;
  3. сложение и вычитание.
4. Разбор выражений рекомендуется производить методом рекурсивного спуска.
* Алгоритм должен работать за линейное время.
* Лексический анализ (токенизация) не требуется.
5. Дополнительно реализуйте бинарные операции (максимальный приоритет):
* `**` – возведение в степень, `2 ** 3` равно 8;
* `//` – логарифм, `10 // 2` равно 3.
