package Objective_3_Operators_And_Decision_Constructs.Subobjective_2;

public class EqualityBetweenStringsAndObjects {

    // https://docs.oracle.com/javase/8/docs/api/

    // http://www.javatpoint.com/string-comparison-in-java

    public static void main(String[] args) {
        System.out.println("Chapter 3.2 - Test Equality between Strings and other objects using == and Equal");

        /**
         * String Constant Pool
         * --------------------
         *  - is an area in the heap memory, containing String objects
         *  - Strings created using string literals are returned from the string constant pool
         *  - Strings created with 'new' operator are returned from outside the pool
         */

        /** Comparison of Objects using == Operator:
         * ----------------------------------------
         *  The == operator compares OBJECTS by REFERENCE
         *  implying that an EQUALITY test EVALUATES to TRUE *only* if the two objects in comparison are THE SAME.
         * */
        String string1 = new String("WhizLabs");
        String string2 = "WhizLabs";
        String string3 = "WhizLabs";
        System.out.println(string1 == string2); // false
        System.out.println(string2 == string3); // true


        /**
         * Comparison of Objects Using equals()-Method:
         * --------------------------------------------
         *  - The equals() method is defined in the Object class
         *  - comparing objects is based on how it is overridden in these objects' blueprint classes
         *  - if not overridden, it compares the same way as the == operator does
         * */
        Data data1 = new Data(0), data2 = new Data(0);
        System.out.println("data1.equals(data2): " + data1.equals(data2)); // false

        DataWithEquals dataWithEquals1 = new DataWithEquals(0);
        DataWithEquals dataWithEquals2 = new DataWithEquals(0);
        System.out.println("dataWithEquals1.equals(dataWithEquals2): " + dataWithEquals1.equals(dataWithEquals2)); // true

        /**
         * Comparison of Strings Using equals Method
         * -----------------------------------------
         *
         * - The equals() method is overridden in the String class
         * - it compares strings based on their contained literals values
         * */
        string1 = new String("WhizLabs");
        string2 = "WhizLabs";
        string3 = "WhizLabs";
        System.out.println("string1.equals(string2): " + string1.equals(string2)); // true
        System.out.println("string2.equals(string3): " + string2.equals(string3)); // true

        /** Question: What does the following code print? */
        String ocaString = new String("OCAJP 8");
        String copiedOcString = new String(ocaString);
        System.out.println("ocaString == copiedOcString: " + ocaString == copiedOcString); // prints false alone
        System.out.println("ocaString == copiedOcString: " + (ocaString == copiedOcString));

        /** Question: What does the following code print? */
        data1 = new Data(0);
        data2 = new Data(0);
        Data data3 = data2;
        data2 = data1;
        System.out.println("data1.equals(data3): " + data1.equals(data3));
        // The answer is false since data3 receives reference from data2 which is independent from data1 plus equals()is not overridden in class Data!


    }

}

class Data {
    private int value;

    public Data(int value) {
        this.value = value;
    }
}

class DataWithEquals {
    private int value;

    public DataWithEquals(int value) {
        this.value = value;
    }

    public boolean equals(Object obj) {
        return this.value == ((DataWithEquals) obj).value;
    }
}