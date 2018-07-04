package Objective_4_Arrays.Subobjective_1_and_2;

import java.util.Arrays;

public class DeclareAndInstantiateArrays {

    // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html

    // http://tutorials.jenkov.com/java/arrays.html

    static int staticVar;

    static int numberOfFields = 1;

    public static void main(String [ ] args) {
        System.out.println("Chapter 4.1 - Declare, Instantiate and use a one-dimensional Array");

        /**
         * Once allocated, all the array elements store their default values:
         * - Elements in an array that store objects default to null.
         * - Elements of an array that store primitive data types store
         *      0 for integer types (byte, short, int, long)
         *      0.0 for decimal types (float, double)
         *      false for boolean
         *      \u0000 for char data.
         */

        /**==========================
        //  One dimensional array
        // ========================*/

        int arrayDeclaration[];
        int []arrayDeclaration2;

        // =============================================================================================================

        /** Instantiation: */
        int[] singleDim = new int[2]; // 1-Dim array with 2 elements initialized with 0.
        int[] singleDimWithStaticInit = new int[numberOfFields];

        /** Initialization: */
        int[] singleDimInit1 = {5, 6, 7, 8};           // Uses initializer with curly brackets
        int[] singleDimInit2 = new int[] {5, 6, 7, 8}; // Uses initializer with new operator for additional Type safety

        /** Following is NOT VALID -> Cannot combine declaration, allocation and initialization with specifying the size of the array! */
        //int[] singleDimTypeAndInitializer = new int[4] { 1, 2, 3}; //

        //int[] singleDimInit3;
        //singleDimInit3 = {5}; // initializer is NOT ALLOWED here

        /** Following is NOT VALID -> initializer expected; at least the top level bracket must define a dimension! */
        //int[] singleDim = new int[];

        int[] singleDim10 = new int[2*5]; // evaluates to an int :)
        int[] singleDimMax = new int[Math.max(2,5)]; // evaluates to an int :)

        // =============================================================================================================

        Integer[] a = new Integer[2];
        a[1] = 20;
        System.out.print("Integer a: ");

        for(Integer i : a)
            System.out.print(i);

        // =============================================================================================================

        int array[] = {1, 2, 3};
        //double dlbs[] = array;        // incompatible!

        // =============================================================================================================

        /** Won't compile! */
        //        int fail1[2];
        //        int[2] fail2;
        //        int[2] fail3[3];

        // =============================================================================================================

        /** // int can be cast to long implicitly. However, this is not available for arrays types! */
        // long[] myLongArray = new int[]{1, 2, 3};

        // =============================================================================================================

        int[] arrayDeclaration3[]; // 2-Dimensional
        //arrayDeclaration3 = new int[2]; // --> NOT VALID since it requires type int[][]
          arrayDeclaration3 = new int[2][]; // better :)

        // =============================================================================================================

        /** Following code causes a RunTimeException: ArrayIndexOutOfBoundsException */
        //int[] singleDimNegativeIndexAccess = { 1, 2, 3};
        //System.out.println("singleDimNegativeIndexAccess[-1]: " + singleDimNegativeIndexAccess[-1]);

        // =============================================================================================================

        int testWithStaticVariable[] = new int[] {10, 12, 15};
        System.out.println("testWithStaticVariable: " + testWithStaticVariable[++staticVar]);

        // =============================================================================================================

        int x = 2;
        int[] dependingArray= new int[x];
        //dependingArray[0] = 0;

        System.out.println("dependingArray: " + dependingArray[0]);

        // =============================================================================================================

        int[] reinitArray = {1, 2, 3};
        reinitArray = new int[6];
        System.out.println("reinitArray: " + reinitArray[2]);

        // =============================================================================================================

        //short len = 8;            // works
        //char len = 8;             // works
        //byte len = 8;             // works
        //long len = 8;             // Compilation would fail, accessor must evaluate to an integer type! Long is not implicitely cast to int!
        int len = 8;               // works
        int [] ints = new int[len];

        // =============================================================================================================

        String[] seasonsArray = {"Spring", "Summer", "Autumn", "Winter"};

        seasonsArray[2] = null;

        System.out.print("Seasons: ");
        for (String season : seasonsArray) {
            System.out.print(season + ", "); // Prints null if element is null!
        }
        System.out.println();

        // =============================================================================================================

        int[] numbers = {1,-5,23,4,9};
        int[] numbers2 = {1,-5,23,4,9};
        //System.out.println(numbers == numbers2 + " ");
        System.out.println((numbers == numbers2) + " ");
        System.out.println(Arrays.equals(numbers, numbers2));
        //System.out.println(Arrays.deepEquals(numbers, numbers2) + "");

        // =============================================================================================================

        String[] sortLetters = {"n", "L", "O", "S", "p"};
        Arrays.sort(sortLetters);
        System.out.print("sortLetters: ");
        for(String s : sortLetters)
            System.out.print(s);
        System.out.println();

        // =============================================================================================================

        /**==========================
        //  Multi dimensional array
        // ========================*/

        /** Following is NOT VALID -> initializer expected; at least the top level bracket must define a dimension */
        //int[][] singleDim = new int[][];

        // =============================================================================================================

        int[] intArray3x2[] = {{1, 2, 3}, {4, 5}};
        int[][] intArray3x2WithTypeSafety = new int[][]{{1, 2, 3}, {4, 5}};
        System.out.println("intArray3x2: " + intArray3x2);
        System.out.println("intArray3x2: " + Arrays.deepToString(intArray3x2));
        System.out.println("intArray3x2WithTypeSafety: " + Arrays.deepToString(intArray3x2WithTypeSafety));

        // =============================================================================================================

        int[][] intArray2x3 = new int[2][3];
        for (int i=0; i < 2; i++) {
            for (int j=0; j < 3; j++) {
                intArray2x3[i][j] = i + j;
            }
        }
        System.out.println("intArray2x3: " + Arrays.deepToString(intArray2x3));

        // =============================================================================================================

        int[][] intArray2x2Fails = new int[2][];
        for (int i=0; i < 2; i++) {
            for (int j=0; j < 2; j++) {
                //intArray2x2Fails[i][j] = i + j;  // throws NullPointerException!
            }
        }

        // =============================================================================================================

        int[][] intArray2xX = new int[2][];
//        intArray2xX[0][0] = 0; // -> NPE!
//        intArray2xX[0][1] = 1;
//        intArray2xX[0][2] = 2;
        System.out.println("intArray2xX: " + Arrays.deepToString(intArray2xX));

        // =============================================================================================================

        int[][] intArray2xCheckLength = new int[2][];
        intArray2xCheckLength[0] = new int[3];
        intArray2xCheckLength[1] = new int[2];
        System.out.println("intArray2xCheckLength: " + Arrays.deepToString(intArray2xCheckLength));
        System.out.println("intArray2xCheckLength.length + intArray2xCheckLength[1].length: " + intArray2xCheckLength.length + intArray2xCheckLength[1].length);

        // =============================================================================================================

        String[][] wildLetters = {{"A", "Z"}, {"C", "D", "P"}, {"L", "Q"}};
        /*Arrays.sort(wildLetters); // will throw CCE
        for(String[] str : wildLetters)
            for (String s : str) {
                System.out.print(s);
            }*/


        // =============================================================================================================


        // ==========================
        //     Asymmetrical array
        // ==========================

        // Testing varying length of array elements at some nesting level:
        int[][][] intArray3x3 = {{{1, 2, 3}, {4, 5}, {1, 2, 3}}, {{1, 2}, {4}}}; // Elements may vary in length due to having uninitialized fields

        System.out.println("Test array with varying element length: intArray3x3: " + Arrays.deepToString(intArray3x3));

        // =============================================================================================================

        String multiStrArray[][] = new String[][]{
                {"A", "B"},
                null,
                {"Jan", "Feb", "Mar"},
        };

        System.out.println("multiStrArray: " + Arrays.deepToString(multiStrArray));

        // =============================================================================================================

        /** IMPORTANT - Array initializer being of various types */
        //int[][] intArray2x2Fails = {{1, 2}, {4.0, 5.0}}; // COMPILATION FAILS -> must be of same type! Only Number or Object works!
        Number[][] intArray2x2Works = {{1, 2}, {4.0, 5.0}};

        // =============================================================================================================

        /** Additional information:
         *
         * An Array can be of any of the following:
         *
         *      - primitive data type
         *      - Interface
         *      - Abstract class (those assigned elements must extend that abstract class!)
         *      - concrete class
         */

        // =============================================================================================================

        String str[][] = new String[2][];
        //String str[2][] = new String[][]; // nope
        //String str[][] = new String[][2]; // nope

        // =============================================================================================================

        int nums[][] = new int[3][3];
        nums[0] = new int[2];

        System.out.println("nums: " + Arrays.deepToString(nums));

        // =============================================================================================================

        /** anonymous Arrays: */
//        anonymous int array : new int[] { 1, 2, 3, 4};
//        anonymous String array : new String[] {"one", "two", "three"};
//        anonymous char array :  new char[] {'a', 'b', 'c');

        // =============================================================================================================

        //final int[] finInts = new int[]; // nope
        final int[] finInts = new int[3];
        finInts[1]++;
        int finLen = finInts.length;
        System.out.println("i: ");
        for (int i : finInts)
            System.out.print(i);

        System.out.println();

        // =============================================================================================================

        int[][] intExp = new int[3][2];
        intExp[0] = new int[3];
        //intExp[2] = {1, 2, 3}; // Array initializer not allowed here

        // =============================================================================================================

        int[][] sortNullInts = new int[2][];
        //Arrays.sort(sortNullInts[1]);           // NPE!
        System.out.println("SortnNullInts: " + Arrays.toString(sortNullInts[1]));

        // =============================================================================================================

        int[] binaryArray = {2, -1, 4, 5, 3};
        Arrays.sort(binaryArray);
        System.out.println("binaryArray: " + Arrays.binarySearch(binaryArray, -1));

    }
}
