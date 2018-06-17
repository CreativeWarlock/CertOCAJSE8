package Objective_8_Handling_Exceptions.Subobjective_3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DescribeTheAdvantagesOfExceptionHandling {

    // https://docs.oracle.com/javase/tutorial/essential/exceptions/advantages.html

    public static void main(String[] args) {
        System.out.println("Chapter 8.3 - Describe the Advantages of Exception Handling");

        /**
         * Exception Handling Advantages:
         * ------------------------------
         *
         * - separating error-handling code from regular code
         * - propagating errors up the call stack
         * - grouping and differentiating error types
         *
         * ad) Separating error-handling code from regular code:
         *
         *      - exceptions provide the means to separate the details of what to do when
         *        an unusual situation happens in the main workflow of a program
         *
         * ad) Propagating errors up the call stack
         *
         * Example:
         */

        try {
            doSomethingElse(); // this method propagates any exceptions that might occur within it
        } catch(Exception e) {
            // exception handling
        }

         /**
         * ad) Grouping and differentiating error types
         *
          *     - The exception hierarchy helps exception handlers to decide on the best recovery strategies
          *       based on what types of exception occurred
          *
          * Example:
         * */

        try {
            openFile();
        } catch(FileNotFoundException e) {
            // exception handling
        } catch(IOException e) {
        // exception handling
        } catch(Exception e) {
            // exception handling
        }

        /** Question 1: Is this statement true or false:
         *
         * In order for a checked exception to be handled by a method up the call stack, the statements that can throw the exception
         * must be pre-processed by an exception handler within the enclosing method?
         *
         * A) true
         * B) false
         * */

        /** Question 2: Is this statement true or false:
         *
         * Exception handling allows you to define handlers for very specific as well as general exceptions
         * when handling a group of statements?
         *
         * A) true
         * B) false
         */

        // Answers
        // Q1: B)
        // Q2: A)
    }

    public static void doSomethingElse() throws Exception {}

    public static void openFile() throws FileNotFoundException, IOException, Exception {}
}