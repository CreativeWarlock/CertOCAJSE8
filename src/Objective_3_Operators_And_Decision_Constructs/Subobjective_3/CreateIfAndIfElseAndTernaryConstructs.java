package Objective_3_Operators_And_Decision_Constructs.Subobjective_3;

public class CreateIfAndIfElseAndTernaryConstructs {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html

    static String out = "";

    public static void main(String[] args) {
        System.out.println("Chapter 3.3 - Create If and Else and Ternary Constructs");

        /**
         * The if-then Construct
         * ---------------------
         * If a particular test evaluates to 'true' a certain section of code is executed
         * */
        int i = 1;
        if (i > 0) {
            System.out.println("Positive");
        }

        /**
         * The if-then-else Construct
         * --------------------------
         * Provides a secondary path of execution for if-then when the if clause evaluates to false
         * */
        i = -1;
        if (i > 0) {
            System.out.println("Positive");
        }
        else {
            System.out.println("Non-Positive");
        }

        /**
         * Ternary Operator
         * ----------------
         * Shorthand for if-then-else construct
         * syntax: condition ? value1 : value2
         * */
        i = -1;
        String output = i > 0 ? "Positive" : "Non-Positive";
        System.out.println(output);

        /** Question: What happens with the following code fragment? */
        int i1 = 1, i2 = 2;
        //if (i1 + i2)                // Compilation fails
            //System.out.println(i1);
        //else
            //System.out.println(i2);

        /** Question: What is printed in the following code? */
        i = 1; short s = 2;
        int number = i > s ? i : s;
        System.out.println(number);

        // -----------------------------------------------------------------------------------------------------------

        int x = 5, y = 8;

        if (x++ == 5)
            out += "1";
        if (x != 6) {}
            else if (x > 9) { out += 2; }
            else if (x < 9) { out += 3; }
            else if (x == 6) { out += 4; }
            else { out += 5; }

        System.out.println("If-Else-Stuff adding to out: " + out);
    }
}
