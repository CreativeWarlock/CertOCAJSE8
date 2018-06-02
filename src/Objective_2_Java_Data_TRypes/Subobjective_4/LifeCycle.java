package Objective_2_Java_Data_TRypes.Subobjective_4;

public class LifeCycle {

    public static void main(String[] args) {
        System.out.println("Chapter 3.2 - Life Cycle");

        /** - You can only determine which objects are eligible to be garbage collected.
         *  - You can never determine when a particular object will be garbage collected.
         *  - A user can't control or determine the execution of the GC. It's controlled by the JVM.
         */

        // TIP: Question about "Which objects are sure to be collected during the next GC cycle"
        // -> Real answer: We can never know

        // Requesting GC via:
        System.gc();
        // or
        Runtime.getRuntime().gc();

        // --> Calling either method does not guarantee when the GC would start! It can even be ignored by the JVM
    }
}