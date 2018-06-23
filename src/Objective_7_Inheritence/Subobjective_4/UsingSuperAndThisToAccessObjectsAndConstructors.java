package Objective_7_Inheritence.Subobjective_4;

public class UsingSuperAndThisToAccessObjectsAndConstructors {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
    // https://docs.oracle.com/javase/tutorial/java/IandI/super.html

    int number = 0;

    public static void main(String[] args) {
        System.out.println("Chapter 7.4 - Using 'super' and 'this' to access Objects and Constructors");

        /**
         * 'this' keyword:
         * ---------------
         *
         * - is used within an instance method or a constructor to refer to the current object (=the objects whose
         * method or constructor is called)
         *
         * - in a constructor 'this' must be the FIRST statement!
         */

        AssignWithConstructorClass mc = new AssignWithConstructorClass("Area 51");
        mc.printInstanceField();

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
        mySubClass.print();

        boolean b = mySubClass instanceof MySuperClass;

        //int number = this.number + 1; // this can only be referenced from an instance, not a static context!

        MySuperClass superClass = new MySubClass("Make me proud!");
        superClass.print("Some String");
        ((MySubClass) superClass).print();
    }
}

class AssignWithConstructorClass {
    protected String field = "Secret Area";

    AssignWithConstructorClass(String name) {
        this.field = name;
    }

    AssignWithConstructorClass() {
        //System.out.println(field); // If used then 'this' cannot be 2nd statement!
        this("Unrestricted Area");
    }

    protected void print(String string) {
        System.out.println(string);
    }

    public void printInstanceField() {
        String field = "Rocky Mountains";
        this.print("AssignWithConstructorClass.printInstanceField(): " + this.field);
    }
}

class MySuperClass {
    protected String field;
    protected static int number;

    protected MySuperClass(String additionalString) {       // -> Then we cannot use super() in sub classes! But we can call, e.g., super(null)
    //protected MySuperClass() {
        this.field = "I'm the SUPER CLASS!!! " + additionalString;
    }

    protected void print(String string) {
        System.out.println("MySuperclass: " + string);
    }

    protected void increment(int i) { i++; }
}

class MySubClass extends MySuperClass {
    public String field = "I'm the sub class... -.-";

    public MySubClass(String additionalString) {
        super(additionalString);
    }

    public MySubClass() {
        super("[ empty ]"); // will be called automatically! :)
        System.out.println("MySubClass constructor with super.field = " + super.field);

        super.increment(super.number);
        System.out.println("Number : " + this.number);
    }

    public final void print(String string) {
        System.out.println("The passed over string is: " + string);
    }
    public void print() {
        super.print(super.field);
        //print(field);
    }
}