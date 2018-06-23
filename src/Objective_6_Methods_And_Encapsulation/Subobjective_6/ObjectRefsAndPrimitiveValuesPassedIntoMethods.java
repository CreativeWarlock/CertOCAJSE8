package Objective_6_Methods_And_Encapsulation.Subobjective_6;

public class ObjectRefsAndPrimitiveValuesPassedIntoMethods {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html

    public static void main(String[] args) {
        System.out.println("Chapter 6.6 - Determine the Effect Upon object references and primitive values passed into " +
                "methods that change values");

        /**
         * Passing Primitives vs. Object References:
         * -----------------------------------------
         *
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
         * An *OBJECT REFERENCE* variable stores the address of its referenced object in the memory
         * -> passing an object reference => the address stored in the argument is copied to the parameter
         * -> Both argument and parameter point to the same object
         * => any changes made to the parameter are reflected in the argument
         *
         * However, careful, references are always passed in by value, meaning that the reference itself cannot be changed!
         * -> only visible fields and members behind the address of the reference can be changed!
         *
         */

        int arg = 1;
        System.out.println("arg: " + arg);
        changeValueInVain(arg);
        System.out.println("arg: " + arg); // no change

        // =============================================================================================================

        Data data = new Data(1);
        System.out.println("data.value: " + data.value);
        changeValue(data);
        System.out.println("data.value: " + data.value);

        // =============================================================================================================

        Data data1 = new Data(-1);
        Data data2 = new Data(1);

        swapData(data1, data2);
        System.out.println("data1.value: " + data1.value + " " + "data2.value: " + data2.value);

        swapDataUsingMembers(data1, data2);
        System.out.println("data1.value: " + data1.value + " " + "data2.value: " + data2.value);

        DataWrapper dataWrapper1 = new DataWrapper(data1);
        DataWrapper dataWrapper2 = new DataWrapper(data2);

        swapDataWithWrapper(dataWrapper1, dataWrapper2);
        System.out.println("data1.value: " + dataWrapper1.data.value + " " + "data2.value: " + dataWrapper2.data.value);

        // =============================================================================================================

        /** Question: What is the output? */
        A a = new B();
        //System.out.println(a.calc(2.0, 3.1));   // A knows only calc(int a, int b) !!

        // Answer:  The reference type is important during compile time! It is A, therefor the compiler cannot find
        //          any calc-method that accepts 2 doubles!
        // (See Objective 7.2 for 'Reference Type vs. Object Types')

        B b = new B();
        System.out.println(b.calc(2.0, 3.1));   // this works!
    }

    static void changeValueInVain(int param) {
        System.out.println("Trying to change value (in vain)...");
        param = 2 * param;
    }

    static void changeValue(Data data) {
        System.out.println("Changing value by accessing its member variable");
        data.value = 2 * data.value;
    }

    //  When we pass in data1 and data2 to swapData(), the function swap() creates a copy of these references!
    static void swapData(Data data1, Data data2) {
        System.out.println("Fruitless swapping with data objects");
        Data temp = data1;      // ALL CHANGES HERE ARE REASSIGNMENTS OF LOCAL REFERENCE OBJECTS
        data1 = data2;          //  -> Have no effect on the passed-in arguments!
        data2 = temp;
    }

    static void swapDataUsingMembers(Data data1, Data data2) {
        System.out.println("Swapping with data member");
        int tempValue = data1.value;
        data1.value = data2.value;
        data2.value = tempValue;
    }

    static void swapDataWithWrapper(DataWrapper dataWrapper1, DataWrapper dataWrapper2) {
        System.out.print("Swapping with DataWrappers: ");
        Data tempData = dataWrapper1.data;
        dataWrapper1.data = dataWrapper2.data;
        dataWrapper2.data = tempData;

    }
}

class A {
    public int calc(int a, int b) {
        return a+b;
    }
}

class B extends A {
    public double calc(double a, double b) {
        return a+b;
    }
}