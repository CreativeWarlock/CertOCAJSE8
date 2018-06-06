package Objective_6_Methods_And_Encapsulation.Subobjective_5;

public class ApplyEncapsulationPrinciplesToAClass {

    // https://docs.oracle.com/javase/tutorial/java/concepts/object.html

    final int j = 32;

    public static void main(String[] args) {
        System.out.println("Chapter 6.5 - Create and Overload Constructors; Differentiate between default and user defined constructors");

        /**
         * Encapsulation:
         * --------------
         * is a mechanism of wrapping data (variables) and code acting on the data (methods)
         * together as a single unit.
         *
         * */


        /** Question: */

        char c = 'A'; //ASCI value of A is 65
        System.out.println(aval(c));
        //System.out.println((char)97);

    }

    private static int aval(char c) {
        int x = c;
        return x;
    }

    /** Question 14: is this method usable?
     *
     * static int calc(int i) {
     *      return i + j;
     * }
     *
     */

    // Answer: No, j cannot be accessed from static context!
}