package Objective_1_Java_Basics.Subobjective_1;

public class ScopeOfVars {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html

    public static void main(String [ ] args) {
        System.out.println("Chapter 1.1 - Scope of Variables");

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
        Phone _p1 = new Phone();
        Phone $p2 = new Phone();
        int _6 = 6;

        System.out.println("_p1.softKeyBoard: " + _p1.softKeyBoard);
        System.out.println("$p2.softKeyBoard: " + $p2.softKeyBoard);
        _p1.softKeyBoard = true;
        System.out.println("_p1.softKeyBoard: " + _p1.softKeyBoard);
        System.out.println("$p2.softKeyBoard: " + $p2.softKeyBoard);
        System.out.println("_p1.softKeyBoard: " + _p1.softKeyBoard);
        System.out.println("Phone.softKeyBoard: " + Phone.softKeyBoard);

        Phone phoneNull = null;
        System.out.println("phoneNull.softKeyBoard: " + phoneNull.softKeyBoard);
    }
}

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

// =============================================================================================================
// Variables with different scope:
// -------------------------------

class ScopeTest1 {
    static boolean var1 = true;
    //boolean var1 = true; // NOT VALID -> var1 is already defined

    void method1(int weight) {
        //int weight = 10; // NOT VALID -> cannot shadow parameter argument!
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

class Rock {
    static int x = 9;

    public static void main(String [ ] a) {
        //int[] a = {1, 2, 3}; // COMPILE ERROR -> cannot shadow parameter argument!
        //System.out.println(a);

        int x = 8;
        for(;x>-1;x--) // the for-loop picks the x with the closest scope which is that of the method!
            System.out.print(x);

        for(int y = 3;y>-1;y--);    // <-- nasty semicolon!
            //System.out.print(y); //EEEK!
    }
}

