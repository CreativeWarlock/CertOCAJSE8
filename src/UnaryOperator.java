public class UnaryOperator {



    public static void main(String[] args) {
        System.out.println("Chapter XXX - Unary Operator");

        unaryMethod1();
        unaryMethod2();
        testPostFixBeforePrefixOperator();
        leftToRightThenPrecedence();
    }

    private static void unaryMethod1() {
        int a = 0, b = 1;

        if (a++ == 1)
            --b;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private static void unaryMethod2() {
        int a = 0, b = 1;

        if (++a == 1)
            b = 0;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private static void testPostFixBeforePrefixOperator() {
        System.out.println("PostFixBeforePrefixOperator: ");

        int a = 10;
        a = --a + a++;

        System.out.println("a: " + a);
    }

    private static void leftToRightThenPrecedence() {
        int x;

        System.out.println("LeftToRightThenPrecedence: ");
        x = 10; System.out.println("x++ * ++x -> " + x++ * ++x);
        x = 10; System.out.println("++x * x++ -> " + ++x * x++);
    }

}
