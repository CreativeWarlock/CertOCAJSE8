package Objective_7_Inheritence.Subobjective_3;

public class DetermineWhenCastingIsNecessary {

    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html

    public static void main(String[] args) {
        System.out.println("Chapter 7.3 - Determine when casting is necessary");

        /**
         * Type Casting:
         * -------------
         *
         * - is an operation that converts one object reference type to another
         * - is allowed only if both sides of the casting are in the same type hierarchy
         * - otherwise: Compile Time Error
         *
         * - two kinds of casting:
         *      up-casting:     can be done implicitly
         *      down-casting:   must be done with cast operator
         */

        /** Upcasting: */
        String myString = "Hello World!";
        Object myStringObject = (Object)myString; // superfluous operator!

        /** Downcasting:*/
        String myCastedString = (String)myStringObject;

        System.out.println(myCastedString);

        /** Question: What happens when the following code is executed? */

        Double d = new Double(0);
        //Float f = (Float)d;                 // cannot cast to Float! Double is no sub/super-type of Float!

        Float f = 47.11f;
        //Double biggerFloat = (Double)f;       // cannot cast to Float! Float is no sub/super-type of Double!

        Object o = new Object();
        //Integer myInt = (Integer)o;             // produces a ClassCastException since 'o' is not an instance of type Integer!

        // it only works if the object 'o' would have been created by casting up from an Integer like so:
        Integer intForO = new Integer(42);
        Object betterO = (Object)intForO;
        Integer theOldIntAgain = (Integer)betterO;
        System.out.println(theOldIntAgain);

        Number myNum = (Number)theOldIntAgain;
        Long myLong = (Long)myNum;              // produces a ClassCastException!


    }
}

class SuperClass {
    //protected String field = "Super class";
    protected void print() {
        //empty body!
    }
}

class SubClass1 extends SuperClass {
    protected String field = "Sub class 1";
    protected void print() {
        System.out.println(field);
    }
}

class SubClass2 extends SuperClass {
    protected String field = "Sub class 2";

    protected void print() {
        System.out.println(field);
    }
}

