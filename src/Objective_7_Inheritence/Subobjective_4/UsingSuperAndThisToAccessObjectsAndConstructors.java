package Objective_7_Inheritence.Subobjective_4;

public class UsingSuperAndThisToAccessObjectsAndConstructors {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
    // https://docs.oracle.com/javase/tutorial/java/IandI/super.html

    int number = 0;

    public static void main(String[] args) {
        System.out.println("Chapter 7.4 - Using 'super' and 'this' to access objects and constructors");

        /**
         * 'this' keyword:
         * ---------------
         *
         * - is used within an instance method or a constructor to refer to the current object (=the objects whose
         * method or constructor is called)
         *
         * - in a constructor 'this' must be the FIRST statement!
         */

        MyClass mc = new MyClass();
        mc.execute();

        /** 'super' keyword:
         * -----------------
         *
         * - can be used within an instance method or a constructor of a subclass to access members of the direct superclass
         *
         * - in a constructor super() must be the FIRST statement!
         *
         * - If a constructor does not explicitly invoke any other constructor,
         *   the compiler automatically inserts a call to the no-argument constructor of the superclass!!
         *
         * */

        MySubClass mySubClass = new MySubClass();
        mySubClass.execute();

        //int number = this.number + 1; // this can only be referenced from an instance, not a static context!
    }
}

class MyClass {
    protected String field = "Instance field";

    MyClass(String name) {
        this.field = name;
    }

    MyClass() {
        //System.out.println(field); // If used then 'this' cannot be 2nd statement!
        this("No name");
    }

    protected void print(String string) {
        System.out.println(string);
    }

    public void execute() {
        String field = "Local variable";
        this.print("MyClass.Execute(): " + this.field);
    }
}

class MySuperClass {
    protected String field;

    protected static int number;

    protected MySuperClass() {
        this.field = "I'm the SUPER CLASS!!!";
    }

    protected void print(String string) {
        System.out.println("MySuperclass: " + string);
    }

    protected void increment(int i) { i++; }
}

class MySubClass extends MySuperClass {
    public String field = "I'm the sub class... -.-";

    public MySubClass() {
        super();          // will be called automatically! :)
        System.out.println("MySubClass constructor: super.field = " + super.field);

        super.increment(super.number);
        System.out.println("Number : " + this.number);
    }

    public void print(String string) {
        System.out.println("SubClass: " + string);
    }
    public void execute() {
        //super.print(super.field);
        print(field);
    }
}