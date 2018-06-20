package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_4;

import java.util.ArrayList;
import java.util.Arrays;

public class DeclareAndUseAnArrayList {

    // https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

    public static void main(String[] args) {
        System.out.println("Chapter 9.4 - Declare and use an ArrayList of a given type");

        /**
         * Introduction to ArrayList:
         * --------------------------
         * - The ArrayList class is a resizable array implementation of the 'List' interface, which
         *      implements all optional list operations, and
         *      allows ALL elements - including null!
         *
         * - The class itself provides methods
         *      to manipulate the size of the array that is used internally to store the list.
         * */

        // Creating an ArrayList instance

        // no-argument constructor
        ArrayList<String> stringList = new ArrayList<>();

        // passing a collection to the constructor
        ArrayList<String> anotherList = new ArrayList<>(stringList);

        /** 'add' method: adds a new element at the specified position in the current list.
         *              If no argument is passed in for the position, the new element is appended at the end of the list. */

        anotherList.add("1st");
        anotherList.add("2nd");
        anotherList.add(1, "3rd");

        /** 'get' method: returns the element at the specified position in the current list. */
        anotherList.get(0);

        /** String remove(int index): - takes an integer argument and removes the element at the specific position in the current list.
         *                            - returns the removed type! */
        String removedElement = anotherList.remove(0);
        System.out.println("Removed Element: " + removedElement);
        System.out.println(anotherList.toString());

        /** boolean remove(String firstOcc): - takes a String argument and removes the first occurrence of the specific element
         *                                     from the current list - if it's present!
         *                                   - returns true if successful or false otherwise. */

        if (anotherList.remove("3rd"))
            System.out.println("Removed 3rd, now anotherList contains: " + anotherList.toString());

        /** String set(int index, String replacement):
         *              - replaces the element at the specified position in the current list with the specified replacement
         *              - returns the replaced element!
         * */
        anotherList.set(0, "4th");
        System.out.println(anotherList.toString());

        /** Question 1: What happens when the following code fragment is compiled and executed? */

//        ArrayList myInts = new ArrayList();
//        myInts.add(1, 1);
//        myInts.add(1, 1);
//        System.out.println(myInts.toString());

        /**
         * A) Compilation fails
         * B) Throws an exception at runtime
         * C) It prints number 1
         * D) It prints number 2
         * */

        // Answer B since there are no elements at position 1 yet.

        /** Question 2: What happens when the following code fragment is compiled and executed? */

//        ArrayList myStrings = new ArrayList();
//        myStrings.add("a");
//        myStrings.add("b");
//        String element = myStrings.get(0);
//        System.out.println(element);

        /** A) Compilation fails
         *  B) Throws an exception at runtime
         * C) It prints number "a"
         * D) It prints number "b"
         * */

        // Answer A since myStrings is of a raw type -> get method returns an object, not string!

        /** Question 3: What happens when the following code fragment is compiled and executed? */

//        ArrayList list = new ArrayList();
//        list.add(1);
//        list.add(0);
//        list.remove(0); //int deletedInt =
//        System.out.println(list.get(0));

        /**
         * A) Compilation fails
         * B) Throws an exception at runtime
         * C) It prints 0
         * D) It prints 1
         * */

        // Answer D since   1. remove(0) can operate on the list and
        //                  2. remove(0) return type is not assigned to an int which conflicts with the raw type of the list!

        /** Question 3: What happens when the following code fragment is compiled and executed? */

//        ArrayList myList = new ArrayList();
//        myList.add(0);
//        boolean result = myList.set(1, 1);
//        System.out.println(result);

        /**
         * A) Compilation fails
         * B) Throws an exception at runtime
         * C) It prints 0
         * D) It prints 1
         * */

        // Answer A since   1. set(1,1) returns the Element of type Object and not a boolean result value. -> Compilation error
        //                  2. without error 1) set(1,1) would throw an exception because it accesses with the wrong index.
    }
}