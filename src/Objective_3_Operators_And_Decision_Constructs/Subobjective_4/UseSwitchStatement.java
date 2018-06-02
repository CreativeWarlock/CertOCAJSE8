package Objective_3_Operators_And_Decision_Constructs.Subobjective_4;

public class UseSwitchStatement {



    public static void main(String[] args) {
        System.out.println("Chapter 3.7 - Use a Switch Statement");

        ComparingStringObjectVersusStringLiteral();

    }

    private static void ComparingStringObjectVersusStringLiteral() {
        String name1 = "Bhaka";
        //String name2 = "Bhaka";
        String name2 = new String("Bhaka");

        System.out.println(name1.equals(name2) + " ");
        System.out.println(name1 == name2);
    }
}
