package Objective_6_Methods_And_Encapsulation.Subobjective_3;

public class CreateAndOverloadConstructors {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html

    CreateAndOverloadConstructors() {} // valid
    //private CreateAndOverloadConstructors() {} // valid

    public static void main(String[] args) {
        System.out.println("Chapter 6.3 - Create and Overload Constructors; Differentiate between default and user defined constructors");

        /**
         * Constructors:
         * -------------
         * - use the name of the class
         * - have no return type
         * - multiple constructors may be declared for the same class, but their parameter signature must be different
         *
         * Default constructor:
         * --------------------
         *
         * - if no c'tor is explicitly declared:
         *      1. the compiler provides a no-argument default constructor
         *      2. this default constructor calls the c'tor of the super class
         *
         * - The default constructor may be overridden
         *
         * */

        /** Question: Which of the following modifiers can be specified on a constructor?
         *
         * a) static
         * b) abstract
         * c) final
         * d) none of above
         *
         * a) no, because a c'tor is always invoked with respect to an object -> so static makes no sense for c'tors!
         * b) no, because if a c'tor were abstract we could never implement it
         * c) no, because a c'tor is never inherited -> final keyword is not applicable here!
         * d) yes
         * */


    }
}