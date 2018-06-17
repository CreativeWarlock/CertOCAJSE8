package Objective_1_Java_Basics.Subobjective_2;

public class DefineStructureOfJavaClass {

    // https://docs.oracle.com/javase/tutorial/getStarted/application/index.html
    // https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html

    public static void main(String [ ] args) {
        System.out.println("Objective 1.2 - Define Structure of a JavaClass");

        /**=============================================================================================================
         *  Which of the following must be included in a java source file in order to compile?
         *
         * a) Package declaration
         * b) Class declaration
         * c) Import statement/s
         * d) Main method
         * e) Field declaration
         *
         * Answer:
         * a) Package declaration   -> not required
         * b) Class declaration     -> required
         * c) Import statement/s    -> not necessarily required
         * d) Main method           -> not necessarily required
         * e) Field declaration     -> not necessarily required
         */

        /**=============================================================================================================
        // Sequence of Elements in a Java source file
        // ----------------

         Element                Example                     Requirement?            Place
         Package declaration    package Rock;               no                      First line in file
         Import statement/s     import java.io.*            no                      immediately after package!
         class declaration      public class Rock           yes                     immediately after import!
         field declaration/s    int value;                  no                      anywhere inside a class
         method declarations    void method()               no                      anywhere inside a class

        */

        /**=============================================================================================================
         *  Which of the following is a valid top level class declaration?
         *
         * a) class one() {}
         * b) static class Test{}
         * c) protected class Test{}
         * d) class If{}
         * e) All of above
         *
         * Answer:
         * a) class one() {}            --> Illegal parantheses for class declaration
         * b) static class Test{}       --> Illegal static use with top level class declaration
         * c) protected class Test{}    --> Protected and private access level are not allowed with top level class decl.
         * d) class If{}                --> Correct
         * e) All of above
         */


    }
}

