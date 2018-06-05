package Objective_6_Methods_And_Encapsulation.Subobjective_2;

public class Data {
    int instanceValue;
    static int staticValue;

    public void instanceMethodIncrementStaticValue() {
        staticValue++;
    }

    public static void staticMethodIncrementStaticValue() {
        staticValue++;
    }

    public static void staticMethodCannotIncrementInstanceValues() {
        //instanceValue++; // NOT VALID
    }
}
