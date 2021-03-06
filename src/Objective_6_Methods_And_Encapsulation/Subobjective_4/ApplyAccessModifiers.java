package Objective_6_Methods_And_Encapsulation.Subobjective_4;

import Objective_6_Methods_And_Encapsulation.Subobjective_2.Data;

public class ApplyAccessModifiers {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html

    public static void main(String[] args) {
        System.out.println("Chapter 6.4 - Apply Access Modifiers");

        /**
         * Access Modifiers:
         * =================
         *
         * Access control levels:
         * ----------------------
         *  + Top level class: public or private-package
         *  + Member level: public, protected, private-package or private
         *
         * IMPORTANT:
         *  + A class CANNOT be private or protected!
         *  + A nested class CAN BE private or protected!
         *
         *  + A static nested class is behaviorally a top level class!
         *      -> it interacts with the instance members of its outer class (and other classes)
         *      just like any other top level class
         *
         * + A method-local class can NOT access any local variables
         *
         *
         * Modifier permission:
         * --------------------
         *  + private:
         *          visible/accessible in its own type
         *  + default / package private:
         *          visible/accessible only within its OWN PACKAGE
         *  + protected:
         *          visible/accessible only within its OWN PACKAGE *OR* its SUB-TYPES of its type in OTHER PACKAGES
         *  + public:
         *          visible/accessible to all types in the application
         *
         * Table of Access Levels:
         * -----------------------
         *
         * Modifier 	Class 	Package   Subclass 	World
         * public 	      Y        Y         Y 	      Y
         * protected 	  Y        Y         Y 	      N
         * no modifier 	  Y        Y         N 	      N
         * private 	      Y 	   N         N 	      N
         *
         *  "Protected is like private package just with 'kids'".
         *  That means only inherited classes are allowed to access the parents' stuff = members of the superclass
         *
         * */

        InheritedData id = new InheritedData();
        // id.instanceValue = 5; //cannot access due to protected modifier only
    }

    // A static NESTED class is behaviorally a top level class
    static class NestedStaticClass {
        NestedStaticClass() {
            // Can interact with the instance members of its outer class (and other classes)
            ClassInSamePackage ac = new ClassInSamePackage();
            ac.myOtherInt = 6;
            ac.setMyOtherInt(4);
        }
    }
}

class InheritedData extends Data {
    public InheritedData() {
        //can access due to protected modifier
        instanceValue = 5;
    }
    void printInstanceValue() {
        //can access due to protected modifier
        System.out.println("super.instanceValue:" + super.getInstanceValue());
    }
}

/**
 * Using method-local classes can increase the readability of your code by keeping related parts together.
 * As a contrived example, suppose you have a method that needs to create a thread to do something in the background:
 */
class TestMethodLocalInnerClass {
    public static void main(String[] args) {

        // a method-local class

        class Greeter implements Runnable {
            private final String _greeted;

            public Greeter(String greeted) {
                super();
                _greeted = greeted;
            }

            public void run() {
                System.out.printf("Hello %s!\n", _greeted);
            }
        }

        new Greeter("world").run();
        new Greeter("dog").run();
    }
}