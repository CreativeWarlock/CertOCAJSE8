package Objective_6_Methods_And_Encapsulation.Subobjective_5;

public class ApplyEncapsulationPrinciplesToAClass {

    // https://docs.oracle.com/javase/tutorial/java/concepts/object.html

    public static void main(String[] args) {
        System.out.println("Chapter 6.5 - Create and Overload Constructors; Differentiate between default and user defined constructors");

        /**
         * Encapsulation:
         * --------------
         * is a mechanism of wrapping data (variables) and code acting on the data (methods)
         * together as a single unit.
         */


        /** Question: */

        char c = 'A'; //ASCI value of A is 65
        System.out.println(aval(c));
        //System.out.println((char)97);

    }

    private static int aval(char c) {
        int x = c;
        return x;
    }

    // Variable declaration here for the next question
    final int j = 32;

    /** Question 14: is the following method 'calc(int i)' compilable? */

//    static int calc(int i) {
//        return i + j;
//    }

    // Answer: Since j cannot be accessed from static context, the method cannot be compiled.
}