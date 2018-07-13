package Objective_8_Handling_Exceptions.Subobjective_5;

public class RecognizeCommonExceptionClasses {

    // https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html
    // https://docs.oracle.com/javase/8/docs/api/java/lang/ArithmeticException.html
    // https://docs.oracle.com/javase/8/docs/api/java/lang/ArrayIndexOutOfBoundsException.html
    // https://docs.oracle.com/javase/8/docs/api/java/lang/ClassCastException.html

    public static void main(String[] args) {
        System.out.println("Chapter 8.5 - Recognize Common Exception Classes");

        /**
         * NullPointerException:
         * ---------------------
         * an application attempts to use null where an object is required, e.g.
         *
         * - Calling the instance method of a null object
         * - Accessing or modifying the field of a null object
         *
         * - Taking the length of null as if it were an array
         * - Accessing or modifying the slots of null as if it were an array
         *
         * - Throwing null as if it were a Throwable value
         *
         * Example:
         * */

        String text;
        //System.out.println(text.toString()); // Will throw an NPE

        /**
         * ArithmeticException:
         * --------------------
         * an exceptional arithmetic condition has occurred, e.g.
         * - a division by zero
         *
         * Example:
         * */

        //System.out.println(5/0);     // throws an AE

        Double d1 = 1 / 0.0; // No AE!
        System.out.println("d1: " + d1); // prints Infinity
        System.out.println("Double.isNaN(d1): " + Double.isNaN(d1)+ " ");
        System.out.print("Double.isInfinite(d1): " + Double.isInfinite(d1));

        /**
         * ArrayIndexOutOfBoundException:
         * ------------------------------
         * an array has been accessed with an illegal index:
         *  - the index is either negative or greater than or equal to the size of the array
         *
         *  Example:
         */

        int[] myInts = new int[] {1,2,3};
        //int iWantNumber5 = myInts[5];


        /**
         * ClassCastException:
         * -------------------
         * the code has attempted to cast an object to a subclass of which it is not an instance
         *
         * Example:
         * */

        Number number = new Integer(0);
        //Float floatingPoint = (Float)number;        // Will throw a CCE since Number never was a Float object before.

        Object obj = new Double(3.0);
        Number num = (Number)obj;
        System.out.println(num);    // CCE will not be thrown since the Number is a superclass of wrappers. So, casting will occur without any issue.

        /** ------------------------------------------------------------------------------------ */

        /** Question 1:
         * Which exception will be thrown in the following code?
         *
         * A) NullPointerException
         * B) ArithmeticException
         * C) ArrayIndexOutOfBoundException
         * D) None of the above
         */
        int[] myArray = new int[2];
        //myArray[2] = myArray[0] / myArray[1];

        // -------------------------------------------------------

        /** Question 2:
         * Which exception will be thrown in the following code?
         *
         * A) NullPointerException
         * B) ArithmeticException
         * C) ArrayIndexOutOfBoundException
         * D) None of the above
         */
        int[] myArray2 = new int[0];
        if (myArray2.length > 0) myArray2[1] = 1;

        // -------------------------------------------------------

        /** Question 3:
         * Which exception will be thrown in the following code?
         *
         * A) NullPointerException
         * B) ArithmeticException
         * C) ArrayIndexOutOfBoundException
         * D) None of the above
         */
        int[] array1 = new int[0];
        int[] array2 = null;
        array1 = array2;
        //array1[0] = array1.length;

        // -------------------------------------------------------

        /** Question 4:
         * Which exception will be thrown in the following code?
         *
         * A) NullPointerException
         * B) ArithmeticException
         * C) ArrayIndexOutOfBoundException
         * D) None of the above
         */
        int[] myArray3 = new int[0];
        if (myArray3.length == 0)
            myArray3 = null;

        //myArray3[0] = (Integer)(Number)new Double(0);

        // casting a Double to an Integer is invalid which results in a class casting exception. So answer is d correct.

        // -------------------------------------------------------

        /** Question 5:
         * Which exception will be thrown by the Java Virtual Machine (JVM)?
         *
         * A) IllegalArgumentException
         * B) ExceptionInInitializerError
         * C) IOException
         * D) FileNotFoundException
         * E) NumberFormatException
         */

        // Answer: IOException and FileNotFoundException are thrown by many methods in the java.io package, but it is always
        // programmatically. The same is true for NumberFormatException and IllegalArgumentException; these exceptions are
        // thrown programmatically by the wrapper classes of java.lang
        // So options A, C, D and E are incorrect. ExceptionInInitializerError is thrown by the JVM when the corresponding problem rises.
    }
}