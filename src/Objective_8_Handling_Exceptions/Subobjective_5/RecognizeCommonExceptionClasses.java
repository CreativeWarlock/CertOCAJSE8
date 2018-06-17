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

        String text = null;
        //System.out.println(text.toString()); // Will throw an NPE

        /**
         * ArithmeticException:
         * --------------------
         * an exceptional arithmetic condition has occurred, e.g.
         * - a division by zero
         *
         * Example:
         * */

        int i = 0;
        //int j = 1/i;    // Will throw an AE

        /**
         * ArrayIndexOutOfBoundException:
         * ------------------------------
         * an array has been accessed with an illegal index:
         *  - the index is either negative or greater than or equal to the size of the array
         *
         *  Example:
         * */

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
        //Float floatingPoint = (Float)number;        // Will throw a CCE

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


        /** Question 2:
         * Which exception will be thrown in the following code?
         *
         * A) NullPointerException
         * B) ArithmeticException
         * C) ArrayIndexOutOfBoundException
         * D) None of the above
         */
        int[] myArray2 = new int[0];
        if (myArray2.length > 0)
            myArray2[1] = 1;        //will not be executed...


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
        //array1[0] = array1.length;    // will throw..


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
        //int a = 0.2d; // ;)
    }
}