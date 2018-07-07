package Objective_6_Methods_And_Encapsulation.Subobjective_4;

class ClassInSamePackage {
    int myOtherInt;

    ClassInSamePackage() {
        SomeClass someClass = new SomeClass();
        myOtherInt = someClass.myField; // accessible through protected modifier

        MyClassInSamePackage myClassInSamePackage = new MyClassInSamePackage();
        myClassInSamePackage.myMethod(); // accessible due to private-package modifier of the class -> allows accessing ONLY inside this package!
    }

    void setMyOtherInt(int myOtherInt) {
        this.myOtherInt = myOtherInt;
    }
}
