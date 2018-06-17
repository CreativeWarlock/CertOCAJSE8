package Objective_8_Handling_Exceptions.Subobjective_5;

public class RecognizeCommonExceptionClasses {

    public static void main(String[] args) {
        System.out.println("Chapter 8.5 - Recognize Common Exception Classes");

        /**
         * NullPointerException:
         * ---------------------
         * is thrown when an application attempts to use null where an object is required, e.g.
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
        System.out.println(text.toString());
    }
}