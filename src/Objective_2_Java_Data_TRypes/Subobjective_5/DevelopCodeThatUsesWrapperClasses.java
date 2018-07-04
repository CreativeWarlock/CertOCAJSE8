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
        int boolCompare = myBool.compareTo(false);
        System.out.println("boolCompare: " + boolCompare);

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

        /**
         * Floating point Wrapper classes:
         *      Float, Double
         *
         *      - Fields and methods have similar names and functionality
         */
        double max = Double.max(1.1, 2.1);
        System.out.println("max: " + max);

        Double wrapper = new Double(1.5);
        long roundedDown = wrapper.intValue();
        System.out.println("rounded: " + roundedDown);

        /**
         * Character Wrapper classes:
         *      Character
         *
         *      - wraps a value of a primitive type 'char' in an object
         */
        int codePoint = Character.codePointAt("OCAJP 8", 2);
        System.out.println("codePoint: " + codePoint);

        boolean charDefined = Character.isDefined('@'); // is available in Unicode table?
        System.out.println("charDefined: " + charDefined);

        /** -------------------------------------------------------------------------------------------------------- */

        Integer i = 10;
        Double d = 10.0;
        int ii = 10;
        double dd = 10.0;

        System.out.print(i.equals(d) + " ");
        System.out.println(ii == dd);       // can compare int with double -> will result true here!

        /** -------------------------------------------------------------------------------------------------------- */

        Integer wi = 10;
        System.out.println("wi.equals(10)" + wi.equals(10));

        int dec = 10;
        System.out.println("wi == dec: " + (wi == dec));

        //Double dbl = 10;
        System.out.println("wi == dec: " + (wi == dec));

        Double dbl = 10.0;
        System.out.println("dbl.BYTES: " + dbl.BYTES);
        System.out.println("dbl.SIZE: " + dbl.SIZE);
    }

    static void iterator(int[]a) {
        int b = a.length;
    }
}