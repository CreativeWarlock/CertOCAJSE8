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

        System.out.print(i + " ");



    }
}