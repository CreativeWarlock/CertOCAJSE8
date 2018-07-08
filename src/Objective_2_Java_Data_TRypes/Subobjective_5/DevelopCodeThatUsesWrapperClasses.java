package Objective_2_Java_Data_TRypes.Subobjective_5;

public class DevelopCodeThatUsesWrapperClasses {

    // https://docs.oracle.com/javase/tutorial/java/data/numberclasses.html
    // https://docs.oracle.com/javase/tutorial/java/data/characters.html

    // https://docs.oracle.com/javase/8/docs/api/

    public static void main(String[] args) {
        System.out.println("Chapter 2.5 - Develop Code that uses Wrapper Classes");

        /**
         *  - The Java platform provides wrapper classes for primitive data types
         *
         *  8 Wrapper classes:
         *  ------------------
         *  - Boolean
         *  - Byte
         *  - Short
         *  - Integer
         *  - Long
         *  - Float
         *  - Double
         *  - Character
         */

        /** Boolean Wrapper class */
        Boolean myBool = Boolean.logicalAnd(true, false);
        int boolCompare = myBool.compareTo(false);              // Boolean.TRUE.compareTo(Boolean.FALSE) -> 1
        //boolCompare = Boolean.FALSE.compareTo(true);          // Boolean.FALSE.compareTo(Boolean.TRUE) -> -1
        System.out.println("boolCompare: " + boolCompare);

        boolean getBoolean = Boolean.getBoolean("true"); // Requires a System.getProperty("XXX") as argument!
        System.out.println("getBoolean: " + getBoolean);        // false

        boolean parsedBoolean = Boolean.parseBoolean("TruE");
        System.out.println("parsedBoolean: " + parsedBoolean);  // true

        boolean valueOfBoolean = Boolean.valueOf("TruE");
        boolean valueOfBoolean2 = Boolean.valueOf(true);
        System.out.println("valueOfBoolean: " + valueOfBoolean);//true

        //int compareBooleans = Boolean.compare(true, false);  // 1
        //int compareBooleans = Boolean.compare(false, true); // -1
        //int compareBooleans = Boolean.compare(false, false); // 0
        int compareBooleans = Boolean.compare(true, true);     // 0
        System.out.println("compareBooleans: " + compareBooleans);

        // -------------------------------------------------------------------------------------------------------------

        /**
         * Numerical Wrapper classes:
         *      Byte, Short, Integer, Long
         *
         *      - Fields and methods have similar names and functionality
        */

        int sum = Integer.sum(1, 4);
        System.out.println("sum: " + sum);

        int intCompare = Integer.compare(6, 4);
        System.out.println("intCompare: " + intCompare);

        int bitCount = Integer.bitCount(11);
        System.out.println("bitCount: " + bitCount);

        int highestOneBit = Integer.highestOneBit(11);
        System.out.println("highestOneBit: " + highestOneBit);

        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(16);
        System.out.println("numberOfTrailingZeros: " + numberOfTrailingZeros);

        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(1);
        System.out.println("numberOfLeadingZeros: " + numberOfLeadingZeros);

        // -------------------------------------------------------------------------------------------------------------

        /**
         * Floating point Wrapper classes:
         *      Float, Double
         *
         *      - Fields and methods have similar names and functionality
         */

        double max = Double.max(1.1, 2.1);
        System.out.println("max: " + max);

        Double wrapper = new Double(1.5);
        long intValue = wrapper.intValue();
        System.out.println("intValue: " + intValue);

        //Double divByZero = 1 / 0; // incompatible types!
        Double divByZero = 1 / 0.0;
        System.out.println("is DivByZero infinite? " + divByZero.isInfinite());

        // -------------------------------------------------------------------------------------------------------------

        /**
         * Character Wrapper classes:
         *      Character
         *
         *      - wraps a value of a primitive type 'char' in an object
         */
        int codePoint = Character.codePointAt("OCAJP 8", 2);
        System.out.println("codePoint: " + codePoint);

        boolean charDefined = Character.isDefined('@'); // is available in Unicode table?
        System.out.println("charDefined? " + charDefined);

        /** -------------------------------------------------------------------------------------------------------- */

        Integer i = 10;
        Double d = 10.0;
        int ii = 10;
        double dd = 10.0;

        System.out.println("i.equals(d): " + i.equals(d) + " "); // At first, equals compares the data types -> FALSE
        System.out.println("ii == dd: " + (ii == dd));       // can compare int with double -> will result true here!

        /** -------------------------------------------------------------------------------------------------------- */

        Integer wi = 10;
        System.out.println("wi.equals(10): " + wi.equals(10));
        System.out.println("wi.equals(10.0): " + wi.equals(10.0));

        int dec = 10;
        System.out.println("wi == dec: " + (wi == dec));

        System.out.println("wi.BYTES: " + wi.BYTES);
        System.out.println("wi.SIZE: " + wi.SIZE);

        //Double dbl = 10; // Compile Error!
        Double dbl = 10.0;
        //System.out.println("wi == dbl: " + (wi == dbl)); // Compile Error: "==" cannot be applied to Integer, Double

        System.out.println("dbl.BYTES: " + dbl.BYTES);
        System.out.println("dbl.SIZE: " + dbl.SIZE);
    }

    static void iterator(int[]a) {
        int b = a.length;
    }
}