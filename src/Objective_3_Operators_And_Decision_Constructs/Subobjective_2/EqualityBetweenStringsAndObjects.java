package Objective_3_Operators_And_Decision_Constructs.Subobjective_2;

public class EqualityBetweenStringsAndObjects {



    public static void main(String[] args) {
        System.out.println("Chapter XXX - Equal Operator");

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
