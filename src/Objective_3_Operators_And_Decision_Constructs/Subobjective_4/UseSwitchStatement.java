package Objective_3_Operators_And_Decision_Constructs.Subobjective_4;

public class UseSwitchStatement {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html

    static final int z = 0;

    public static void main(String[] args) {
        System.out.println("Chapter 3.4 - Use a Switch Statement");

        /**
         * The switch statement is a control flow statement that can have several possible execution paths:
         *
         * It works with these data types (BSC-IES):
         * - byte / Byte
         * - short / Short
         * - char / Character
         * - int / Integer
         * - enum
         * - String
         *
         * A statement *in the body* of a switch can be labeled with one or more 'case' or 'default' labels
         *
         * The switch statement evaluates its expression,
         *  then executes all statements that follow the matching 'case' label
         *
         *  General Statement about switch (according to practice tests:)
         *  - A switch statement is more efficient than a set of nested ifs
         *
         */

        Gender gender = Gender.UNISEX;

        switch(gender) {
            case UNISEX:
                System.out.print("Unisex ");
            case FEMALE:
                System.out.print("Female ");
                break;
            case MALE:
                System.out.print("Male");
                break;
            default:
                System.out.print("No sex");
                break;
        }

        System.out.println();

        /*int i = 2;
        switch(i%2 == 0) { // Found boolean! Does not work!

        }*/

        String s = "Rock";
        final String finalCase = "Land";
        switch(s) {
            default:
                System.out.println("Java");
            case "Rock":
                System.out.print("OCAJP ");
            case finalCase:
                System.out.println("Rocks!");
            //default:  // 2nd default is NOT VALID
                //System.out.println("Another default?");
        }

        /** --------------------------------------------------------------------------------------------------------- */

        float f =2.4f;
        f++;                // incrementor on float works! :D
        System.out.println("f: " + f);

        //final int x = 0;
//        final int x;
//        x = 0;
        final int y = 2;

        for (int x = 0; x < 3; x++) {
            switch (x) {
                case 0:     // fails to compile when uncommenting above because x is not a compile time constant!! (since x was assigned afterwards)
                {
                    System.out.print("A");
                }
                case 1: {
                    System.out.print("B");
                }
                default:
                    System.out.print("default");
                    break;
                case y:
                    System.out.print("C");
                    //case z:                   // Won't compile because duplicate case '0'
                    System.out.print("Z");
                    switch (2) {
                        case 1:
                            System.out.print("Nested switch");
                    }
            }
        }

        /** --------------------------------------------------------------------------------------------------------- */

        final int array[] = {1, 2, 3};

        switch(2) {
//            case array[0] :               // constant expression required!
//                System.out.print("A");
        }

        /** --------------------------------------------------------------------------------------------------------- */

/*        double d = 42.42;

        switch(d) {
            case 1 :
                System.out.print("A");
        }*/
    }
}

enum Gender { FEMALE, MALE, UNISEX }