package Objective_1_Java_Basics.Subobjective_4;

import Objective_1_Java_Basics.Subobjective_4.one.*;

import java.awt.Rectangle.*; // <-- this import alone will not import the Rectangle class!
//import javafx.scene.shape.Rectangle; // ambiguous import! -> Rectangle would need to be fully qualified
import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import static java.lang.System.*;
//static import java.lang.System.*; // wrong order

import static java.lang.Math.*;

//import static java.lang.Math.abs; // imports all static abs(..) methods
import java.lang.*;


public class Import_Other_Java_Packages {

    // https://docs.oracle.com/javase/tutorial/java/package/usepkgs.html

    public static void main(String [] args) {

        Date d = new Date();
        System.out.println("Date d: " + d);

        BigDecimal bd = new BigDecimal(10.0);

        abs(1);

        out.println("Objective 1.4 - Import other Java packages to make them accessible in your code");

        /**=============================================================================================================
         * Essential statements:
         * ---------------------
         * - To create a package for a type, put a package statement as the first statement in the source file
         *   that contains the type (class, interface, enumeration, or annotation type).
         *
         * - To use a public type that's in a different package, you have three choices:
         *      (1) use the fully qualified name of the type,
         *      (2) import the type, or
         *      (3) import the entire package of which the type is a member.
         *
         * - The path names for a package's source and class files mirror the name of the package.
         *
         * - You might have to set your CLASSPATH so that the compiler and the JVM can find the .class files for your types.
         *
         * =============================================================================================================
         *  Packages are NOT hierarchical:
         * -------------------------------
         *
         * For example, the Java API includes a java.awt package, a java.awt.color package, a java.awt.font package,
         * and many others that begin with java.awt.
         *
         * However, the java.awt.color package, the java.awt.font package, and other java.awt.xxxx packages
         * are NOT included in the java.awt package!
         *
         * The prefix java.awt (the Java Abstract Window Toolkit) is used for a number of related packages
         * to make the relationship evident, but not to show inclusion.
         *
         * =============================================================================================================
         * Name ambiguities:
         * -----------------
         *
         * If a member in one package shares its name with a member in another package and both packages are imported,
         * you must refer to each member by its qualified name.
         *
         * For example:
         *      - the graphics package defined a class named Rectangle.
         *      - the java.awt package also contains a Rectangle class.
         *
         * If both
         *      graphics and
         *      java.awt
         * have been imported, the following is ambiguous:
         *
         * Rectangle rect;
         *
         * with
         *  import java.awt.*;
         * or
         *  import java.awt.Rectangle;
         *
         *  the following works:
         */
            Rectangle myRectangle = new Rectangle();
         /**
         * =============================================================================================================
         * Static imports:
         * ---------------
         *
         * The static import statement gives a way to import the constants and static methods
         *
         * E.g. the static members of Math can be imported either individually:
         *
         * import static java.lang.Math.PI;
         *
         * or as a group:
         *
         * import static java.lang.Math.*;
         *
         * Once they have been imported, the static members can be used without qualification.
          * For example, the previous code snippet would become:
         *
         * double r = cos(PI * theta);
         *
         * Obviously, you can write your own classes that contain constants and static methods that you use frequently,
         * and then use the static import statement. For example:
         *
         * import static mypackage.MyConstants.*;
         *
        */

         A myClassA = new A();

         /** Question: Which of the following import statements are unnecessary?
          * import java.lang.Math.*;
          * import static java.lang.Math.*;
          * import java.lang.*;
          */

         System.out.print(PI);
    }
}

class B extends A {
    public static void main(String[] args) {
        A a = new A();
    }
}

