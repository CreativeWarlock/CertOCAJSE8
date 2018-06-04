package Objective_1_Java_Basics.Subobjective_5;

public class CompareAndContrastFeaturesAndComponentsOfJava {

    // https://docs.oracle.com/javase/tutorial/getStarted/intro/definition.html

    public static void main(String [ ] args) {
        System.out.println("Objective 1.5 - Compare and Contrast Features and Components of Java, e.g. platform independence, OO, encapsulation, etc.");

        /**
         * Java Buzzwords:
         *
         * - Simple
         * - Object oriented:
         *      + Inheritence: A class uses fields and methods of another class
         *      + Polymorphism: Subclasses of a class can define their own unique behavior, yet share some of the same
         *                      functionality of the parent class
         *      + Abstraction: Hiding certain details and showing only essential features of the object
         *      + Encapsulation: Wrapping data and the code that operates on the data into a single entity
         *
         * - distributed
         * - interpreted (byte code interpreter)
         * - robust (extensive compile time checking + runtime checking + no explicite pointer types + GC to dispose unused object)
         * - secure (cannot be invaded from the outside; in network environment: code is secure from intrusion by unauthorized code)
         * - architecture neutral (Java runs on a variety of hardware/software platforms; uses architecture neutral format -> byte code)
         * - platform independent (portable)
         * - high performance
         * - multi threaded
         * - dynamic:   While Java compiler is strict in its compile time checking,
         *              the language and runtime system is dynamic in their linking stages
         *              -> Classes are linked only as needed
         *              -> New modules can be linked in on-demand from a variety of sources even from across a network
         */
    }

    /** Questions:
     *
     *  The platform independent feature of Java means that a Java program always behaves the exact same way
     *  on any platform.
     *  a) True
     *  b) False
     *
     *  Despite Java having an API that is unanimous on all platforms,
     *  each platform may have distinct features that other platforms do not have, therefore answer b) is correct.
     */
}

