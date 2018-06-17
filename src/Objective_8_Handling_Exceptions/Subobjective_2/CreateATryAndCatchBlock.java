package Objective_8_Handling_Exceptions.Subobjective_2;

public class CreateATryAndCatchBlock {

    // https://docs.oracle.com/javase/tutorial/essential/exceptions/try.html
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html

    public static void main(String[] args) {
        System.out.println("Chapter 8.2 - Create a Try-Catch Block and determine how exceptions alter normal program flow");

        /**
         * A 'try-catch' Block:
         * --------------------
         * */

        try {
            System.out.println("Normal program flow.");
        } catch(Exception e) {
            System.out.println("Exception branch.");
        }

        try {
            throw new RuntimeException();
            //System.out.println("Normal program flow."); // Code is unreachable --> COMPILE TIME ERROR!
        } catch(Exception e) {
            System.out.println("Exception branch.");
        }

    }
}