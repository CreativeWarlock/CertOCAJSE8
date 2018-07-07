package Objective_6_Methods_And_Encapsulation.Subobjective_2;

public class Data {
    protected int instanceValue;
    static int staticValue;

    protected int getInstanceValue() { return instanceValue; }

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
