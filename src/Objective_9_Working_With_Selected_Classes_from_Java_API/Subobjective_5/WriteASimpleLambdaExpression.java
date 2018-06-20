package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_5;

import java.util.HashMap;
import java.util.Map;

public class WriteASimpleLambdaExpression {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

    public static void main(String[] args) {
        System.out.println("Chapter 9.5 - Write a simple Lambda Expression that consumes a Lambda Predicate Expression");

        /**
         * Introduction to Lambda Expressions:
         * -----------------------------------
         *
         * A Lambda expression
         *  - allows to treat functionality as method argument, or code as data.
         *  - is similar to anonymous classes, except that
         *    ==> can only be declared as an implementation of a functional interface
         *    ==> can only be used in a method with a functional interface as an argument
         *
         *  - consists of 3 elements:
         *      + Comma separated list of formal parameters enclosed in ( )
         *      + The arrow token '->'
         *      + A body which consists of a single expression or a statement block
         *
         * Example: (Integer i, Integer j) -> { return i == j; }
         * */

        /** Lambda Predicate Example */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(2, 2);
        //compareEquality(map, (Integer i, Integer j) -> { return i == j; });
        //compareEquality(map, (i, j) -> i == j);
        //compareEquality(map, (Integer i, Integer j) -> i.equals(j));
        compareEquality(map, Integer::equals);

        /** Question 2: Which of the following is a valid declaration of a 'ValueComparator' variable ?
         * A) ValueComparator comparator = (i,j) -> i > j;
         * B) ValueComparator comparator = (int i, int j) -> i > j;
         * C) ValueComparator comparator = (Integer i, Integer j) -> return i > j;
         * D) None of the above.
         * */

        // Answer: Since B is using the wrong parameter types int, and C does not make a proper use of a statement block,
        //         the correct answer is A.
    }

    public static void compareEquality(Map<Integer, Integer> map, NumberComparator comparator) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(comparator.compare(entry.getKey(), entry.getValue()))
                System.out.println(entry);
        }
    }

    /** Question 1: Which of the following is a valid invocation of 'doSomething()'? */
    public static void doSomething(Boolean check) {
    }
    /**
     * A) doSomething( () -> true);
     * B) doSomething( () -> return true);
     * C) doSomething( () -> { return new Boolean(true); });
     * D) None of the above.
     *
     * */

        // Answer: A lambda expression can only be used in methods that expect a functional interface.
        //         However, doSomething() does not expect a functional interface! Therefor answer D is correct.
}

interface NumberComparator {
    boolean compare(Integer first, Integer second);
}

interface ValueComparator {
    public boolean compare(Integer first, Integer second);
}