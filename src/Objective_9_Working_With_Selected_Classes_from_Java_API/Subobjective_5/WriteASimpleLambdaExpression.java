package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class WriteASimpleLambdaExpression {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

    // https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html

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
        compareEquality(map, (Integer i, Integer j) -> { return i == j; });
        compareEquality(map, (i, j) -> i == j);
        compareEquality(map, (Integer i, Integer j) -> i.equals(j));
        compareEquality(map, Integer::equals);

        // ----------------------------------------------------------------------------------

        /** Question 1: Which of the following is a valid declaration of a 'ValueComparator' variable ?
         * A) ValueComparator comparator = (i,j) -> i > j;
         * B) ValueComparator comparator = (int i, int j) -> i > j;
         * C) ValueComparator comparator = (Integer i, Integer j) -> return i > j;
         * D) None of the above.
         * */

        // Answer: Since B is using the wrong parameter types int, and C does not make a proper use of a statement block,
        //         the correct answer is A.

        // ----------------------------------------------------------------------------------

        Employee e = new Employee();
        e.id = 3;
        check(e, p -> p.id < 10);
    }

    public static void compareEquality(Map<Integer, Integer> map, NumberComparator comparator) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(comparator.compare(entry.getKey(), entry.getValue()))
                System.out.println(entry);
        }
    }

    public static void check(Employee e, Predicate<Employee> pr) {
        String result = pr.test(e) ? "match" : "no match";
        System.out.println(result);
    }

    // ----------------------------------------------------------------------------------

    /** Question 2: Which of the following is a valid invocation of 'doSomething()'? */
    public static void doSomething(Boolean check) { }

    /**
     * A) doSomething( () -> true);
     * B) doSomething( () -> return true);
     * C) doSomething( () -> { return new Boolean(true); });
     * D) None of the above.
     *
     * */

        // Answer: A lambda expression can only be used in methods that expect a functional interface.
        //         However, doSomething() does not expect a functional interface! Therefor answer D is correct.



    /** Functional Interface:
     *  ---------------------
     *
     *  - Instances of functional interfaces can be created with lambda expressions, method references, or constructor references.
     *  - A functional interface has exactly ONE abstract method.
     *
     *  - Since default methods have an implementation, they are not abstract.
     *      If an interface declares an abstract method overriding one of the public methods of java.lang.Object,
     *      it does NOT count toward the interface's abstract method count since any implementation of the interface
     *      will have an implementation from java.lang.Object or ELSEWHERE.
     *
     * */

    // ----------------------------------------------------------------------------------

    Predicate<Integer> p;

    /** Question 3: Which of the following is the functional method of a java.util.function.Predicate<T> interface?
     *
     * A) Boolean accept(T t)
     * B) Boolean apply(T t)
     * C) T get()
     * D) boolean test(T t)
     * */

    // Answer: One of the functional methods declared in the Predicate interface is test(T t) with return type boolean. -> answer D

    // ----------------------------------------------------------------------------------

    /** Question 4: Which of the following can be considered as a functional interface?
     *
     * A) public interface Movable { static void print() {  } void move(); }
     * B) @FunctionalInterface public interface Movable {}
     * C) @FunctionalInterface public interface Movable { default void move; }
     * D) public interface Movable { static void move(); }
     * */

    /** Answer: Functional interfaces provide target types for lambda expressions and method references. Each functional interface
     * has a SINGLE ABSTRACT METHOD (SAM), called the functional method for that functional interface, to which
     * the lambda expressions' parameter and return types are matched or adapted.
     * It can also include other methods such as static and default methods, however they must not be abstract (applies for all interfaces!).
     *
     * The correct answer is A as it satisfies all requirements for functional interfaces.
      */
}

interface NumberComparator {
    boolean compare(Integer first, Integer second);
}

interface ValueComparator {
    public boolean compare(Integer first, Integer second);
}

class Employee {
    int id;
}