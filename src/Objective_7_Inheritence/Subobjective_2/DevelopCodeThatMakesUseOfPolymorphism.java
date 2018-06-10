package Objective_7_Inheritence.Subobjective_2;

public class DevelopCodeThatMakesUseOfPolymorphism {

    // https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
    // https://docs.oracle.com/javase/tutorial/java/IandI/override.html
    // https://www.tutorialspoint.com/java/java_polymorphism.htm

    public static void main(String[] args) {
        System.out.println("Chapter 7.2 - Develop code that makes use of polymorphism, overrides methods and " +
                "differentiates between the type of a reference and the type of an object");

        /**
         * Polymorphism:
         * -------------
         *
         * - is the ability for a method to behave differently based on the actual object it is invoked on (on runtime!).
         *
         * */

        SuperClass object1 = new SubClass1();
        SuperClass object2 = new SubClass2();
        object1.print();
        object2.print();

        /**
         * Method Overriding:
         *
         * - is a mechanism where an instance method in a subtype with the same name as an instance method in a supertype
         * replaces the behavior of the inherited method with its own
         *
         * - must return a value of the same type as, OR a subtype of, the type that is returned by the overridden method.
         * - in addition: The access specifier for an overriding method can allow more, but not less, access than the overridden method.
         *
         */

        OverridingSubClass subClass = new OverridingSubClass();
        subClass.printMe();

        /**
         * Reference Type vs. Object Types
         *
         * - Reference Type is the type of the variable referencing an object
         * - Object Type is the type of the referenced object at runtime
         *
         * - an object can be assigned to a reference whose type is the same as, or a subtype of, the object type.
         *
         */

        Number number = new Integer(0);
        number = new Float(0F);

        // -----------------------------------

        Super myObject = new Sub();
        myObject.print();

        // -----------------------------------

        /** Question: Which of the following declarations and initializations are valid? */
        Object myString = new String("Hello World!");
        //Long myInt = new Integer(0);
        //Number myBool = new Boolean(false);
    }
}

class SuperClass {
    //protected String field = "Super class";
    protected void print() {
        //empty body!
    }
}

class SubClass1 extends SuperClass {
    protected String field = "Sub class 1";
    protected void print() {
        System.out.println(field);
    }
}

class SubClass2 extends SuperClass {
    protected String field = "Sub class 2";

    protected void print() {
        System.out.println(field);
    }
}

// =====================================================================================================================

class OverrideMe {
        protected void printMe() {
            System.out.println("Printed from superclass 'OverrideMe'");
        }
}

class OverridingSubClass {
    protected void printMe() {
        System.out.println("Printed from subclass 'OverridingSubClass'");
    }
}

// =====================================================================================================================

/** What happens when the following code is compiled and executed?
 *
 * Super myObject = new Sub();
 * myObject.print();
 *
 * a) prints 0
 * b) prints 1
 * c) Compilation fails
 *
 * */

class Super {
    public int value = 0;
    public void print() {
        System.out.println(value);
    }
}

class Sub extends Super {
    int value = 1;
    /*void print() { // trying to assign weaker access privileges!
        System.out.println(value);
    }*/
}

// Answer: c)
