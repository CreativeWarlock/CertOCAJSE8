package Objective_2_Java_Data_TRypes.Subobjective_1;

public class Declare_And_Initialize_Variables {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html
    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

    public static void main(String[] args) {
        System.out.println("Chapter 1.1 - Declare and Initialize Variables");

        /**=============================================================================================================
         * Class-Level Variables:
         * ----------------------
         *      - are declared AND initialized at the same time
         *      - if declaring a variable without initializing it
         *          the compiler will set the variable to a reasonable default value - based on its type
         *
         * Default values vor variables of various data types:
         *      byte, short, int, long:     0
         *      float, double:              0.0
         *      char:                       \u0000
         *      boolean:                    false
         *      Object:                     null
         */

        /**=============================================================================================================
         * Local Variables:
         * ----------------
         *      - are used to store temporary states within methods or blocks
         *      - must be declared and explicitly initialized before being used!
         */

        /**=============================================================================================================
         * Primitive Data Type Casting:
         * ----------------------------
         * Widening casting: -> implicitly implemented!
         *      byte -> short -> int -> long -> float -> double
         *
         * Narrowing casting: -> must be implemented explicitly!
         *      double -> float -> long -> int -> short -> byte
         *
         *      -> REQUIRES casting Operator!
         *
         * CHAR:
         *  - special data type
         *  - has the same length as short
         *
         * Casting to and from char:
         * -------------------------
         *  * Widening casting:
         *      from char -> (int, long, float or double)
         *
         *  * Narrowing casting:
         *      from char -> (byte or short)
         *      from (short, int, long, float or double) -> char
         *
         *  Widening and narrowing casting:
         *      byte -> char
         *
         * Essential statements:
         *  - The magnitude and precision of a value may be lost after being cast
         *  - Primitive type casting never results in a runtime exception
         */

        CastingTests tests = new CastingTests();
        tests.intAndByteCasting();
        tests.castingWithFloatAndLong();

        int _6 = 6;
        int x = 0XE;
    }
}

class CastingTests {
    public void intAndByteCasting() {
        int myInt = 0;

        // widening casting
        long myLong = myInt;

        // narrowing casting
        byte myByte = (byte) myInt;
    }

    public void castingWithFloatAndLong() {
        float f = 0.1F; int i = 0;

        //long l = f + i; // Missing explicit cast to long!

        long l = (long)(f + i);
        f = l + i;          // Works fine -> implicit cast from long to float

        System.out.println(f);
    }

    public void castingWithChars() {
        char c = 'A';
        int charInt = c;
        short charShort = (short)c;
        byte charByte = (byte)c;

        short mySpecialShort = 65;
        char letter = (char)mySpecialShort;

        int mySpecialInt = 65;
        char letterFromInt = (char)mySpecialInt;

        int mySpecialByte = 177;
        char letterFromByte = (char)mySpecialByte;
    }
}