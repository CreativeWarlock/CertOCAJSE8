package Objective_7_Inheritence.Subobjective_1;

public class DescribeInheritenceAndItsBenefits {

    // https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html

    public static void main(String[] args) {
        System.out.println("Chapter 7.1 - Describe Inheritance and its Benefits");

        /**
         * Inheritence:
         * ------------
         * - is a mechanism allowing ONE type to acquire (or inherit) fields and methods from another
         * - the inherited type is called subtype
         * - the type whose members are inherited is called supertype
         * - uses 'extends' keyword
         *
         * Benefits:
         * ---------
         * + Inheritance allows members of a supertype to be reused in all its subtypes
         * + Subtypes may declare their own fields and methods (not accessible/visible within supertypes)
         *
         */

        SubClass sub = new SubClass();
        sub.print();

        SuperClass superClass = new SubClass();
        superClass.print(); // finds print in sub class

        //SuperClass pureSuperClass = new SuperClass();
        //SubClass sc = (SubClass)pureSuperClass; // cannot cast super class to subclass without ever being a subclass before!
        //sc.print();

        SubClass pureSubClass = new SubClass();
        SuperClass forcedCast2SuperClass = (SuperClass)pureSubClass;
        pureSubClass.print();
        forcedCast2SuperClass.print();

        SubClass realSubClass = new SubClass();
        System.out.println("realSubClass.field: " + realSubClass.field);
        // =============================================================================================================

        Animal bird = new Bird();
        bird.print();
        //bird.fly();                 // Animal does not know a method fly()!

        System.out.println();

        A a = new B();
        a.method();
    }
}

class SuperClass {
    protected String field = "SuperClass!";

    public SuperClass() {
        super();
    }
    public SuperClass(String newField) {
        super();
        field = newField;
    }

    protected void print() {
        System.out.println(field);
    }
}

class SubClass extends SuperClass {

    //SubClass() {}

/*    SubClass(String field) {
        super(field);
    }*/

    String field = "I'm a Sub class..";
    protected void print() {
        //super.print();
        System.out.println(field);
    }
}

// =====================================================================================================================

class Bird extends Animal {
    // Some extra madness
    static { System.out.println("Static Bird block. "); }
    Bird() { System.out.println("Bird c'tor. ");}

    void print() {
        System.out.print("Bird");
    }
    void fly() {
        System.out.print("Bird flies");
    }
}

class Animal {
    // Some extra madness
    static { System.out.println("Static Animal block. "); }
    Animal() { super(); System.out.println("Animal c'tor. ");}

    void print() {
        System.out.println("Animal");
    }
}

// =====================================================================================================================

/** Question: Does the following Sub class inherit the member field 'value' from the Super class?
 *
 * A) Yes
 * B) No
 *
    package com
    public class Super {
        String value;
    }

    package com.RockLand
    public class Me extends Super { }

    package com
    public class Sub extends Me { }

 *
 */
    // Answer: No, since field 'value' has private package access only and
    //         and class 'Me' is in a different package than Super class.
    //         Therefor the field 'value' is not inherited down to Sub class.

class A {
    static void method() {
        System.out.print(" A B");
    }
}

class B extends A{
    protected static void method() {
        System.out.print(" C D");
    }
}