package Objective_2_Java_Data_TRypes.Subobjective_3;

public class KnowHowToReadOrWriteToObjectFields {

    // http://www.oracle.com/javase/tutorial/java/javaOO/usingobject.html

    public static void main(String [ ] args) {
        System.out.println("Objective 2.3 - Know how to Read or Write to Object Fields");

        /**
         * Inside the object:
         * ------------------
         *
         * - Statements within an object may access and modify a field of the object using 'this' keyword
         * - If the field is not shadowed by any local variable, the 'this' prefix may be left out
         *
         * --> see getter and setter of MyClass
        */

        /**
        * Outside the object:
        * -------------------
        *
        * - A non-private object field can be accessed and modified from outside using an object reference,
        * followed by a dot-operator, followed by a simple name:
        */

         MyClass myClass = new MyClass();
         // read the field
         String fillMe = myClass.myField;
         // write the field
        myClass.myField = "Change to new value from outside";

        // --------------------------------
        // Testing what is being printed:
        myClass.myMethod();



        // --------------------------------

    }
}

class MyClass {
    public String myField = "I am an object field";

    String getMyField() {
        // can drop 'this'
        return this.myField;
    }

    void setMyField(String newValue) {
        // can drop 'this'
        this.myField = newValue;
    }

    void myMethod() {
        String myField = "Huhu";
        System.out.println(this.myField); // this.myField overcomes the shadowing
    }
}