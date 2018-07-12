public class Main {

    static int x, y = 10, z = x*y;

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("z: " + z);

        Integer a = new Integer(127);
        Integer b = new Integer(127);
        System.out.println(a == b);

        Integer c = 256;
        Integer f = 256;
        System.out.println(c == f);

        int x = 100;
        int y = 100;
        Integer i = 100;
        System.out.println("i equals x? " + i.equals(x));

        Double d = 100.0;
        System.out.println("i equals d? " + i.equals(d));

        System.out.println("d + i: " + d + i);
        //System.out.println("(d + i).intValue(): " + (d + i).intValue());

        Long l1 = 10l;
        Long l2 = 9l;
        System.out.println(Long.remainderUnsigned(l1, l2));
        System.out.println(Long.divideUnsigned(l1, l2));

        System.out.println(Integer.decode("12"));
        System.out.println(Integer.parseInt("011"));
    }
}