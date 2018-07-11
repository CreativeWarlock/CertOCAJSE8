package Objective_7_Inheritence.Subobjective_5;

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
         * Fields       automatically               may be non-public,
         *              public static final         non-static and non-final
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

        InterfaceA interfaceA = new InterfaceA() {
            @Override
            public int myMethod(int i) {
                return 0;
            }
        }; // Possible, but it must implement non-default methods!

        System.out.println(10 + 5 + " Interface: " + interfaceA);

        //System.out.println("MethodB: " + interfaceA.getNumberA()); // static methods may be invoked on containing interface class only
        System.out.println("MethodB: " + interfaceA.defaultMethodB());

        // =============================================================================================================

        A a = new A();
        //C c1 = (C)a;    // ClassCastException!
        //c1.meth();
        System.out.println("A's MethodB: " + a.defaultMethodB());

        // =============================================================================================================

        boolean canBirdFly = bird instanceof Fly;
        System.out.println(canBirdFly);

        // =============================================================================================================

        //Fly f = new Bird();
        Fly f = new Fly() {}; // must have {} as an implementation for the interface Fly
        f.fly();

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

        System.out.println(InterfaceA.numberA);
        System.out.println(InterfaceA.numberB);

        // =============================================================================================================

        Animal animDog = new Dog();
        Dog doggy = new Dog();
        doggy.eat();
        //animDog.eat();        unhandled exception!

        // =============================================================================================================

        System.out.print(In2.print());
        System.out.println();

        // =============================================================================================================

        new Extension().print();
        System.out.println();
    }
}

abstract interface InterfaceA {

    public static final int numberA = 0;

    /** it's always FINAL -> must be initialized!! */
    //int numberB;
    int numberB = 10;

    //InterfaceA() {}   // not valid

    //protected int x = 10; // NOT valid!

    /** non static, non default methods must be abstrace / have NO body! */
    //public int myMethod(int i) { return i; }
    /** non static and non default methods may ONLY have public, but public is not required */
    public int myMethod(int i);

    /** STATIC and DEFAULT methods must have a BODY! */
    public static int getNumberA() { return numberA; }
    public default int defaultMethodB() { return numberB; }
    //public default static int defaultMethodc() { return numberB; }

    /** EEK! Cannot override members of Object!!! */
    //public default String toString() { return "Interface"; }
    //public default boolean equals(Object o) { return false; }
}

abstract class AbstractA implements InterfaceA { // an abstract does not need to implement any of the interface's methods! ;)
    private String name;
    //abstract int i = 5; // Abstract is not allowed on variables

    final static float f = 5.0f;
    final short s = 10;

    public AbstractA() {    // constructor cannot be directly called! Only from sub classes!
        name = "AbstractA";
    }

    abstract Number getAbstractNumber();
    //public Number getAbstractNumber(); // Non-abstract method declarations are not allowed!

    public int defaultMethodB() { return numberB; }

    public String getName() { return name; }
}

abstract class AbstractB extends AbstractA {
    abstract Number getAbstractNumber();
}

// =====================================================================================================================

interface Interface {
    void meth();
}

class A implements Interface {

    void A(String s) { }

    @Override
    public void meth() {

    }

    public int defaultMethodB() { return 7; }
}

class C extends A implements Interface {
    @Override
    public void meth() {
        System.out.println("C");
    }
}

// =====================================================================================================================

interface Pooping {
    void poops();
}

class Animal implements Pooping {
    public void eat() throws Exception { System.out.print("Animal eats"); }

    @Override
    public void poops() {                   // must be public!
        System.out.println("is pooping ");
    }
}

interface Fly {
    default void fly() { System.out.println("Flying."); }
}

class Bird extends Animal implements Fly {
    @Override
    public void fly() {

    }
}

class Dog extends Animal {
    public void eat() { System.out.print("Dog eats"); }
}

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

// =====================================================================================================================

abstract class Base {
    Base() {
        System.out.print("1");
    }

    abstract void print();
}

class Extension extends Base {

    Extension() {
        System.out.print("2");
    }

    @Override
    void print() {
        System.out.print("3");
    }
}