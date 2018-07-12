package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_1;

import java.util.ArrayList;
import java.util.List;

public class ManipulateDataUsingStringBuilder {

    public static void main(String[] args) {
        System.out.println("Chapter 9.1 - Manipulate data using StringBuilder class and its methods");

        /**
         * StringBuffer:
         * -------------
         * - is a thread-safe, mutable sequence of characters
         * - is like a String, but can be modified
         * - at any point of time a StringBuffer contains some particular sequence of characters,
         *   but the length and content of the sequence can be changed
         *
         * */

        /** Method 'append' appends the string representation of the argument to the current sequence */
        StringBuffer buffer = new StringBuffer("OCA");
        buffer.append("JP");
        System.out.println(buffer);

        /** Method 'insert' inserts the string representation of the argument into the current sequence
         * at the specified position */
        buffer.insert(1, true);
        buffer.insert(1, 2);
        System.out.println(buffer);

        /** Method 'replace' replaces characters in a substring of the current sequence with characters
         * in the specified String */
        buffer.replace(1,6, "-xxx-");
        System.out.println(buffer);

        /** Methods 'delete' and 'deleteCharAt' remove character(s) of the current sequence: */
        buffer.delete(1, 6);
        System.out.println(buffer);

        buffer.deleteCharAt(1);
        System.out.println(buffer);

        /** Methods 'reverse' causes the current character sequence to be replaced by the reverse of the sequence: */
        buffer.reverse();
        System.out.println(buffer);

        buffer.append(buffer);
        System.out.println(buffer);

        /** ------------------------------------------------------------------------------------------------------
         *
         * StringBuilder:
         *
         */

        StringBuilder sb1 = new StringBuilder(10);
        StringBuilder sb2 = new StringBuilder("ABCD");
        System.out.println("Capacity: " + sb1.capacity() + sb2.capacity());

        /** ------------------------------------------------------------------------------------------------------ */

        StringBuilder rockLandBuilder = new StringBuilder("RockLand");
        int x = rockLandBuilder.capacity();
        rockLandBuilder.trimToSize();
        int y = rockLandBuilder.capacity();
        System.out.println("Rockland Capacity:" + (x+y));
        rockLandBuilder.ensureCapacity(40);
        System.out.println("Rockland Capacity:" + rockLandBuilder.capacity());

        /** ------------------------------------------------------------------------------------------------------ */

        StringBuilder sb3 = new StringBuilder("10");
        sb3.insert(0, 1L);
        System.out.println(sb3);

        /** ------------------------------------------------------------------------------------------------------ */

        char[] rob = {'R', '2', 'D'};
        StringBuilder robStringBuilder = new StringBuilder();
        robStringBuilder.append(rob, 0, rob.length - 1);
        robStringBuilder.append('2');
        robStringBuilder.append(" \\o/");
        System.out.println(robStringBuilder);

        /** ------------------------------------------------------------------------------------------------------ */

        StringBuilder groot = new StringBuilder("I am ");
        groot.append(new char[]{'G', 'r', 'o', 'o', 't','h'}, 0, 5);
        System.out.println(groot);

        /** ------------------------------------------------------------------------------------------------------ */

        StringBuilder parts = new StringBuilder("ABCDEF");
        parts.delete(2,11); // end index may go beyond the length of the CharSequence -> No NPE!
        System.out.println(parts);

        parts.ensureCapacity(22);
        System.out.println(parts.capacity());
        parts.ensureCapacity(23);
        System.out.println(parts.capacity());

        parts.setLength(1);
        System.out.println(parts);

        System.out.println();

        /** ------------------------------------------------------------------------------------------------------ */

        StringBuilder sbToyStory = new StringBuilder("Toy Story I");
        char[] charsToyStory = new char[10];
        charsToyStory[0] = 'X';
        sbToyStory.getChars(1, 5, charsToyStory, 1);
        for (char c : charsToyStory) {
            System.out.print(c);
        }

        System.out.println();

        /** ------------------------------------------------------------------------------------------------------ */

        StringBuilder rock = new StringBuilder("RockLand");
        StringBuilder rock2 = new StringBuilder("RockLand");
        System.out.println("rock == rock2: " + (rock == rock2));
        System.out.println("rock.toString() == rock2.toString(): " + (rock.toString() == rock2.toString()));

        /** ------------------------------------------------------------------------------------------------------ */


    }
}