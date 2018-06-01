package Objective_6_Working_With_Methods;

public class OverloadedMethods {

    public static void main(String[] args) {
        System.out.println("Chapter 6.4 - Create Methods with Arguments and Return Values - including Overloaded Methods");
    }

    /**
     * Rules for overloaded methods:
     * - must have method parameter different from one another
     * - may or may not define a different return type
     * - may or may not define different access levels
     * - can't be defined by only changing their return type or access modifiers or both
     *
     */

    // =================================================================================================================
    void    myMethod() { }
    //boolean myMethod() { return true; } // Can not have myMethod() with 2 different return types:
    void    myMethod(double value) { }
    void    myMethod(int value) { }
    byte    myMethod(Integer value) { return 0; } // A changed Return type is independent from the method parameter list

    // =================================================================================================================
}