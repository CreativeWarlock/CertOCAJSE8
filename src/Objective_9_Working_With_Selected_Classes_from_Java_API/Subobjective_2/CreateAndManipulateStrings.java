package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        robot = robot.replace("AD", "ED");
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

        String s1 = "Bla";
        String s2 = "Bla";  // Uses same String pool -> References will be equal!!
        //String s2 = new String("Bla");

        if (s1 == s2)
            System.out.println("Hossa!");

        if (s1.hashCode() == s2.hashCode())
            System.out.println("Same HashCode!");

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

        /** ------------------------------------------------------------------------------------------------------ */

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

        /** ------------------------------------------------------------------------------------------------------ */

        /** Question 3: What happens if the following code is compiled and executed?
         * A) Compilation fails
         * B) It prints "A+B+C
         * C) It prints "-+A+B+C"
         * D) Exception is thrown
         * */
        String joint = String.join("+", "-", "A", "B", "C");
        System.out.println(joint);

        /** ------------------------------------------------------------------------------------------------------ */

        /** Question 4: What happens if the following code is compiled and executed?
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

        /** ------------------------------------------------------------------------------------------------------ */

        /** Question 5: How many Strings objects are created when reaching line 4?
         * A) 1
         * B) 2
         * C) 3
         * D) 4
         * E) 5
         * */

        String s = "Rock";      // (1)
        s.concat("Land");        // (2)
        s.toLowerCase();        // (3)
        System.out.println(s);  // (4)

        // Answer:  Line 1 creates a new String object and assigns the value "Rock". At line 2, two String objects are created ("Land" and "RockLand").
        //          At line 3, a new String object is created ("rock");
        //          In total 4 objects are created -> Answer D

        /** ------------------------------------------------------------------------------------------------------ */

        /** Question 6: What is the result of the following code?
         * A) ockL
         * B)  ockL
         * C) ckLa
         * D) An exception.
         * E) Compilation fails.
         * */

        StringBuilder sb = new StringBuilder("RockLand");
        char[] ch = new char[4];
        //sb.getChars(1, 5, ch, 1);
        for (char c : ch) {
            System.out.println(c);
        }

        //Answer: getChars() copies characters from a character sequence (here: 'sb') into the destination character array (here: 'ch').
        // The first character to be copied is at index srcBegin (here: 1);
        // The last character to be copied is at index scrEnd-1 (here: 5);
        // The total number of characters to be copied is srcEnd-srcBegin (here: 5-1 = 4)
        // The index offset in the destination character array is 1 the 4 characters to be copied will lead to an ArrayIndexOutOfBoundsException
        // since the character array has only 4 elements (from index 0 to 3). Therefor answer D is correct.

        //Character myCharacter = new Character("A");
        Character myCharacter = new Character('a');
        Character.isLetterOrDigit(myCharacter);
        System.out.println("Character.isLetterOrDigit(myCharacter): " + Character.isLetterOrDigit(myCharacter));

        int capitalA = 97;
        char fromInt = (char)capitalA;
        System.out.println("fromInt: " + fromInt);

        /** ------------------------------------------------------------------------------------------------------ */

        /** Question 7: What is the result of the following code?
         * A) 12
         * B) 123
         * C) An exception.
         * D) Compilation fails.
         * */

        String part1 = "1";
        String part2 = part1.concat("2");
        part2.concat("3");  // Nice trick: Since String class is immutable -> this concat(..) method cannot alter the string! It HAS TO return a new string!!
        System.out.println("Part2: " + part2);

        /** ------------------------------------------------------------------------------------------------------ */

        String compound = "";
        compound += 2;
        compound += 6+6;
        compound += 'A'+3;
        compound += false;
        System.out.println("compound: " + compound);

        /** ------------------------------------------------------------------------------------------------------ */

        String substring  = "abcdef".substring(4);
        String substring2 = "abcdef".substring(1,2);

        int n = 808;
        System.out.format("%d", n);
        System.out.format("%06d", n); // fills up the number n to 6 decimals

        System.out.println();

        /** ------------------------------------------------------------------------------------------------------ */

        StringBuilder force = new StringBuilder("Go with tho Forth");
        System.out.println("force.lastIndexOf('o'): " + force.lastIndexOf("o", 0));
        force.insert(force.lastIndexOf("o"), true);
        System.out.println(force.toString());

        /** ------------------------------------------------------------------------------------------------------ */

        String z808 = "1Z0-808";
        z808 = z808.replace("80", "81");
        //z808 = z808.substring(z808.indexOf("80"), z808.lastIndexOf("80"));
        System.out.println(z808);

        /** ------------------------------------------------------------------------------------------------------ */

        String ignoreMe = "bla";
        ignoreMe.indexOf("la");
        ignoreMe.indexOf('a', 4);
        ignoreMe.indexOf('a');
        System.out.println(ignoreMe);

        /** ------------------------------------------------------------------------------------------------------ */

        System.out.println("charAt(2): " + "abcdef".charAt(2));

        char[] chars2 = {'C', '3', 'P', '0'};
        StringBuilder charSB = new StringBuilder();
        charSB.append(chars2, 0, chars2.length - 1);
        charSB.append('O');
        charSB.append(" \\o/");
        charSB.setLength(4);
        charSB.insert(0, "The annoying ");
        charSB.delete(0, 1);
        String prefix = charSB.substring(4); // no effect on the StringBuilder object!
//        sb1.insert(5, "XXX");
        System.out.println(charSB);
        System.out.println(prefix);
    }
}