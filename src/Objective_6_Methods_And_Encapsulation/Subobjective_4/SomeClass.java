package Objective_6_Methods_And_Encapsulation.Subobjective_4;

public class SomeClass {
    protected int myField;

    SomeClass() {
        MyClassInSamePackage myClassInSamePackage = new MyClassInSamePackage();
        myClassInSamePackage.myMethod(); // private-package modifier of this class allows access ONLY inside this package!
    }
}

class MyClassInSamePackage {
    public void myMethod() {
        System.out.println("MyMethod is public!");
    }
}