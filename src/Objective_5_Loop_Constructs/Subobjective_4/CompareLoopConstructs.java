package Objective_5_Loop_Constructs.Subobjective_4;

public class CompareLoopConstructs {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html

    public static void main(String[] args) {
        System.out.println("Chapter 5.4 - Compare Loop constructs");

        /** Comparison of Loop Constructs
         * ------------------------------
         *
         * The 'for' statement provides a compact way to iterate over a range of values
         * It has two forms, with one designed for looping through elements of a collection/array.
         *
         * Both 'while' and 'do-while' statements continually printInstanceField a block of statements
         * while a particular condition is 'true';
         * The difference is that 'while' evaluates the condition at the top of the loop; whereas
         * 'do-while' evaluates at the bottom of the loop
         *
         * In a 'while' or 'do-while' statement, the increment/decrement expression, if any, must be specified
         * as part of the execution block; whereas it is a separate expression in a 'for'-loop
         *
         */

        int[] intArray = {0, 1, 2, 3, 4};
        for(final int i : intArray) {
            System.out.print(i + " ");
        }

        /** Following is NOT VALID -> Cannot increment i! */
/*        for(final int i = 0; i < intArray.length; i++) {
            System.out.print(i + " ");
        }*/
    }
}