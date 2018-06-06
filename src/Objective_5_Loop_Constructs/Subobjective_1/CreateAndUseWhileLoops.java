package Objective_5_Loop_Constructs.Subobjective_1;

public class CreateAndUseWhileLoops {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html

    public static void main(String[] args) {
        System.out.println("Chapter 5.1 - Create and Use While loops");

        /** The While Loop
         * ---------------
         * Continually executes a block of statements while a particular condition evaluates to 'true'
         *
         * Syntax:
         *
         * while (condition) {
         *      statement/s
         * }
         */

        int i = 0;
        while (i<10)
            i++;

        System.out.println(i + " ");

        /** Question: What will be printed out? */

        /*while (false) {
            i = 20;
            System.out.print("i: " + i);
        }*/

        // Answer: Nothing. Compile time error: Unreachable statement!

        /** Question what will be printed out? */

        int x = 0;

        do {
            System.out.print(x);
        } while (x++ < 2);

        for(x = 0; x++ < 2;)
            System.out.print(x);

        // Answer: 01212
    }
}