package Objective_9_Working_With_Selected_Classes_from_Java_API.Subobjective_3;

import javax.swing.text.DateFormatter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

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
         */

        /** Creating LocalTime instances */

        LocalTime lt01 = LocalTime.ofNanoOfDay(19683);
        LocalTime lt02 = LocalTime.of(16, 32);
        LocalTime lt03 = LocalTime.of(16, 32, 55);
        LocalTime lt04 = LocalTime.of(16, 32, 55, 1550);
        LocalTime lt05 = lt04.plusMinutes(5);
        LocalTime lt06 = lt04.minusMinutes(1);

        /** Creating LocalDate instances: */

        LocalDate ldParse = LocalDate.parse("2018-12-31");
        LocalDate ld00 = LocalDate.of(2018, 06, 13).now();
        LocalDate ld01 = LocalDate.of(2018, Month.JUNE, 13);
        LocalDate ld02 = LocalDate.ofYearDay(2018, 185);
        LocalDate ld03 = LocalDate.ofEpochDay(5376); // Days since 1970-01-01
        LocalDate ld04 = ld00.plusYears(1);
        LocalDate ld05 = ld00.plusMonths(1);
        LocalDate ld06 = ld00.plusDays(1);
        LocalDate ld07 = ld00.minusYears(1);
        LocalDate ld08 = ld00.minusMonths(1);
        LocalDate ld09 = ld00.minusDays(1);

        // LocalDate + atTime = LocalDateTime
        LocalDateTime combinedLdAndTime00 = ld00.atTime(lt02);
      //LocalDateTime combinedLdAndTime01 = ld00.atTime(1); // for 'hour' only does not exist!
        LocalDateTime combinedLdAndTime02 = ld00.atTime(1, 1);
        LocalDateTime combinedLdAndTime03 = ld00.atTime(1, 1, 30);
        LocalDateTime combinedLdAndTime04 = ld00.atTime(1, 1, 30, 64);

        OffsetDateTime combinedLdAndTime05 = ld00.atTime(OffsetTime.MAX); // if OffsetTime is being used -> return type is OffsetTime, too!

        //LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());   // Java 1.9
        //LocalDate.getXXX(); // LocalDate has no getters.

        /** Creating LocalDateTime instances */

        LocalDateTime ldt00 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime ldt01 = LocalDateTime.now();
        LocalDateTime ldt02 = LocalDateTime.parse("2016-01-23 12:34".replace(" ", "T"));  // 'T' is expected in parsing the date string.
        LocalDateTime ldt03 = LocalDateTime.of(2018,06,13, 12,00);
        LocalDateTime ldt04 = LocalDateTime.of(2018,Month.JUNE,13, 12,00);
        LocalDateTime ldt05 = LocalDateTime.of(2018,06,13, 12,00, 00);
        LocalDateTime ldt06 = LocalDateTime.of(2018,Month.JUNE,13, 12,00, 00);
        LocalDateTime ldt07 = LocalDateTime.of(2018,06,13, 12,00, 00, 1658);
        LocalDateTime ldt08 = LocalDateTime.of(2018,Month.JUNE,13, 12,00, 00, 1658);
        LocalDateTime ldt09 = LocalDateTime.MAX;
        LocalDateTime ldt10 = LocalDateTime.MIN;
        LocalDateTime ldt11 = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.ofHoursMinutesSeconds(1,1,1));
        LocalDateTime ldt12 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());

        int ldt12Year = ldt12.getYear();
        Month ldt12Month = ldt12.getMonth();
        int ldt12MonthValue = ldt12.getMonthValue();

        int ldt12DayOfYear = ldt12.getDayOfYear(); // ranges from 1 to 366
        int ldt12DayOfMonth = ldt12.getDayOfMonth(); // ranges from 1 to 31

        int compareldt12Toldt10 = ldt12.compareTo(ldt10);

        long epochSecondLdt12 = ldt12.toEpochSecond(ZoneOffset.UTC);
        Instant ldt12Instant = ldt12.toInstant(ZoneOffset.UTC);

        // further methods:

        // plusYears, plusMonths, plusWeeks, plusDays, plusHours, plusMinutes, plusSeconds, plusNanos, plus(..)
        // minusYears, minusMonths, minusWeeks, minusDays, minusHours, minusMinutes, minusSeconds, minusNanos, minus(..)

        // withYear, withMonth, withDayOfYear, withDayOfMonth, withHour, withMinute, withSecond, withNano

        // atOffset, atZone, format,
        // toLocalDate, truncatedTo

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
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(formatter);

        System.out.println("formattedDate: " + formattedDate);
        LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
        System.out.println("parsedDate: " + parsedDate.toString());

        /** Period class:
         *  -------------
         *  - models a quantity or amount of time in terms of years, months and days */

        /** Creating Period instances */

        Period p00 = Period.ZERO;
        Period p01 = Period.ofYears(13);
        Period p02 = Period.ofMonths(6);
        Period p03 = Period.ofWeeks(22);
        Period p04 = Period.ofDays(13);
        Period p05 = Period.between(ld00, ld01);
        Period p06 = Period.from(p00);
        Period p07 = Period.parse("P1Y2M3W4D");

        Period p08 = p00.plus(p01);
        Period p09 = p01.minus(p00);

        Period p10 = p01.plusYears(3);
        Period p11 = p01.minusYears(3);
        Period p12 = p01.plusMonths(3);
        Period p13 = p01.minusMonths(3);
        Period p14 = p01.plusDays(3);
        Period p15 = p01.minusDays(3);

        Period p16 = p01.withYears(2018);
        Period p17 = p01.withMonths(6);
        Period p18 = p01.withDays(13);

        Period p19 = p01.normalized();

        Period p20 = p01.negated();
        Period p21 = p01.multipliedBy(3);

        Temporal p22 = p01.addTo(ldt00); // addTo is not recommends -> use plus(somePeriod)

        int p00Days = p00.getDays();
        int p00Months = p00.getMonths();
        int p00Years = p00.getYears();

        //Period.getXXX();  // getters do not exist
        //Period.withMonths(10); // does not exist
        //Period.plusDays(2);  // does not exist!
        //Period.minusDays(2);  // does not exist!

        Period p1 = Period.ofYears(1);
        Period p2 = Period.of(0,1,0);
        Period pYearAndMonth = p1.plus(p2);
        System.out.println("pYearAndMonth.getDays(): " + pYearAndMonth.getDays());

        /** Question 1: What happens when the following code is compiled and executed? */
        LocalDate datum = LocalDate.of(2077, 07, 07);
        System.out.println(datum);

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 2: What happens when the following code is compiled and executed? */
        LocalTime zeit = LocalTime.of(0,1,2);
        zeit.withHour(3).withMinute(4).withSecond(5); // zeit =  missing!
        System.out.println(zeit);

        /** --------------------------------------------------------------------------------------------------------- */

        /** Question 3: What happens when the following code is compiled and executed?
         *   Note: We use 'datum' from Question 1
         */

