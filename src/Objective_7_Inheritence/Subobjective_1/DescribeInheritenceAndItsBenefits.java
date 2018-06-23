package Objective_7_Inheritence.Subobjective_1;

public class DescribeInheritenceAndItsBenefits {

    // https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html

    public static void main(String[] args) {
        System.out.println("Chapter 7.1 - Describe Inheritence and its Benefits");

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

//        SubClass sub = new SubClass();
//        sub.print();

        SuperClass subClass = new SubClass();
        subClass.print(); // finds print in sub class

        // =============================================================================================================

        Animal bird = new Bird();
        bird.print();
        //bird.fly();                 // Method fly() is not known to type Animal!
    }
}

class SuperClass {
    protected String field = "SuperClass!";

    public SuperClass() {
        super();
    }

    protected void print() {
        System.out.println(field);
    }
}

class SubClass extends SuperClass {

    protected String field = "Sub class..";
    protected void print() {
        super.print();
        System.out.println(field);
    }
}

// =====================================================================================================================

class Bird extends Animal {
        public void print() {
            System.out.print("Bird");
        }
        void fly() {
            System.out.print("Bird flies");
        }
}

class Animal {
    public void print() {
        System.out.print("Animal");
    }
}

// =====================================================================================================================

/** Question: Does the following sub class inherit the value field from the Super class?
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