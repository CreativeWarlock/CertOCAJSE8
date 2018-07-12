package Objective_8_Handling_Exceptions.Subobjective_2;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CreateATryAndCatchBlock {

    // https://docs.oracle.com/javase/tutorial/essential/exceptions/try.html
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html

    public static void main(String[] args) {
        System.out.println("Chapter 8.2 - Create a Try-Catch Block and determine how exceptions alter normal program flow");

        /**
         * A 'try-catch' Block:
         * --------------------
         *
         * Note: If a catch block handles more than one exception type, then the catch parameter is implicitly final.
         *  In the next example, the catch parameter ex is final and therefore you cannot assign any values to it
         *  within the catch block.
         *
         */

        try {
            System.out.println("Normal program flow.");
        } catch (Exception e) {
            System.out.println("Exception branch.");
        }

        try {
            throw new RuntimeException();
            //System.out.println("Normal program flow."); // Code is unreachable --> COMPILE TIME ERROR!
        } catch (Exception e) {
            System.out.println("Exception branch.");
        }

        // ----------------------------------------------------------------------------------------------------------------

        try {
            someExceptionReturningMethod();
            someExceptionThrowingMethod();
        }  catch(FileNotFoundException fne) {
            System.out.println("Exception: " + fne);
        }catch(IOException e) {
            System.out.println("Exception: " + e);
        }

        // ----------------------------------------------------------------------------------------------------------------

        try {
            printWhenCatchingCCE();
        } catch(Exception e) {}
    }

    /** If the writeList method doesn't catch the checked exceptions that can occur within it,
     * the writeList method must specify that it can throw these exceptions.
     *
     * Remember that IndexOutOfBoundsException is an unchecked exception;
     * including it in the throws clause is NOT mandatory.
    */

    public void writeList() throws IOException, IndexOutOfBoundsException {
        List list = Arrays.asList(1,2,3);

        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < 1000; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
        out.close();
    }

//    try {
//      // ...
//    } catch (IOException |SQLException ex) {
//        System.out.println(ex);
//        throw ex;
//    }

    /** The finally block always executes when the try block exits.
     *
     * This ensures that the finally block is executed even if an UNEXPECTED exception occurs.
     *
     * But finally is useful for more than just exception handling — it allows the programmer to avoid having cleanup code
     * accidentally bypassed by a return, continue, or break.
     *
     * Putting cleanup code in a finally block is always a good practice,
     * even when no exceptions are anticipated.
     *
     * -----
     * Note: If the JVM exits while the try or catch code is being executed, then the finally block may not execute.
     * ----- Likewise, if the thread executing the try or catch code is interrupted or killed,
     *       the finally block may not execute even though the application as a whole continues.
     *
     * -----------
     * Important: The finally block is a key tool for preventing resource leaks.
     * ---------- When closing a file or otherwise recovering resources, place the code in a finally block
     *            to ensure that resource is always recovered.
     */


    // --------------------------------

    /**
     * The try-with-resources statement is a try statement that declares one or more resources.
     * A resource is an object that must be closed after the program is finished with it.
     * The try-with-resources statement ensures that each resource is closed at the end of the statement.
     * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable,
     * can be used as a resource.
     *
     * The following example reads the first line from a file.
     * It uses an instance of BufferedReader to read data from the file.
     * BufferedReader is a resource that must be closed after the program is finished with it:
     */

    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /** You may declare one or more (separated with ; ) resources in a try-with-resources statement.
     * The following example retrieves the names of the files packaged in the zip file zipFileName and creates a text file
     * that contains the names of these files:
     */

    public static void writeToFileZipFileContents(String zipFileName, String outputFileName) throws java.io.IOException {

        java.nio.charset.Charset charset =
                java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath =
                java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with
        // try-with-resources statement

        try (java.util.zip.ZipFile zf =
                        new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer =
                        java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
                                newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    /** An exception can be thrown from the block of code associated with the try-with-resources statement.
     * In the example writeToFileZipFileContents, an exception can be thrown from the try block,
     * and up to two exceptions can be thrown from the try-with-resources statement when it tries to close the ZipFile and BufferedWriter objects.
     *
     * If an exception is thrown from the try block and one or more exceptions are thrown from the try-with-resources statement,
     * then those exceptions thrown from the try-with-resources statement are suppressed,
     * and the exception thrown by the block is the one that is thrown by the writeToFileZipFileContents method.
     *
     * -> You can retrieve these suppressed exceptions by calling the 'Throwable.getSuppressed()' method from the exception
     * thrown by the try block. */

    // ----------------------------------------------------------------------------------------------------------------

    public static IOException someExceptionReturningMethod() {
        return new IOException("Some IOException occurred");
    }

    public static void someExceptionThrowingMethod()throws IOException { // omg.. lol
        throw new FileNotFoundException("File Not Found Exception");
    }

    static void printWhenCatchingCCE() {
        try {
            //System.out.print("Throwing NPE: ");
            throw new NullPointerException();
        } catch(ClassCastException e) {
            System.out.println("Class Cast ");
        } finally {
            System.out.println("Final ");
        }

        System.out.println("OCAJP ");
    }
}