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
         * */

        SubClass sub = new SubClass();
        sub.print();
    }
}

class SuperClass {
    protected String field = "SuperClass!";
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

/**

    package com
    public class Super {
        String value;
    }

    package com.whizlabs
    public class Me extends Super { }

    package com
    public class Sub extends Me { }

    // Question: Does the Sub class inherit the value field from the Super class?

    // a) Yes
    // b) No
 *
 */
    // Answer: No, since field 'value' has private package access only and
    //         and class 'Me' is in a different package than Super class.
    //         Therefor the field 'value' is not inherited down to Sub class.
}