package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_4;

import java.util.*;
import java.util.List;

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
        anotherList.set(0, "4th");  // returns the element "1st" which was the previous element at position 0!
        System.out.println(anotherList.toString());

        /** --------------------------------------------------------------------------------------------------------- */

        List nonGenericList = new ArrayList<>();
        nonGenericList.add(1);
        nonGenericList.add('c');
        nonGenericList.add("A");
        nonGenericList.add(new Integer(4));
        System.out.println("nonGenericList: " + nonGenericList);


        /** --------------------------------------------------------------------------------------------------------- */

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

        /** --------------------------------------------------------------------------------------------------------- */

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

        // Since myStrings is of a raw type, the correct answer is a -> get method returns an Object, not String!

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 3: What happens when the following code fragment is compiled and executed? */

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(0);
        list.remove(0); //int deletedInt =
        System.out.println("after list.remove(0): " + list.get(0));

        /**
         * A) Compilation fails
         * B) Throws an exception at runtime
         * C) It prints 0
         * D) It prints 1
         * */

        // Answer C since   1. remove(0) can operate on the list and
        //                  2. remove(0) return type is not assigned to an int which would conflict with the raw type of the list!

        /** --------------------------------------------------------------------------------------------------------- */

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

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 4: What happens when the following code fragment is compiled and executed? */

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        String[] arr = new String[2];

        arr = strings.toArray(arr);

        for (String s : arr) {
            System.out.print(s);
        }

        System.out.println("\nLength of array 'arr': " + arr.length);

        /**
         * A) It prints "AB", , the length of the array is 2
         * B) It prints "ABC", , the length of the array is 3
         * C) It prints "nullnull", the length of the array is 2
         * D) An exception is thrown
         * E) Compilation fails.
         * */

        // Answer: Since strings is longer than the length of array 'arr' the toArray() method allocates a new array
        // whose length is equal to the length of the 'strings' list. Therefor answer B is correct.

        /** Documentation to toArray: "If the list fits in the specified array, it is returned therein.
         *          Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
         *          If the list fits in the specified array with room to spare (i.e., the array has more elements than the list),
         *          the element in the array immediately following the end of the list is set to null.
         *          (This is useful in determining the length of the list only if the caller knows that the list does not contain any null elements.)
         */

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 5: What happens when the following code fragment is compiled and executed? */

        strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        arr = new String[5];

        arr = strings.toArray(arr);

        for (String s : arr) {
            System.out.print(s);
        }

        System.out.print("\nLength of array 'arr': " + arr.length);

        /**
         * A) It prints "ABC", , the length of the array is 3
         * B) It prints "ABC", , the length of the array is 5
         * C) An exception is thrown
         * D) Compilation fails.
         * */

        // Answer: Since the array is now longer than the 'strings' list the toArray() method sets the remaining 2 elements in 'arr' to null.
        // Therefor answer B is correct.

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 6: What is the output? */

//        List list = new ArrayList<>();
//        list.add(5);
//        list.add(5);
//        System.out.print(Integer.max(list.get(0), 1));

        /**
         * A) true
         * B) 10
         * C) 1
         * D) An exception is thrown.
         * E) Compilation fails.
         * */

        // Answer: Since all elements of the list are of raw type (Object) and the max() method expects an Integer the compilation fails -> E

        /** ------------------------------------------------------------------------------------------------------ */

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(4);
        ints.add(2, 3);
        ints.removeIf(e -> e < 3);
        System.out.println(ints);

        /** ------------------------------------------------------------------------------------------------------ */

        List<String> ar = new ArrayList<>();
        System.out.println("empty ar.toString(): " + ar.toString());
        ar.add("ù");
        ar.add("~");
        ar.add("Å");
        ar.add("í");
        ar.add(1, "b");

        System.out.println(ar.set(4, "3")); // returns the element previously at the specified position

        /** ------------------------------------------------------------------------------------------------------ */
    }
}