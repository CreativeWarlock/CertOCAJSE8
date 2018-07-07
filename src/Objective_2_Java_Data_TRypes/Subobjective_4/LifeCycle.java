package Objective_2_Java_Data_TRypes.Subobjective_4;

public class LifeCycle {

    // https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html

    public static void main(String[] args) {
        System.out.println("Chapter 2.4 - Life Cycle");

        /**
         * Object creation:
         * ----------------
         *  - Instantiation done with the 'new' operator
         *  - Initialization implemented by constructors
         */

        /**
         * Object destruction:
         * -------------------
         * - An object can be destroyed using a technique called 'dereference by reassignment'
         *      -> making it eligible for garbage collection
         */
        MyClass object1 = new MyClass(42);
        MyClass object2 = object1;
        MyClass object3 = object1;

        /** Question: How many objects are created after the above code? */
        // --> Answer is: 1 object since 3 instances reference the same object 'object1'.

        /** Question: No object (object1, object2, object3) becomes eligible for GC. True or False? */
        // -- Answer: True because object2 and object3 reference to object 1 and
        //            since object1 is not null and thus not ready for GC.

        // Dereferencing object2 and object3 by reassignment, that is, by assigning null:
        object2 = null;
        object3 = null;

        /** - You can only determine which objects are eligible to be garbage collected.
         *  - You can never determine when a particular object will be garbage collected.
         *  - A user can't control or determine the execution of the GC. It's controlled by the JVM.
         */

        /** Question: Which objects are sure to be collected during the next GC cycle? */
        // -> Real answer: We can never know!

        // Requesting GC via:
        System.gc();
        // or
        Runtime.getRuntime().gc();

        // --> Calling either method does not guarantee when the GC would start! It can even be ignored by the JVM

        MyClass objectX = new MyClass(99).myMethod(); // X

        /** Question: How many objects are eligible for GC after line X is executed?  */
        // -> Answer: 2 objects are eligible for GC:
        //              - 1 because the DEFAULT constructor of MyClass is invoked
        //                      -> an instance is created, but never referenced by any variable!
        //              - 1 because within myMethod() object2 is never referenced
        //              - objectX is not ready for GC!
    }
}

class MyClass {
    int integer;

    public MyClass(int integer) {
        this.integer = integer;
    }

    public MyClass myMethod() {
        MyClass object1 = new MyClass(0);
        MyClass object2 = new MyClass(1);
        return object1;
    }
}