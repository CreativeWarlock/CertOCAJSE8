package Objective_6_Methods_And_Encapsulation.Subobjective_4;

public class SomeClass {
    protected int myField;

    SomeClass() {
        MyClassInSamePackage myClassInSamePackage = new MyClassInSamePackage();
        myClassInSamePackage.myMethod(); // accessible due to private-package modifier of the class -> allows accessing ONLY inside this package!
    }

}

class MyClassInSamePackage {
    public void myMethod() {
        System.out.println("MyMethod is public!");
    }
}