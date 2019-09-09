//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Files: (a list of all source files used by that program)
// Course: (course number, term, and year)
//
// Author: Kareena Clendening
// Email: clendening@wisc.edu
// Lecturer's Name: Mouna
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Julia Bennet
// Partner Email: jbennett23@wisc.edu
// Partner Lecturer's Name: Mouna
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __X_ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// __X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Arrays;

import java.util.Scanner;

/**
 * This class develops a calendar of any given month and year. 
 * 
 * @author Julia Bennett
 * @author Kareena Clendening
 *
 */
public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {
    return Integer.parseInt(year) / 100; // converts the string to an integer and then divides by
                                         // 100 to get the century
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */

  public static int getYearWithinCentury(String year) {
    // checks if there is one digit then converts to an integer
    if (year.length() == 1) {
      return Integer.parseInt(year);
      // takes the last two numbers and converts them to two digit number
    } else
      return Integer.parseInt(year.substring(year.length() - 2, year.length()));
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */

  public static boolean getIsLeapYear(String yearString) {
    int year = Integer.parseInt(yearString);
    boolean leap;
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        // year is divisible by 400, hence the year is a leap year
        if (year % 400 == 0)
          leap = true;
        else
          leap = false;
      } else
        leap = true;
    } else
      leap = false;
    return leap;
  }

  // Note implementation tips in Appendix I below.

  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */

  public static int getMonthIndex(String month) {
    // get the abbreviation of the month
    String abbrev = month.trim().substring(0, 3).toUpperCase();
    // checks if the abbreviation matches any of the months
    for (int i = 0; i < MONTHS_OF_YEAR.length - 1; i++) {
      if (abbrev.equals(MONTHS_OF_YEAR[i])) {
        return i; // returns the index of the matching month
      }
    }
    return -1; // returns -1 if it doesn't match
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */

  public static int getNumberOfDaysInMonth(String month, String year) {
    int monthIndex = getMonthIndex(month);
    // returns 29 days if the month is February and it is leap year
    if (monthIndex == 1 && getIsLeapYear(year))
      return 29;
    // returns 28 days if the month is February and not a leap year
    else if (monthIndex == 1)
      return 28;
    // returns 31 days for Jan, March, May, July, August, October, and December
    else if (monthIndex == 0 || monthIndex == 2 || monthIndex == 4 || monthIndex == 6
        || monthIndex == 7 || monthIndex == 9 || monthIndex == 11)
      return 31;
    // otherwise returns 30 days for other months
    else
      return 30;
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) {
    int centuryYear = getYearWithinCentury(year);
    int century = getCentury(year);
    int monthIndex = getMonthIndex(month);

    if (monthIndex == 0) {
      // January is the "13th" month of the previous year in equation
      monthIndex = 13;
      centuryYear -= 1;
    } else if (monthIndex == 1) {
      // February is the "14th" month of the previous year in equation
      monthIndex = 14;
      centuryYear -= 1;
    }
    // adjusting indexing of method to fit equation
    else
      monthIndex += 1;


    // plugs the numbers into an equation to determine the first day of week in the month
    int h = (int) ((1 + Math.floor((13 * (monthIndex + 1)) / 5) + centuryYear
        + Math.floor((centuryYear / 4)) + Math.floor((century / 4)) + (5 * century)) % 7);

    // aligning indexing of the week days with the rest of the code
    switch (h) {
      case 0:
        return 5;
      case 1:
        return 6;
      case 2:
        return 0;
      case 3:
        return 1;
      case 4:
        return 2;
      case 5:
        return 3;
      case 6:
        return 4;
      default:
        return -1;
    }
  }

  // Note implementation tips in Appendix I below.
  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
   * 22 23 24 25 26 27 28 29 30 . . . . . .
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {

    int day = 1; // keeps track of the day of the month
    int daysInMonth = getNumberOfDaysInMonth(month, year); 
    int firstDayOfMonth = getFirstDayOfWeekInMonth(month, year);
    
    // determines the number of rows in the calendar based on days in month and the first day
    int calRows = 1 + (daysInMonth + firstDayOfMonth) / DAYS_OF_WEEK.length;

    // adds an additional row if the number of days spaces needed in calendar is not evenly 
    // divisible by the days of the week
    if ((daysInMonth + firstDayOfMonth) % DAYS_OF_WEEK.length != 0)
      calRows += 1;

    String[][] calArr = new String[calRows][DAYS_OF_WEEK.length];
    for (int j = 0; j < calArr[0].length; ++j) {
      calArr[0][j] = DAYS_OF_WEEK[j];
    }
    for (int j = 0; j < firstDayOfMonth; ++j) {
      calArr[1][j] = ".";
    }
    for (int j = firstDayOfMonth; j < DAYS_OF_WEEK.length; ++j) {
      calArr[1][j] = Integer.toString(day);
      ++day;
    }
    for (int i = 2; i < calRows; ++i) {
      for (int j = 0; j < DAYS_OF_WEEK.length; ++j) {
        calArr[i][j] = Integer.toString(day);
        ++day;
        if (day > daysInMonth + 1) {
          for (int k = j; k < DAYS_OF_WEEK.length; ++k) {
            calArr[i][k] = ".";
          }
          break;
        }
      }
    }

    return calArr;
  }
  /**
   * This is the main method that develops a calendar based on the user inputs of the month and year
   * 
   * @param args  (unused)
   */
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("================================");
    // prompts the user to print out the month
    System.out.println("Enter the month to print: ");
    String month = sc.nextLine();
    // prompts the user to print the year
    System.out.println("Enter the year to print: ");
    String year = sc.nextLine();
    // prints out the calendar
    String[][] calendar = generateCalendar(month, year);
    for (int i = 0; i < calendar.length; i++) {
      for (int j = 0; j < calendar[i].length; j++) {
        System.out.print(calendar[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");



  }
}

