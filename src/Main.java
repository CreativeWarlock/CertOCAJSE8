public class Main {

    static int x, y = 10, z = x*y;

    static int number;

    public static void main(String[] args) {
        System.out.println("Hello World! Some random stuff goes here.");

        //int number = this.number + 1; // this can only be referenced from an instance, not a static context!

        System.out.println("z: " + z);

        Integer a = new Integer(127);
        Integer b = new Integer(127);
        System.out.println(a == b);

        Integer c = 256;
        Integer f = 256;
        System.out.println(c == f);

        //int a = 0.2d; // ;)

        int iPrim = 100;
        int y = 100;
        Integer iObj = 100;
        System.out.println("iObj equals iPrim? " + iObj.equals(iPrim));

        Double dObj = 100.0;
        System.out.println("iObj equals dObj? " + iObj.equals(dObj));

        System.out.println("d + i: " + dObj + iObj);
        //System.out.println("(d + i).intValue(): " + (d + i).intValue());

        Long l1 = 10l;
        Long l2 = 9l;
        System.out.println(Long.remainderUnsigned(l1, l2));
        System.out.println(Long.divideUnsigned(l1, l2));

        System.out.println(Integer.decode("12"));
        System.out.println(Integer.parseInt("011"));

        Integer myInt = new Integer(9);
        boolean isInstOf = myInt instanceof Number;
    }
}