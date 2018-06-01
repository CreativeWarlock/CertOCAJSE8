public class SwitchCase {



    public static void main(String[] args) {
        System.out.println("Chapter XXX - Switch Case");

        SwitchCaseWithCompileTimeConstants();

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
