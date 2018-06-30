package Objective_5_Loop_Constructs.Subobjective_2;

public class CreateAndUseForLoops {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html

    static int staticX = 10;

    public static void main(String[] args) {
        System.out.println("Chapter 5.2 - Create and Use For loops including the enhanced for loop");

        /** The For Loop
         * ---------------
         * Provides a compact way to iterate over a range of values until a particular condition is satisfied
         *
         * Syntax:
         *
         * for(initialization; termination; increment/decrement) {
         *      statement/s
         * }
         */

        for(int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for(int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }

        /** The enhanced For Loop
         * ----------------------
         * Is a form of the for construct desigend for iteration through collections and arrays
         *
         * Syntax:
         *
         * for(type element : collection/array) {
         *      statement/s
         * }
         */

        int[] intArray = new int[] {0, 2, 4, 6, 8};
        for(int element : intArray) {
            System.out.print(element + " ");
        }

        System.out.println();

        int[] nums = {0, 1, 2, 3, 4};
        for(int x : nums) {
            System.out.print(x);
            continue;
            //System.out.print(staticX);
        }

        System.out.println();

        /** Following is NOT VALID -> Initialization not allowed outside the for loop! */
/*        int element;
        for(element : intArray) {
            System.out.print(element + " ");
        }*/

        //for( ; ; System.out.print("Bla")); // CAREFUL!

    }
}