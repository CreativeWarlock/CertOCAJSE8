package Objective_5_Loop_Constructs.Subobjective_3;

public class CreateAndUseDoWhileLoops {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html

    public static void main(String[] args) {
        System.out.println("Chapter 5.3 - Create and Use do/while loops");

        /** The do/while Loop
         * ------------------
         *
         * Continually executes a block of statements while a particular condition evaluates to 'true'
         *
         * Syntax:
         *
         * do {
         *      statement/s
         * } while (condition)
         */

        int i = 0;
        do {
            System.out.print(i + " ");
            i++;
        } while (i < 10);

        System.out.println();


        /** Following is NOT VALID -> local variable is not visible in condition! */
/*        do {
            int j = 0;
            System.out.print(j + " ");
            j++;
        } while (j < 10);*/

        /** Following executes ONCE before reaching the while condition */
        int k = 0;
        do {
            System.out.print(k + " ");
            k++;
        } while (k < 0);

        System.out.println();

    }
}