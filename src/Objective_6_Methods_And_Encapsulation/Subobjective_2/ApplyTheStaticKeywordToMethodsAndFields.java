package Objective_6_Methods_And_Encapsulation.Subobjective_2;

public class ApplyTheStaticKeywordToMethodsAndFields {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html

    static {
        //int x = 10;
        int y = 5;
    }

    int x;
    //final static int y;

    int instanceVariable;
    void instanceMethod() {}

    public static void main(String[] args) {
        System.out.println("Chapter 6.2 - Apply the static keyword to methods and Fields");

        ApplyTheStaticKeywordToMethodsAndFields ap = new ApplyTheStaticKeywordToMethodsAndFields();

        System.out.println("ap.x: " + ap.x);

        /**
         * Static Variables:
         * -----------------
         * - fields with static modifier -> static fields = class variables!
         *
         * - Advantage: make a class memory efficient
         * */

        Data data1 = new Data(), data2 = new Data();
        data1.instanceValue = 1;
        data1.staticValue = 1;

        System.out.println("Data.staticValue: " + Data.staticValue);
        System.out.println("data2.instanceValue: " + data2.instanceValue);
        System.out.println("data2.staticValue: " + data2.staticValue);

        //instanceVariable++;   // Not allowed from static context!
        //instanceMethod();     // Not allowed from static context!

        /**
         * Static Methods:
         * ---------------
         * - methods with static modifier -> static methods = class methods!
         * - does not need an instance of the class
         * - cannot access instance variables
         * - cannot access instance methods
         * -> must use object references
         * */

        data1.instanceMethodIncrementStaticValue();

        System.out.println("Data.staticValue: " + Data.staticValue);
        System.out.println("data2.instanceValue: " + data2.instanceValue);
        System.out.println("data2.staticValue: " + data2.staticValue);

        NastyClassWithStaticMethod nastyClassWithStaticMethod = new NastyClassWithStaticMethod();
        //NastyClassWithStaticMethod.p2(6);       //A
        //nastyClassWithStaticMethod.print(6);    //B
        //NastyClassWithStaticMethod.print();     //C
                                   //D none

        /** Question 1: Which of the above comments will compile when uncommmenting (A-C) or will none (D)? */

        // Answer: Because it is allowed to access static methods from an instance, B is correct.
    }
}

class NastyClassWithStaticMethod {
    private static void p2(int i) {
        System.out.print(i*2);
    }

    static void print(int i) {
        System.out.print(i);
    }
}