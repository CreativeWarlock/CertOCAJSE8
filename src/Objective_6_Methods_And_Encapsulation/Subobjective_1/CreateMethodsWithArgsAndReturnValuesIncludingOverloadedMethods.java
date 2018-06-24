package Objective_6_Methods_And_Encapsulation.Subobjective_1;

public class CreateMethodsWithArgsAndReturnValuesIncludingOverloadedMethods {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html

    public static void main(String[] args) {
        System.out.println("Chapter 6.1 - Create Methods with Arguments and Return Values - including Overloaded Methods");

        /**
         * Method Creation:
         * ----------------
         * - takes zero, one or more arguments, does something, then returns zero or one value
         *
         * Method Overloading:
         * -------------------
         * - In a class multiple methods have the same name
         * - must have method parameter different from one another
         * - may or may not define a different return type
         * - may or may not define different access levels
         * - can't be defined by only changing their return type or access modifiers or both
         *
         * Overloading Resolution:
         * -----------------------
         * 1. If there are multiple methods applicable to a method invocation,
         *    the ones with the most specific parameter types are chosen.
         *
         * 2. For the remainder:
         * 1st Phase: Performs overloading resolution
         *            without permitting boxing or unboxing conversion, or the use of varargs
         * 2nd Phase: Performs overloading resolution
         *            while allowing boxing and unboxing conversion, but still precluding the use of varargs#
         * 3rd Phase: allows overloading to be combined with
         *            boxing, unboxing and varargs
         *
         * IN SHORT:
         * ---------
         * Overloading conflicts are resolved based on this precedence order:
         * Most specific types -> Casting -> Boxing/Unboxing -> Varargs -> Compile Time Error
         *
         *
         * =========================================================================
         * ||        Difference between Overloaded and Overridden methods         ||
         * || --------------------------------------------------------------------||
         * ||                                                                     ||
         * || Property      | Overloaded method | Overridden method               ||
         * || --------------------------------------------------------------------||
         * || Access Level  |    Can Change     | Must SAME or LESS restrictive   ||
         * ||               |                   |                                 ||
         * || Argument List |    MUST Change    |       must NOT change           ||
         * ||               |                   |                                 ||
         * || Exceptions    |    Can change     |     Can throw new or broader    ||
         * ||               |                   |        runtime exceptions       ||
         * ||               |                   |                                 ||
         * || Return Type   |    Can change     | MUST NOT change except for      ||
         * ||               |                   |       covariant returns         ||
         * ||               |                   |                                 ||
         * || Invocation    |  Reference type   |         Object type             ||
         * ||               | determines which  |       determines which          ||
         * ||               |      version      |           version               ||
         * =========================================================================
         */

        short s1 = 1, s2 = 2;

        System.out.println("The result is: " + sum(s1,s2));

        printNumber(0);
    }

    // =================================================================================================================

    // Scenario for finding the appropriate overloading method invoked in the main method:

    static int sum(short... args) {
        System.out.println("Calculating the sum of short arguments");
        int sum = 0;
        for(short arg : args)
            sum += arg;

        return sum;
    }

    static int sum(Short arg1, Short arg2) {
        System.out.println("Calculating the sum of two Short arguments");
        return Short.valueOf(arg1) + Short.valueOf(arg2);
    }

    static int sum(int arg1, int arg2) {
        System.out.println("Calculating the sum of two int arguments");
        return arg1 + arg2;
    }

    static float sum(long arg1, long arg2) {
        System.out.println("Calculating the sum of two long arguments");
        return (int)(arg1 + arg2);
    }

    static float sum(float arg1, float arg2) {
        System.out.println("Calculating the sum of two float arguments");
        return arg1 + arg2;
    }//*/

    // =================================================================================================================

    void    myMethod() { }
    //boolean setMyOtherInt() { return true; } // Can not have setMyOtherInt() with 2 different return types:
    void    myMethod(double value) { }
    void    myMethod(int value) { }
    byte    myMethod(Integer value) { return 0; } // A changed Return type is independent from the method parameter list

    // =================================================================================================================

    /** Question: Which of the following methods is valid? */

    long square(int arg) {
        return arg * arg; // auto cast to long - valid
    }

    int unboxTheBoxed(int arg) {
        return new Integer(arg); // auto unboxing to int - valid
    }

    /** Question: What happens when the following methods are compiled and executed? */
    int multiply(int arg1, int arg2) {
        return arg1 * arg2;
    }

/*    void multiply(int arg1, int arg2) { // not valid! -> Not overloading: parameter signature is not different from 1st multiply
        System.out.println(arg1 * arg2);
    }*/

    /** Question: Which method will be invoked when calling printNumber(0)? */

    static void printNumber(long arg) {         // this one -> because casting is permitted before auto boxing!
        System.out.println("long : " + arg);
    }

    static void printNumber(Integer arg) {
        System.out.println("Integer : " + arg);
    }
}

/*
class Overloader {
    void print(String message) {
        System.out.println(message);
    }
    void print(String message) {
        System.out.println(message);
    }
}*/
