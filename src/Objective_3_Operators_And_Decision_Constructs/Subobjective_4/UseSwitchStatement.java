package Objective_3_Operators_And_Decision_Constructs.Subobjective_4;

public class UseSwitchStatement {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html

    public static void main(String[] args) {
        System.out.println("Chapter 3.4 - Use a Switch Statement");

        /**
         * The switch statement is a control flow statement that can have several possible execution paths
         *
         * works with the data types:
         * - byte / Byte
         * - short / Short
         * - char / Character
         * - int / Integer
         * - enum
         * - String
         *
         * A statement _in the body_ of a switch can be labeled with one or more 'case' or 'default' labels
         * The switch statement evaluates its expression,
         *  then executes all statements that follow the matching 'case' label
         *
         * */

        Gender gender = Gender.UNISEX;

        switch(gender) {
            case MALE:
                System.out.println("Male");
                break;
            case FEMALE:
                System.out.println("Female");
                break;
            case UNISEX:
                System.out.println("Unisex");
                break;
            default:
                break;
        }

        /*int i = 2;
        switch(i%2 == 0) { // Found boolean! Does not work!

        }*/

        String s = "RockLand";
        switch(s) {
            default:
                System.out.println("Java");
            case "RockLand":
                System.out.println("OCAJP");
            //default:  // NOT VALID
                //System.out.println("Another default?");
        }


    }
}

enum Gender { FEMALE, MALE, UNISEX }