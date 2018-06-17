package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_2;

import java.util.Arrays;

public class CreateAndManipulateStrings {

    // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html

    public static void main(String[] args) {
        System.out.println("Chapter 9.2 - Create and manipulate Strings");

        /**
         * Creating a String:
         * ------------------ */

        /** Use a String literal value: */
        String robot = "Wall A";

        /** Use a String constructor: */
        String robot2 = new String("Avo");

        /** Replacement Methods:
         * ---------------------
         * Characters of the current string may be replaced using 'replace', 'replaceAll' or 'replaceFirst': */
        robot = robot.replace('A', 'E');
        robot2 = robot2.replaceFirst("A", "E");
        robot2 = robot2.replace("Evo", "Eva");

        robot = robot.replaceAll("\\s", "-");
        System.out.println(robot);
        System.out.println(robot2);

        /** Method 'concat' concatenates the specified string to the end of the current string: */
        String robots = robot.concat("+").concat(robot2);
        System.out.println("A cute couple: " + robots);

        /** Method 'split' splits the current string around matches of the given regular expression: */
        String[] robotArray = robots.split("\\+");
        System.out.println("Robot array after split: " + Arrays.deepToString(robotArray));

        /** Method 'join' returns a new String composed of copies of the CharSequence elements joined together with
         * a copy of the specified delimiter: */
        //String couple = String.join('+', robot, robot2); // Nope.
        String couple = String.join(" + ", robot, robot2); // delimiter MUST be a CharSequence!
        System.out.println("A cute couple: " + couple);

        /** Method 'format' returns a formatted String using the specified format string and arguments: */
        String credits = String.format("And the actors are: %2$s and %s.", robot, robot2);
        System.out.println(credits);

        /** -------------------------------------------------------------------------------------------- */

        /** Question 1: What happens if the following code is compiled and executed?
         * A) Jabba The Hutt
         * B) Jabba-The Hutt
         * C) Jabba-The-Hutt
         * D) Exception is thrown
         * */

        String thug = "Jabba The Hutt";
        String newThug = thug.replace("\\s", "-");  // ... nope!
        System.out.println(newThug);

        /** Question 2: What happens if the following code is compiled and executed?
         * A) It prints number 0
         * B) It prints number 1
         * C) It prints number 8
         * D) Exception is thrown
         * */
        String boring = "AAA";
        String[] nonwhiteMatch = boring.split("\\S"); // \s stands for whitespace chars. \S for non-whitespace ;)
        System.out.println(nonwhiteMatch.length);

        String exciting = "A BB C";
        String[] nonwhiteMatch2 = exciting.split("\\S");
        System.out.println(nonwhiteMatch2.length);

        String uhmOkay = "A BB C DD";
        String[] nonwhiteMatch3 = uhmOkay.split("\\S");
        System.out.println(nonwhiteMatch3.length);

        String wow = "A BB C DED";
        String[] nonwhiteMatch4 = wow.split("\\S");
        System.out.println(nonwhiteMatch4.length);

        /** Question 3: What happens if the following code is compiled and executed?
         * A) Compilation fails
         * B) It prints "A+B+C
         * C) It prints "-+A+B+C"
         * D) Exception is thrown
         * */
        String joint = String.join("+", "-", "A", "B", "C");
        System.out.println(joint);

        /** Question 3: What happens if the following code is compiled and executed?
         * A) Compilation fails
         * B) It prints "A+B+C
         * C) It prints "-+A+B+C"
         * D) Exception is thrown
         * */
        String comparison = String.format("%1$d<%d", 1,2);
        System.out.println(comparison);

        String comparison2 = String.format("%2$d<%1$5d", 1,2);
        System.out.println(comparison2);

        String comparison3 = String.format("%d<%d", 1,2);
        System.out.println(comparison3);

        String holyMoly = String.format("%4$10s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
        System.out.println(holyMoly);
    }
}