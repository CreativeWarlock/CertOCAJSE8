package Objective_5_Loop_Constructs.Subobjective_5;

public class UseBreakAndContinue {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html

    public static void main(String[] args) {
        System.out.println("Chapter 5.5 - Use Break and Continue");

        /** The break statement
         * --------------------
         *
         * - instructs the program to terminate an enclosing switch or loop construct
         * - has two forms:
         *      + unlabeled -> breaks the innermost enclosing construct
         *      + labeled   -> may break an outer construct
         */

        int i, j;
        whizlabs: for(i = 1; i < 4; i++) {
            j = 1;
            while (j<3) {
                if (j % 2 == 0) {
                    break; // whizlabs;
                }
                j++;
                System.out.print("inner - ");
            }
            System.out.print("outer - ");
        }

        System.out.println();

        /** The continue statement
         * -----------------------
         *
         * - instructs the program to skip the current iteration of an enclosing loop construct
         * - does not work with the switch construct
         * - has two forms:
         *      + unlabeled -> skips the innermost enclosing loop
         *      + labeled   -> may skip an outer loop
         */

        whizlabs: for(i = 1; i < 4; i++) {
            j = 1;
            while (j < 4) {
                j++;
                if (j % 2 == 0) {
                    continue whizlabs;
                }
                System.out.print(" inner ");
            }
            System.out.print("outer");
        }

        /** NOT VALID */
        for(int m = 1; m < 4; m++) {
            for(int n = 1; n < 4; n++) {
                System.out.print("Whizlabs");
                //continue 1;
            }
        }
    }
}