package Objective_1_Java_Basics.Subobjective_3;

public class NonExecutingStaticCode {

    // https://docs.oracle.com/javase/tutorial/getStarted/application/index.html

    static {
        System.out.println("This java program will run without the main method");
        System.exit(0);
    }

    /**
     * What is the output?
     *
     * a) "This java program will run without the main method" will be printed
     * b) Compilation succeeds and no output
     * c) An Exception is thrown at runtime
     * d) Compilation fails
     * e) none of the above.
     *
     * Answer:
     *
     * In Java 6 or earlier version, JVM first loads the byte code into memory. Static blocks will be executed at the
     * time of class loading and t hen looks for the main method.
     * But there is System.exit(0) statement which terminates the JVM. So you don't get any error with this program.
     *
     * From Java 7 onwards, the JVM looks for the main method. If it doesn't find any main method, it gives you an error.
     * If there is a main method then it loads the class into memory.
     *
     * A class may not have the main method. So there will be no compile time error when compiling such a class.
     * However, trying to execute the class file of that class causes an Error not an exception.
     *
     * So option e) is correct. Option a) and b) are incorrect as the code produces an error before producing any output!
     * Option d) is incorrect as the code compiles fine.
     */
}

