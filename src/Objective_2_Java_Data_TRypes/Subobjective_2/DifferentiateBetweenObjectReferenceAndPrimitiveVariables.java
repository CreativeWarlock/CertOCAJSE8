package Objective_2_Java_Data_TRypes.Subobjective_2;

public class DifferentiateBetweenObjectReferenceAndPrimitiveVariables {

    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.12

    static int x = 50;

    public static void main(String [ ] args) {
        System.out.println("Objective 2.2 - Differentiate between Object Reference and Primitive Variables");

        /**
         * Essential statements:
         * ---------------------
         * - Primitive variables store actual values
         * - Object reference variables store the address of objects they refer to
         *
         * Parameter passing:
         * ------------------
         *
         * A *PRIMITIVE* variable is passed in a method by actual value
         * -> changes made to the parameter are independent of the passed-in argument
         *
         * An *OBJECT REFERENCE* variable is passed by the address of the referenced object in the memory
         * -> changes made to the parameter are reflected in the argument
         *
         * Value returning:
         * ----------------
         *
         * A primitive variable is returned from a method by actual value
         * -> This variable dies after the method finishes execution
         *
         * An object reference is returned by the address of the referenced object in the memory
         * -> The original object may survive the method completion IF it is assigned to a variable outside the method
        */

        // --------------------------------

        int x, y = 100;
        //System.out.println("x: " + x);

        int int1 = 0; int int2 = 0;
        Data data1 = new Data();
        Data data2 = new Data();

        data1.value = 0; data2.value = 0;

        System.out.println("int1 == int2: " + (int1 == int2));
        System.out.println("data1 == data2: " + (data1 == data2));

        // --------------------------------

        data1 = new Data();
        data2 = data1;
        data1.value = 3;

        System.out.println("data2.value: " + data2.value);

        int1 = 0;
        int2 = int1;
        int1 = 1;
        System.out.println("int2: " + int2);

        // --------------------------------

        /** In the following two methods, which data referenced by local variables 'object' and 'integer' can still be
         * referenced AFTER the main method has executed them?
         *
         * a) Both of them
         * b) The data referenced by object only
         * c) The data referenced by integer only
         * d) none of them
         *
         * */

        objectBuilder();
        primitiveBuilder();
    }

    static Object objectBuilder() { Object object = new Object(); return object; }
    static int primitiveBuilder() { int integer = 0; return integer; }
}

class Data { public int value; }