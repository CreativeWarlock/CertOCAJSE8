package Objective_7_Inheritence.Subobjective_5;

import Objective_6_Methods_And_Encapsulation.Subobjective_4.AnotherClass;

public class AbstractClassesVsInterfaces {

    // https://docs.oracle.com/javase/tutorial/java/IandI/interfaceDef.html
    // https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html

    static Animal bird = new Bird();

    public static void main(String[] args) {
        System.out.println("Chapter 7.5 - Abstract Classes vs Interfaces");

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
         * - can directly implement an interface using a body which implements all methods which have no default implementation
         */

        // AbstractA abs = new AbstractA(); // NOPE - cannot instantiate an abstract class!

        // =============================================================================================================

        Integer myInt = new Integer(9);
        boolean isInstOf = myInt instanceof Number;

        InterfaceA i = new InterfaceA() {
            @Override
            public int myMethod(int i) {
                return 0;
            }
        }; // Possible, but it must implement non-default methods!

        System.out.println(10 + 5 + "I: " + i);

        // =============================================================================================================

        A a = new A();
        //C c1 = (C)a;    // ClassCastException!
        //c1.meth();

        // =============================================================================================================

        boolean canBirdFly = bird instanceof Fly;
        System.out.println(canBirdFly);

        // =============================================================================================================

        Bird bird = new Bird();
        boolean isAnimal = bird instanceof Animal;
        boolean canFly = bird instanceof Fly;
        boolean isObject = bird instanceof Object;

        System.out.println("Bird is Animal? " + isAnimal);
        System.out.println("Bird can fly? " + canFly);
        System.out.println("Bird is Object? " + isObject);

        Animal animal = new Animal();
        isAnimal = animal instanceof Animal;
        canFly = animal instanceof Fly;
        isObject = animal instanceof Object;

        System.out.println("Animal is Animal? " + isAnimal);
        System.out.println("Animal can fly? " + canFly);
        System.out.println("Animal is Object? " + isObject);

        // =============================================================================================================

        System.out.print(In2.print());
    }
}

interface InterfaceA {
    /** FINAL must be initialized!! */
    public static final int numberA = 0;
    int numberB = 10;

    /** non static, non default methods must be abstrace / have NO body! */
    //public int myMethod(int i) { return i; }

    /** static and default methods must have a body */
    public static int getNumberA() { return numberA; }
    public default int defaultMethodB() { return numberB; }

    /** non static and non default methods may ONLY have public, not even public is not required */
    public int myMethod(int i);

    /** EEK! Cannot override a member of Object! */
    //public default String toString() { return "I"; }
}

abstract class AbstractA implements InterfaceA { // an abstract must not implement any methods! ;)
    private String name;
    public AbstractA() {    // constructor cannot be directly called! Only from sub classes!
        name = "AbstractA";
    }

    // public void print(); // Method declarations are not valid!

    public String getName() { return name; }
}

// =====================================================================================================================

interface I {
    void meth();
}

class A implements I {

    void A(String s) { }

    @Override
    public void meth() {

    }
}

class C extends A implements I {
    @Override
    public void meth() {
        System.out.println("C");
    }
}

// =====================================================================================================================

class Animal {}

interface Fly {}

class Bird extends Animal implements Fly {}

// =====================================================================================================================

interface In1 {
    public static void print() {
        System.out.println("Interface 1");
    }
}

interface In2 extends In1 {
    static String print() {
        return "Interface 2";
    }
}