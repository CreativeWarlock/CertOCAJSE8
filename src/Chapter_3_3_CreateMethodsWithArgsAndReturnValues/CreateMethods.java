package Chapter_3_3_CreateMethodsWithArgsAndReturnValues;

public class CreateMethods {

    boolean TestWithNoReturnAsLastStatement() {
        String a = "abc";
        boolean retVal = true;

        return retVal;

        //boolean bla = false; // return <boolean value> must be last!
    }

    public static void main(String[] args) {
        System.out.println("Chapter 3.3 - Create Methods with Arguments and Return Values");


    }
}