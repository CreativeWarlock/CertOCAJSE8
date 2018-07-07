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
         *            WITHOUT permitting boxing NOR unboxing conversion, NOR the use of varargs
         * 2nd Phase: Performs overloading resolution
         *            WITH boxing and unboxing conversion, but WITHOUT use of varargs
         * 3rd Phase: allows overloading to be combined with
         *            WITH boxing, unboxing and WITH use of varargs
         *
         * IN SHORT:
         * ---------
         * OVERLOADING CONFLICTS are resolved based on this precedence order:
         *
         *   Most specific types -> Casting -> Boxing/Unboxing -> Varargs -> Compile Time Error
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
         * ||               |                   |        RUNTIME exceptions       ||
         * ||               |                   |                                 ||
         * || Return Type   |    Can change     | must NOT change EXCEPT for      ||
         * ||               |                   |       covariant returns*        ||
         * ||               |                   |                                 ||
         * || Invocation    |  Reference type   |         Object type             ||
         * ||               | determines which  |       determines which          ||
         * ||               |      version      |           version               ||
         * =========================================================================
         */

        /** Covariant returns: Return type is a subtype of the method's return type that is inherited from a super class */

        short s1 = 1, s2 = 2;

        System.out.println("sum(s1, s2): " + sum(s1,s2));

        printNumber(0);

        int x = 1;
        int y = new RockLand().change(x);
        System.out.println("x+y: " + (x + y));
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
    void    myMethod(double value) { }
    void    myMethod(int value) { }
    byte    myMethod(Integer value) { return 0; } // A changed Return type is INDEPENDENT from the method parameter list

    //boolean setMyOtherInt() { return true; }  // Can not have setMyOtherInt() with 2 different return types
    //void setMyOtherInt() { }                  // Can not have setMyOtherInt() with 2 different return types

    // =================================================================================================================

    /** Question: Which of the following methods is valid? */

    long square(int arg) {
        return arg * arg; // auto cast to long - valid
    }

    int unboxTheBoxed(int arg) {
        return new Integer(arg); // auto unboxing to int - valid
    }

    // =================================================================================================================

    /** Question: What happens when the following methods are compiled and executed?
     * Try to answer before uncommenting ;) */

/*    int multiply(int arg1, int arg2) {
        return arg1 * arg2;
    }

    void multiply(int arg1, int arg2) {
        System.out.println(arg1 * arg2);
    }*/

    // Answer: The second multiply is not valid since it is Not overloading: parameter signature is not different from 1st multiply

    // =================================================================================================================

    /** Question: Which of the two following methods will be invoked when calling printNumber(0)? */

    static void printNumber(long arg) {
        System.out.println("long : " + arg);
    }

    static void printNumber(Integer arg) {
        System.out.println("Integer : " + arg);
    }

    // Answer: The first one because casting is permitted before auto boxing!

    // =================================================================================================================

    /** Question: Which of the following will override the method run() correctly when inserted under the commented line? */
    class A {
        private void run() {
            System.out.println("A");
        }
    }

    class B extends A {
        // A)
//        private void run() {
//            System.out.println("B");
//        }

        // B)
//        void run() {
//            System.out.println("B");
//        }

        // C)
//        public void run() {
//            System.out.println("B");
//        }

        // D)
//        private void run(String s) {
//            System.out.println(s);
//        }

        // E
        // We can't override the method run()
    }

    // Answer: Since method run() in the super class A has accessor private it is not visible to the outside
    // and therefor cannot be inherited and thus not being overridden. Answer E) is therefor correct.

}

class RockLand {
    int change(int x) {
        x = 2;
        return x;
    }
}
