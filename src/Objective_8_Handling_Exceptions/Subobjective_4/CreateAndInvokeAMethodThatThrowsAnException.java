package Objective_8_Handling_Exceptions.Subobjective_4;

import java.io.IOException;

public class CreateAndInvokeAMethodThatThrowsAnException {

    // https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html

    public static void main(String[] args) {
        System.out.println("Chapter 8.4 - Create and Invoke a method that throws an Exception");

        /**
         * Creating and Invoking Methods:
         * ------------------------------
         * A) A method that can throw a CHECKED exception:
         *
         * - MUST specify the exception in a 'throws' clause!
         *
         * - when invoking such a method, the calling method MUST:
         *      - EITHER handle the exception by itself, by surrounding the invocation with a 'try-catch' block
         *      - OR rethrow/propagate the exception with a 'throws' clause (and naming the proper Exception class)
         *
         * ----------------------------------------------------------------
         *
         * B) A method that can throw an UNCHECKED exception:
         *
         * - No requirements:
         *      - for the method that throws the unchecked exception
         *      - for any calling methods
         *      -> A RuntimeException will automatically propagate up
         * */

        methodThatHandlesACheckedException(); // must have individual exception handling or rethrowing

        methodThatPropagatesAnUncheckedExceptionMethod(); // Unchecked Exception -> no need for 'throws' clause -> will automatically propagate up

        tryDivision();
    }

    /** Methods with Checked Exceptions
     * ================================ */

    public static void methodThatHandlesACheckedException() {
        try {
            rethrowingIOExceptionMethod();
            System.out.println("Bla"); // Code is NOT unreachable
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rethrowingIOExceptionMethod() throws IOException {
        methodThrowingIOException();
        System.out.println("Bla"); // Code is NOT unreachable
    }

    public static void methodThrowingIOException() throws IOException { // MUST HAVE throws IOException since this IS a checked Exception!
        throw new IOException("OH OH! IO Exception!");
        //System.out.println("Bla"); // Code IS unreachable! -> Compile Time Error!
    }

    /** Methods with Unchecked Exceptions
     * ================================== */

    public static void methodThatPropagatesAnUncheckedExceptionMethod() {
        uncheckedExceptionMethod();
    }

    //public static void uncheckedExceptionMethod() throws Exception { // Would lead to unhandled exception! (despite there is no such Exception being thrown ;) )

    //public static void uncheckedExceptionMethod() throws RuntimeException { // NO NEED FOR extra 'throws' clause!
    public static void uncheckedExceptionMethod() {
        //throw new RuntimeException();
        //throw new Exception();
    }

    // ------------------------------------------------------

    /** Question 1: Does the following method compile and if not, where is the error? */

    /*public static void catchMixesExceptionTypes(String args[]) {
        try {
            System.out.println(args[0]);
        }catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e) {
            if (e instanceof ArrayIndexOutOfBoundsException) {
                //e = new ArrayIndexOutOfBoundsException("Out of bounds");
            } else if (e instanceof NullPointerException) {
                e = new NullPointerException("Null Value");
            } else {
                e = new ArithmeticException("Arithmetic");
            }
            System.out.println(e.getMessage());
        }
    }*/

    // ------------------------------------------------------

    /** Question 2:
     *
     * public void doSomething() throws Exception {
     *     doSomethingElse();
     * }
     *
     * public void doSomethingElse() throws RuntimeException {
     *     throw new Exception();
     * }
     *
     * What happens when the above methods are compiled?
     * A) Compilation succeeds
     * B) Compilation fails
     *
     */

    // Answer Q1: B)
    // Answer Q2: B)

    /** Question 3:
     *
     * public void doSomething() {
     *     doSomethingElse();
     * }
     *
     * public void doSomethingElse() throws Exception {
     *     throw new RuntimeException();
     * }
     *
     * What happens when the above methods are compiled?
     * A) Compilation succeeds
     * B) Compilation fails
     *
     */

    private static void tryDivision() {
        int x = 0, y = 0;

        try {
            y /= x;
            System.out.println("y: " + y);

        } catch (ArithmeticException e) {
            System.out.println("error! Division by 0!");
        } finally {
            System.out.println("finally!");
        }
    }

    // ------------------------------------------------------

    /** Question 4: Does the following method compile and if not, where is the error? */

/*    public static void catchMixesExceptionTypes(String args[]) {
        try {
            System.out.println(args[0]);
            throw new Exception("There surely is an exception!");
        }catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException | Exception e) {
            System.out.println(e.getMessage());
        }
    }*/

    // ------------------------------------------------------

    /** Question 5: Does the following method compile and if not, where is the error? */

/*    public static void catchMixesExceptionTypes(String args[]) {
        try {
            System.out.println(args[0]);
        }catch (IOException x) {}
    }*/
}

