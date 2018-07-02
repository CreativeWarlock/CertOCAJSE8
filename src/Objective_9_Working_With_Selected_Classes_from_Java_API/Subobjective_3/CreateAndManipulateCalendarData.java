package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_3;

import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

import java.text.SimpleDateFormat;

public class CreateAndManipulateCalendarData {

    // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
    // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
    // https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
    // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    // https://docs.oracle.com/javase/8/docs/api/java/time/Period.html

    public static void main(String[] args) {
        System.out.println("Chapter 9.3 - Create and manipulate Calendar data");

        /**
         * A preliminary remark about
         *
         * Value-based Classes:
         * --------------------
         *
         * Some classes, such as java.util.Optional and java.time.LocalDateTime, are VALUE-BASED.
         *
         * Instances of a value-based class:
         *     - are final and immutable (though may contain references to mutable objects);
         *     - have implementations of equals, hashCode, and toString which are computed solely
         *       from the instance's state and not from its identity or the state of any other object or variable;
         *
         *     - make NO use of identity-sensitive operations such as reference equality (==) between instances,
         *       identity hash code of instances, or synchronization on an instances's intrinsic lock;
         *
         *     - are considered equal solely based on equals(), not based on reference equality (==);
         *
         *     - do not have accessible constructors, but are instead instantiated through factory methods
         *       which make no commitment as to the identity of returned instances;
         *
         *     - are freely substitutable when equal, meaning that interchanging any two instances x and y that are equal
         *       according to equals() in any computation or method invocation should produce no visible change in behavior.
         *
         * A program may produce unpredictable results if it attempts to distinguish two references
         * to equal values of a value-based class, whether
         *      - directly via reference equality or
         *      - indirectly via an appeal to synchronization, identity hashing, serialization, or any other identity-sensitive mechanism.
         *
         *  Use of such identity-sensitive operations on instances of value-based classes may have unpredictable effects and should be avoided.
         *
         * */

        /**
         * Date-Time Classes:
         * ------------------
         * - LocalDateTime is an immutable date-time object that represents
         * a DATE-TIME, often viewed as "year-month-day-hour-minute-second"
         *          Other accessible 'date and time' fields:
         *          * day-of-year
         *          * day-of-week
         *          * week-of-year
         * Time is represented to nano-second precision.
         *
         * LocalDate is an immutable 'date-time' object that represents
         * a DATE, often viewed as "year-month-day"
         *          Other accessible 'date' fields:
         *          * day-of-year
         *          * day-of-week
         *          * week-of-year
         *
         * LocalTime is an immutable 'time' object that represents
         * a time, often viewed as hour-minute-second;
         * Time is represented to nano-second precision.
         *
         * Date-Time Methods:
         * ------------------ */

        // Creating a new LocalDateTime instance

        LocalDateTime.parse("2016-01-23 12:34".replace(" ", "T"));

        LocalDateTime.now();
        LocalTime.of(16, 32, 55);

        // Getting date-time information
        //LocalDate.getYear(); // cannot find this method
        LocalTime bla = LocalTime.of(1,2,3);

        bla.plusMinutes(5);
        bla.minusMinutes(1);

        /**
         * DateFormatter class:
         * --------------------
         * - helps to print and parse date-time objects
         * - provides an entry point for printing and parsing as well as
         *   common implementations of DateTimeFormatter:
         *
         *      + Using predefined constant, such as ISO_LOCAL_DATE
         *      + Using pattern letters, such as uuuu-MMM-dd
         *      + Using localized styles, such as long or medium
         *
         * Example:
         * */
/*        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDate date = LocalDate.now();
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);*/

        /** Period class:
         *  -------------
         *  - models a quantity or amount of time in terms of years, months and days */

        // Creating a new Period instance
        //Period.parse("2016-01-23 12:34");
        //Period.ofDays(13);
        // Period.withMonths(10); // does not exist

        //Period.getYear();  // does not exist

        //Period.plusDays(2);  // does not exist
        //Period.minusDays(2);  // does not exist

        /** Question 1: What happens when the following code is compiled and executed? */
        LocalDate datum = LocalDate.of(2077, 07, 07);
        System.out.println(datum);

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 2: What happens when the following code is compiled and executed? */
        LocalTime zeit = LocalTime.of(0,1,2);
        zeit.withHour(3).withMinute(4).withSecond(5); // zeit =  missing!
        System.out.println(zeit);

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 3: What happens when the following code is compiled and executed? */
        // we take datum from above
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy mm dd");
//        String formattedDate = datum.format(formatter);
//        System.out.println(formattedDate);

        /**
         * A) Compilation fails
         * B) It throws an exception at runtime
         * C) It prints 2077 07 07
         * D) It prints 2077 00 07
         *
         */
        // Answer: B, because 'mm' in the pattern is NOT representing month! It represents minutes
        // Therefore this pattern is NOT supported by Formatter  -> UnssuprtedTemporalTypeException

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 4: What happens when the following code is compiled and executed?
         * A) It throws an exception at runtime
         * B) It prints "p01y"
         * C) It prints "P1Y"
         * D) It prints "P01Y"
         * */

        Period p = Period.parse("p01y");
        System.out.println(p);

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 5: Which of the following can be used with the following variable ld?
         * A) Instant lt = ld.atTime(10, 10);
         * B) LocalDateTime lt = ld.atTime(10, 10);
         * C) LocalDate lt = ld.atTime(10, 10);
         * D) LocalTime lt = ld.atTime(10, 10);
         * E) Date lt = ld.atTime(10, 10);
         * */

        LocalDate ld = LocalDate.of(2018, 07, 07);
        // your answer here

        // Answer: Since the returning type of LocalDate.of combines both a date and a time the required type for lt is LocalDateTime -> B

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 6: What is the result of the following code?
         * A) 2
         * B) 3
         * C) MARCH
         * D) An Exception
         * E) Compilation fails
         * */

        LocalDate whichMonth = LocalDate.of(2018, 2, 27).plusDays(3);
        System.out.println("whichMonth is: " + whichMonth.getMonth());
        System.out.println("whichMonth value is: " + whichMonth.getMonthValue());

        // Answer: Since getMonth returns an ENUM and the added days place the date to the next month, the answer is C.

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 7: What is the output of the following code?
         * A) P1Y1M
         * B) P13M
         * C) P1Y
         * D) An Exception
         * E) Compilation fails
         * */

        Period p2 = Period.ofMonths(13);
        System.out.println(p2.normalized());

        // Answer: Since the months will increase the year by one, the normalized period will have 1Y, and the remaining months 1M, therefor answer A is the output.

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 8: What is the output of the following code?
         * A) 2018-03-31
         * B) 2017-05-01
         * C) 2017-04-31
         * D) An Exception
         * E) Compilation fails
         * */

        Year y = Year.of(2018);
        //LocalDate date = y.atMonthDay(MonthDay.of(4,31)); //A month-day of February 29th will be adjusted to February 28th in the resulting date if the year is not a leap year.
        //System.out.println(date);

        // Answer: Passing 4 as the month and 31 as the day arguments for the method causes an exception
        //         because month April doesn't have such a day. Therefore answer d is correct.

        /** --------------------------------------------------------------------------------------------------------- */

        LocalDate dating = LocalDate.ofYearDay(2015, 363);
        dating.plusWeeks(2);
        System.out.println("Is leap year? " + dating.isLeapYear());

        System.out.println("Days: " + dating.lengthOfMonth());
    }
}