//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yy/mm/dd");
//        formattedDate = datum.format(formatter2);
//        System.out.println("applying formatter2 -> formattedDate: " + formattedDate);

        /**
         * A) Compilation fails
         * B) It throws an exception at runtime
         * C) It prints 2077 07 07
         * D) It prints 2077 00 07
         *
         */
        // Answer: B, because 'mm' in the pattern is NOT representing month! It represents minutes
        // Therefore this pattern is NOT supported by Formatter  -> UnssuprtedTemporalTypeException
        // Addition: It will not through an Exception if the date carries minutes ;)

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

        Period pMonth = Period.ofMonths(13);
        System.out.println("pMonth.normalized(): " + pMonth.normalized());

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
        //LocalDate date = y.atMonthDay(MonthDay.of(4,31)); // (FYI & unrelated to this question: A month-day of February 29th will be adjusted to February 28th in the resulting date if the year is not a leap year.)
        //System.out.println(date);

        // Answer: Passing 4 as the month and 31 as the day arguments for the method causes an exception
        //         because month April doesn't have such a day. Therefore answer d is correct.

        /** --------------------------------------------------------------------------------------------------------- */

        LocalDate dating = LocalDate.ofYearDay(2015, 40); // Somewhere in the middle of February
        dating.plusWeeks(2); // Trick!
        System.out.println("Is leap year? " + dating.isLeapYear());

        System.out.println("Days: " + dating.lengthOfMonth());

        /** --------------------------------------------------------------------------------------------------------- */

        LocalTime localTime = LocalTime.of(2, 2,15);
        LocalDate localDate = LocalDate.of(2015, 2, 21);
        LocalDateTime ldt = localTime.atDate(localDate);
        //LocalDateTime ldt2 = localDate.atTime(localTime); // alternative
        ldt.minusYears(2);
        ldt.minusDays(2);
        System.out.println("ldt: " + ldt.getYear() + "/" + ldt.getMonthValue() + "/" + ldt.getDayOfWeek());
        System.out.println("local time Chrono_of_Minute: " + localTime.getLong(ChronoField.valueOf("MINUTE_OF_DAY")));

        /** --------------------------------------------------------------------------------------------------------- */

        LocalDate ldt3 = LocalDate.of(2000, 12, 1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/uuuu");
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MMM/yyyy"); // 01/Dez./2000
        System.out.println(ldt3.format(format));

        /** --------------------------------------------------------------------------------------------------------- */

        LocalDate ldtChrono = LocalDate.of(2015, 12, 12);
        ldtChrono = ldtChrono.with(ChronoField.DAY_OF_YEAR, 40);
        System.out.println("new localDate after applying with(ChronoField.xxx): " + ldtChrono);

        /** --------------------------------------------------------------------------------------------------------- */

        LocalTime localTime2 = LocalTime.of(22,10);
        localTime2 = localTime2.truncatedTo(ChronoUnit.HALF_DAYS);
        System.out.println(localTime2);
    }
}