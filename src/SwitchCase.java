public class SwitchCase {



    public static void main(String[] args) {
        System.out.println("Chapter XXX - Switch Case");

        SwitchCaseWithCompileTimeConstants();

        StringComparisonInSwitch();
    }

    private static void StringComparisonInSwitch() {
        String s = "A";

        final String c1 = "A";      // Must be final -> Compile time constant!
        final String c2 = "B";
        final String c3 = "C";

        switch(s) {
            case c1: { System.out.print("A"); };
            default: { System.out.print("default "); };
            case c2: { System.out.print("B"); }; break;
            case c3: { System.out.print("C"); };
        }
    }

    private static void SwitchCaseWithCompileTimeConstants() {
        final int x = 0;
        final int y = 2;
        int i = x;

        switch(i) {
            // ------------------------
            // insert code here
            // case x+1: System.out.println("A"); // Duplicate label 1!
            // case x+2: System.out.println("A"); // Duplicate label 2!
            // case i+1: System.out.println("A"); // no constant expression!
            case x-1: System.out.println("A");
            // ------------------------

            case 1 : System.out.println("B");
            default: System.out.println("B"); break;
            case y : System.out.println("C");
        }
    }
}
