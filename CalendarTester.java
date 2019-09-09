
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Files: (a list of all source files used by that program)
// Course: (course number, term, and year)
//
// Author: Kareena Clendening
// Email: clendening@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Julia Bennett
// Partner Email: jbennett23@wisc.edu
// Partner Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
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
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class contains a few methods for testing methods in the CalendarPrinter class as they are
 * developed.
 * 
 * @author Julia Bennett
 * @author Kareena Clendening
 *
 */
public class CalendarTester {
  /**
   * This runs some tests on the getCentury method.
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * This runs some tests on the getYearWithinCentury method.
   */
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("10") != 10)
      return false;
    if (CalendarPrinter.getYearWithinCentury("100") != 0)
      return false;
    if (CalendarPrinter.getYearWithinCentury("1015") != 15)
      return false;
    return true;
  }

  /**
   * This runs some tests on the getIsLeapYear method.
   */
  public static boolean testGetIsLeapYear() {
    if (CalendarPrinter.getIsLeapYear("2000") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("1700") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("1800") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("2003") != false)
      return false;
    return true;
  }

  /**
   * This runs some tests on the getMonthIndex method.
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("febraurgkbekj") != 1)
      return false;
    if (CalendarPrinter.getMonthIndex("JAnvdjs") != 0)
      return false;
    if (CalendarPrinter.getMonthIndex("4snkjv") != -1)
      return false;
    if (CalendarPrinter.getMonthIndex("July") != 6)
      return false;
    return true;
  }

  /**
   * This runs some tests on the getNumberOfDaysInMonth method.
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("Febr", "2000") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("FebrUARy", "1999") != 28)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("March", "2000") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("JUNE", "1999") != 30)
      return false;
    return true;
  }

  /**
   * This runs some tests on the getFirstDayOfWeekInMonth method.
   */
  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("Septemberzzzz", "2019") != 6)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("February", "2019") != 4)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("May", "1976") != 5)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("April", "1400") != 1)
      return false;
    return true;
  }

  /**
   * This runs some tests on the generateCalendar method.
   */
  public static boolean testGenerateCalendar() {
    boolean sept2019Works = true;
    String[][] sept2019 = {{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"},
        {".", ".", ".", ".", ".", ".", "1"}, {"2", "3", "4", "5", "6", "7", "8"},
        {"9", "10", "11", "12", "13", "14", "15"}, {"16", "17", "18", "19", "20", "21", "22"},
        {"23", "24", "25", "26", "27", "28", "29"}, {"30", ".", ".", ".", ".", ".", "."}};

    for (int i = 0; i < sept2019.length; ++i) {
      for (int j = 0; j < sept2019[i].length; ++j) {
        if (CalendarPrinter.generateCalendar("Septemberzzzz", "2019")[i][j]
            .equals(sept2019[i][j]) == false)
          sept2019Works = false;
      }
    }

    // June 2020
    boolean june2020Works = true;
    String[][] june2020 =
        {{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"}, {"1", "2", "3", "4", "5", "6", "7"},
            {"8", "9", "10", "11", "12", "13", "14"}, {"15", "16", "17", "18", "19", "20", "21"},
            {"22", "23", "24", "25", "26", "27", "28"}, {"29", "30", ".", ".", ".", ".", "."}};

    for (int i = 0; i < june2020.length; ++i) {
      for (int j = 0; j < june2020[i].length; ++j) {
        if (CalendarPrinter.generateCalendar("June", "2020")[i][j]
            .equals(june2020[i][j]) == false) {
          june2020Works = false;
        }
      }
    }
    // May 1776
    boolean may1776Works = true;
    String[][] may1776 =
        {{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"}, {".", ".", "1", "2", "3", "4", "5"},
            {"6", "7", "8", "9", "10", "11", "12"}, {"13", "14", "15", "16", "17", "18", "19"},
            {"20", "21", "22", "23", "24", "25", "26"}, {"27", "28", "29", "30", "31", ".", "."}};
    for (int i = 0; i < may1776.length; ++i) {
      for (int j = 0; j < may1776[i].length; ++j) {
        if (CalendarPrinter.generateCalendar("May", "1776")[i][j].equals(may1776[i][j]) == false) {
          may1776Works = false;
        }
      }
    }

    // Feb 2000, testing leap year
    boolean feb2000Works = true;
    String[][] feb2000 =
        {{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"}, {".", ".", "1", "2", "3", "4", "5"},
            {"6", "7", "8", "9", "10", "11", "12"}, {"13", "14", "15", "16", "17", "18", "19"},
            {"20", "21", "22", "23", "24", "25", "26"}, {"27", "28", "29", ".", ".", ".", "."}};

    for (int i = 0; i < feb2000.length; ++i) {
      for (int j = 0; j < feb2000[i].length; ++j) {
        if (CalendarPrinter.generateCalendar("Feb", "2000")[i][j].equals(feb2000[i][j]) == false) {
          feb2000Works = false;
        }
      }
    }
    // return false is any of the calendars generated don't match
    if (!sept2019Works || !may1776Works || !june2020Works || !feb2000Works)
      return false;
    
    return true;
  }

  /**
   * This is the main method that runs the various tests. Uncomment the tests when you are ready for
   * them to run.
   * 
   * @param args (unused)
   */
  public static void main(String[] args) {
    System.out.println("It is " + testGetCentury() + " that the getCentury method works!");
    System.out.println("It is " + testGetYearWithinCentury()
        + " that the getYearWithinCentury method" + " works!");
    System.out.println("It is " + testGetIsLeapYear() + " that the getIsLeapYear method works!");
    System.out.println("It is " + testGetMonthIndex() + " that the getMonthIndex method works!");
    System.out.println("It is " + testGetNumberOfDaysInMonth() + " that the getNumberofDaysInMonth"
        + " method works!");
    System.out.println("It is " + testGetFirstDayOfWeekInMonth()
        + " that the getFirstDayOfWeekInMonth" + " method works!");
    System.out.println("It is " + testGenerateCalendar() + " that the generateCalendar() "
        + "method works!");
  }
}
