package Objective_8_Handling_Exceptions.Subobjective_1;

public class DifferentiateAmongCheckedAndUncheckedExceptionsAndErrors {

    // https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html

    public static void main(String i[]) {
        System.out.println("Chapter 8.1 - Differentiate among checked and unchecked Exceptions and Errors");

        /**
         * Checked Exceptions:
         * -------------------
         * - are exceptional condition
         * - a well-written application anticipates an exception (by checking it)
         * - a well-written application recovers from from an exception (that is checked)
         *
         * - are subject to the 'CATCH or SPECIFY REQUIREMENT', meaning that code that might throw a checked exception
         *   must be enclosed by either:
         *      -> a try block that catches the exception, followed by a 'catch' or a 'finally' block or both that handles the exception
         *      -> a method that specifies that it can throw the exception; the method must provides a 'throws' clause that lists the exception class
         *
         *  All exceptions are CHECKED exceptions, EXCEPT
         *
         *  Unchecked Exceptions:
         *  ---------------------
         *      1. 'RuntimeException' and its subclasses
         *      2. 'Error' and its subclasses
         *
         *  - are exceptional conditions that are internal to the application
         *  - the application cannot anticipate the exception
         *  - the application cannot recover from the exception
         *  - usually caused by bugs like logic errors or improper use of an API
         *     ==> represented by 'RunTimeException' and its subclasses
         *
         *  -> are NOT subject to the 'CATCH or SPECIFY REQUIREMENT'!
         *
         * 1. Some SubClasses of RunTimeException:
         * ---------------------------------------
         *  ArithmeticException
         *  ArrayIndexOutOfBoundsException
         *  AssertionFailure
         *  BufferOverflowException
         *  BufferUnderflowException
         *  ClassCastException
         *  DateTimeException
         *  EventException
         *  FileSystemNotFoundException
         *  IllegalArgumentException
         *  IllegalThreadException
         *  IllegalStateException
         *  IndexOutOfBoundException + StringIndexOutOfBoundsException
         *  JMRuntimeException
         *  NoSuchElementException
         *  NotImplementedException
         *  NullPointerException
         *  ParseException
         *  ReflectionException
         *  SecurityException
         *  StringIndexOutOfBoundsException
         *  SystemException
         *  UndeclaredThrowableException
         *  UnsupportedPlatformException
         *  VMOutOfMemoryException
         *
         *  2. Some Subclasses of Errors:
         *  -----------------------------
         *  - are exceptional conditions that are EXTERNAL to the application
         *  - the application cannot anticipate the exception
         *  - the application cannot recover from the exception
         *  - represented by 'Error' and its subclasses
         *
         *  - Examples:
         *      - AssertionError
         *      - OutOfMemoryError
         *      - StackOverflowError
         *
         * */

        try {
            doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ----------------------------------------------------------------------------------------------------------------

        /** Question:
         *
         * Which of the following will create an appropriate catch block for the following try block?
         * try { int x = Integer.parseInt("one"); }
         *
         * A) IllegalArgumentException
         * B) 
         * C) None of the above.
         *
         * */

        try {
            int x = Integer.parseInt("one");
        } catch(NumberFormatException e) {}

        // answer: C -> Unchecked exceptions and errors are not subject to the 'Catch or Specifier Requirement'; hence A) and B) make no difference in the outcome!
    }

    public static void doSomething() throws Exception {
        throw new Exception("OUCH"); // Unhandled Exception Compile error if throws Exception is missing after the doSomething() signature
    }

    /** Question:
     *
     * Assume that a method throws an unchecked exception at runtime.
     *
     * Which of the following is a correct solution to deal with this situation?
     *
     * A) Wrapping the method body within a 'try' statement
     * B) Specifying the exception in a 'throws' clause
     * C) None of the above.
     *
     * */

    // answer: C -> Unchecked exceptions are not subject to the 'Catch or Specifier Requirement'; hence A) and B) are not necessary!

    // ----------------------------------------------------------------------------------------------------------------

    /** Question:
     *
     * When deploying code to a system, it sometimes throws an error.
     *
     * Which of the following is a correct solution to deal with this situation?
     *
     * A) Wrapping the method body within a 'try' statement
     * B) Specifying the error in a 'throws' clause
     * C) None of the above.
     *
     * */

    // answer: C -> Unchecked exceptions and errors are not subject to the 'Catch or Specifier Requirement'; hence A) and B) make no difference in the outcome!
}