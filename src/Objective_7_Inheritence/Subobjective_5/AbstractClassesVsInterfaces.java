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
         * type itself  implicitly abstract         must have 'abstract class'
         *
         * Fields       implicitly                  may be non-public,
         *              public static final         non-static and non-final
         *
         * Methods      automatically public,       may be declared with ANY
         *              must not have any other     access modifier; must carry 'abstract' if no body
         *              modifier
         *
         * Inheritance  Person class may implement       Person class can only extend
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

        /** Instantiating is possible, but we must implement all the abstract methods! */
        InterfaceA interfaceA = new InterfaceA() {
            @Override
            public int publicAbstractInterfaceMethod() {
                return 0;
            }
        };

        /** Person static method can only be invoked if the class contains this interface! */
        //System.out.println("MethodB: " + interfaceA.getNumberA());

        System.out.println("MethodB: " + interfaceA.getNumberB());

        // =============================================================================================================

        Person person = new Person();
        System.out.println("Person's getAge: " + person.getAge());

        /** Does it compile or not? */
        //Student student = (Student)person;
        //System.out.println("Student's getAge: " + student.getAge());

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

    /** VARIABLES are always public static final (PSF)! */
    public static final int numberA = 0;

    //protected int x = 10; // NOT valid!
    //int numberB; //must be initialized!
    int numberB = 10;

    //InterfaceA() {}   // Constructor not allowed
    //default InterfaceA() {}   // not allowed on constructor / in interfaces!

    /** METHODS are always PUBLIC (automatically added) and ABSTRACT!! */
    int publicAbstractInterfaceMethod();
    //int myMethod(int i) { return i; }  // not abstract

    /** DEFAULT and STATIC methods must have a BODY! */
    default int getNumberB() { return numberB; }
    static int getNumberA() { return numberA; }      // static methods may be invoked on containing interface class only
    /** default + static => illegal */
    // default static int defaultMethod() { return numberB; }

    /** Careful! Cannot override members of Object!!! */
    //public default String toString() { return "Interface"; }
    //public default boolean equals(Object o) { return false; }
}

abstract class AbstractA implements InterfaceA { // an abstract does not need to implement any of the interface's methods! ;)
    private String name;
    /** abstract is not allowed on variables */
    //abstract int i = 5;

    final static float f = 5.0f;
    final short s = 10;

    /** Constructor can only be called from sub classes! */
    public AbstractA() {
        name = "AbstractA";
    }

    /** Methods without body must have abstract modifier */
    abstract Number getAbstractNumber();
    /** Non-abstract method declarations are not allowed! */
    //public Number getAbstractNumber();

    public int getNumberB() { return numberB; }
    public String getName() { return name; }
}

abstract class AbstractB extends AbstractA {
    abstract Number getAbstractNumber();
}

// =====================================================================================================================

interface Interface {
    int age = 17; // PSF
    int getAge();
}

class Person implements Interface {
    //int age = 19; // would overshadow 'age' from Interface
    Person() {
        //age = 21; // does not compile -> age is PSF!
    }

    public int getAge() { return age; }
}

class Student extends Person implements Interface {
    int field = 18;

    // is not obligatory to override
    @Override
    public int getAge() { return field; }
}

// =====================================================================================================================

class Animal implements Pooping {
    public void eat() throws Exception { System.out.print("Animal eats"); }

    @Override
    /** must be public (like in the interface)! */
    public void poops() {
        System.out.println("is pooping ");
    }
}

interface Pooping {
    void poops();
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