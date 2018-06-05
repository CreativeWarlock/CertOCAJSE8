package Objective_6_Methods_And_Encapsulation.Subobjective_4;

public class AnotherClass {
    int myOtherField;

    AnotherClass() {
        SomeClass someClass = new SomeClass();
        myOtherField = someClass.myField; // accessible through protected modifier

        MyClassInSamePackage myClassInSamePackage = new MyClassInSamePackage();
        myClassInSamePackage.myMethod(); // accessible due to private-package modifier of the class -> allows accessing ONLY inside this package!
    }
}
