package Objective_7_Inheritence.Subobjective_5;

public class AbstractClassesVsInterfaces {

    // https://docs.oracle.com/javase/tutorial/java/IandI/interfaceDef.html
    // https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html

    public static void main(String[] args) {
        System.out.println("Chapter 7.5 - Abstract classes vs interfaces");

        /**
         * Similarities:
         * -------------
         *
         * - cannot be instantiated
         * - may contain a mix of methods declared with or without an implementation
         *
         * Differences:
         * ------------
         *              Interfaces                  Abstract Classes
         *
         * Fields       automatically public,       may be non-public,
         *              static and final            non-static and non-final
         *
         * Methods      automatically public,       may be declared with ANY
         *              must not have any other     access modifier
         *              modifier
         *
         * Inheritance  A class may implement       A class can only extend
         *              ANY number of interfaces    one class
         *
         *
         * Use Cases for Abstract Classes:
         * -------------------------------
         *
         * - share code among several closely related classes
         * - expect classes that extend the abstract class to have many common methods or fields
         * - expect extending classes to require access modifiers other than public
         *
         * - declare non-static or non-final fields -> enabling the coder to define methods that can
         *   access and modify the state of the object to which they belong
         *
         * Use Cases for Interfaces:
         * -------------------------
         *
         * - expect unrelated classes to implement that interface (e.g. printMedia)
         * - specify the behavior of a particular data type (irrelevant who implements this behavior)
         *
         * - take advantage of multiple inheritance of type
         *
         */

        // AbstractA abs = new AbstractA(); // NOPE - cannot instantiate an abstract class!
    }
}

interface InferfaceA {
    public static final int numberA = 0; // final must be initialized!
    int numberB = 0;

    //public int myMethod(int i) { return i; } // methods cannot have a body!

    public int myMethod(int i);                // can ONLY have public, not any other access modifier!

    static int getNumberA() { return numberA; } // static methods -> must have a body!

    default int defaultMethod() { return numberB; }
}

abstract class AbstractA implements InferfaceA { // an abstract must not implement any methods! ;)
    private String name;
    public AbstractA() {    // constructor cannot be directly called! Only from sub classes!
        name = "AbstractA";
    }

    public String getName() { return name; }
}