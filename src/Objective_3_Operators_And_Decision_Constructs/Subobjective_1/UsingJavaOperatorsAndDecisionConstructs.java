package Objective_3_Operators_And_Decision_Constructs.Subobjective_1;

public class UsingJavaOperatorsAndDecisionConstructs {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html

    public static void main(String[] args) {
        System.out.println("Chapter 3.1 - Using Operators and DecisionConstructs");

        /**
         * Operators and precedence:
         * -------------------------
         *
         * Postfix          expr++ expr--
         * Unary            ++expr --expr +expr -expr ~ !
         *
         * Multiplicative   * / %
         * Additive         + -
         *
         * Shift            << >> >>>
         *
         * Relational       < > <= >= instanceof
         * Equality         == !=
         *
         * Bitwise AND      &
         * Bitwise excl. OR ^
         * Bitwise incl. OR |
         *
         * Locical AND      &&
         * Logical OR       ||
         *
         * Ternary          ? :
         *
         * Assignment       = += -= *= /= %= &= ^= |= <<= >>= >>>=
         *----------------------------
         *
         * Important statements:
         * ---------------------
         * - Operators that appear on the same precedence are evaluated from left to right
         * - Exception: Assignment operators are evaluated from right to left!
         * - Operator precedence may be overridden by ( )
         *
         * Example:
         * */

        int i1 = 1, i2 = 2;
        int i = i2 = i1;
        System.out.println("i: " + i);

        i1 = 1; i2 = 2;
        i = i2 * ++i1 * i1;
        System.out.println("i: " + i);

        boolean b1 = false, b2 = true;
        boolean b = (!b1 || !b2) && b1;
        System.out.println("b: " + b);

        i = 4 << 4 / 2; // careful...
        System.out.println("i: " + i);

    }
}