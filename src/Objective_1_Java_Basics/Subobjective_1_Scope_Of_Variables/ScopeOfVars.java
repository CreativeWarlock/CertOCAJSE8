package Objective_1_Java_Basics.Subobjective_1_Scope_Of_Variables;

class Phone {
    private boolean tested;
    static boolean softKeyBoard = true;

    public void setTested(boolean val) {
        tested = val;
    }

    public boolean isTested() {
        //val = false;
        return tested;
    }
}

public class ScopeOfVars {

    public static void main(String [ ] args) {
        System.out.println("Chapter 3.1 - Scope of Variables");

        /** Available scopes for variables:
         *      - local (aka method-local variables)
         *      - method parameters (aka method arguments)
         *      - instance variables (aka attributes, fields, nonstatic variables)
         *      - class variables (aka static variables)
         */

        /**=============================================================================================================
        // Local variables:
        // ----------------

        // Local variables within if-Block -> Not available in else-block

        // Local variable inside method not accessible from outside

        // Forward reference not allowed in Java
        //      int a = b;
        //      int b = 20;

        // =============================================================================================================
        // Method parameters:
        // ------------------
        //      - only visible within its method */

        // See class Phone

        /**=============================================================================================================
        // Instance variables:
        // -------------------

        // see Phone.tested <-- instance variable; scope: class Phone and not outside

        // Scope of instance variable is no longer than that of a local variable or method parameter!

        // =============================================================================================================
        // Class variables:
        // ----------------
        //      - uses keyword static
        //      - belongs to a class, not individual objects of the class
        //      - is SHARED across all objects of the class
        //      - NO object needed to access it

        */

        Phone.softKeyBoard = true;
        Phone p1 = new Phone();
        Phone p2 = new Phone();

        System.out.println("p1.softKeyBoard: " + p1.softKeyBoard);
        System.out.println("p2.softKeyBoard: " + p2.softKeyBoard);
        p1.softKeyBoard = true;
        System.out.println("p1.softKeyBoard: " + p1.softKeyBoard);
        System.out.println("p2.softKeyBoard: " + p2.softKeyBoard);
        System.out.println("p1.softKeyBoard: " + p1.softKeyBoard);
        System.out.println("Phone.softKeyBoard: " + Phone.softKeyBoard);

        Phone phoneNull = null;
        System.out.println("phoneNull.softKeyBoard: " + phoneNull.softKeyBoard);
    }
}

// =============================================================================================================
// Variables with different scope:
// -------------------------------

class ScopeTest1 {
    static boolean var1 = true;
    //boolean var1 = true; // NOT VALID

    void method1(int weight) {
        //int weight = 10; // NOT VALID
    }
}

class ShadowClass {
        static boolean shadowVar = true;
        String number = "006";

        void shadowMethod() {
            boolean shadowVar = false;  // shadowing the class variable
            String number = "007";      // shadowing the instance variable
        }
}

