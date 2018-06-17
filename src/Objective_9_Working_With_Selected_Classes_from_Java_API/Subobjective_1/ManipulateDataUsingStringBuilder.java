package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_1;

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
        buffer.replace(1,5, "-xxx-");
        System.out.println(buffer);

        /** Methods 'delete' and 'deleteCharAt' remove character(s) of the current sequence: */
        buffer.delete(1, 20);
        System.out.println(buffer);

        buffer.deleteCharAt(1);
        System.out.println(buffer);

        /** Methods 'reverse' causes the current character sequence to be replaced by the reverse of the sequence: */
        buffer.reverse();
        System.out.println(buffer);

        /** ------------------------------------------------------------------------------------------------------ */

        buffer.append(buffer);
        System.out.println(buffer);
    }
}