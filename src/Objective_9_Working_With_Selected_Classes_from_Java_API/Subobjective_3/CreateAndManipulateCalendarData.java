package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_3;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
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

        /** Question 2: What happens when the following code is compiled and executed? */
        LocalTime zeit = LocalTime.of(0,1,2);
        zeit.withHour(3).withMinute(4).withSecond(5); // zeit =  missing!
        System.out.println(zeit);

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

        /** Question 4: What happens when the following code is compiled and executed?
         * A) It throws an exception at runtime
         * B) It prints "p01y"
         * C) It prints "P1Y"
         * D) It prints "P01Y"
         * */

        Period p = Period.parse("p01y");
        System.out.println(p);
    }
}