package Objective_6_Methods_And_Encapsulation.Subobjective_4;

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
         *  + Top Level: public or private-package
         *  + Member Level: public, protected, private-package or private
         *
         *  + A class cannot be private or protected except nested class!
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
         *
         * */


    }
}