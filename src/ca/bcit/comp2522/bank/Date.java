package ca.bcit.comp2522.bank;

import java.time.LocalDate;

/**
 * Date Class, representing the properties and functions of how humans perceive and track time.
 * @author HugoAmuan
 * @version 1.0
 */
public class Date {

    /**
     * Variable storing the number seven
     */
    private static final int SEVEN = 7;
    /**
     * Variable storing the number thirteen. (For zellers congruence)
     */
    private static final int THIRTEEN = 13;
    /**
     * Variable storing the number 31.
     */
    private static final int THIRTY_ONE = 31;
    /**
     * Variable storing the number 30.
     */
    private static final int THIRTY = 30;
    /**
     * Variable storing the number 29.
     */
    private static final int TWENTY_NINE = 29;
    /**
     * Variable storing the number 28
     */
    private static final int TWENTY_EIGHT = 28;
    /**
     * Variable storing the number 6.
     */
    private static final int SIX = 6;
    /**
     * Variable storing the number 5.
     */
    private static final int FIVE = 5;
    /**
     * Variable storing the year for the Date object.
     */
    private final int year;
    /**
     * Variable storing the month for the Date object.
     */
    private final int month;
    /**
     * Variable storing the day for the Date object.
     */
    private final int day;
    /**
     * Variable holding the current year.
     */
    private static final int CURRENT_YEAR = 2024;
    /**
     * Variable holding the minimum year.
     */
    private static final int MIN_YEAR = 1;
    /**
     * Variable holding the required minimum value for month.
     */
    private static final int MIN_MONTH = 1;
    /**
     * Variable holding the maximum value for month
     */
    private static final int MAX_MONTH = 12;
    /**
     * Variable holding the value for the given month, used in the switch loop in getDaysInMonth()
     */
    private static final int JANUARY = 1;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int FEBRUARY = 2;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int MARCH = 3;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int APRIL = 4;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int MAY = 5;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int JUNE = 6;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int JULY = 7;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int AUGUST = 8;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int SEPTEMBER = 9;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int OCTOBER = 10;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int NOVEMBER = 11;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int DECEMBER = 12;
    /**
     * Variable holding the position of the month out of twelve.
     */
    private static final int HUNDRED = 100;

    /**
     * Variable holding the number four.
     */
    private static final int FOUR = 4;

    /**
     * Variable with a value of 4 as well, but is named differently for clarity.
     */
    private static final int LEAP_YEAR_DIVISOR = 4;
    /**
     * Required variable to calculate if a year is a leap year.
     */
    private static final int CENTURY_DIVISOR = 100;
    /**
     * Required variable to calculate if a year is a leap year.
     */
    private static final int ALT_CENTURY_DIVISOR = 400;
    /**
     * Variable holding the number of months in a year
     */
    private static final int MONTHS_IN_YEAR = 12;


    /**
     * Array of type String that holds the word form for days of the week.
     */
    private static final String[] DAY_OF_WEEK = {
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY"
    };

    /**
     * Constructor for date objects.
     *
     * @param year  of the date
     * @param month of the date
     * @param day   of the date
     */
    public Date(int year, int month, int day) {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Getter method for day
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Getter method for month
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter method for year
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Method to format the date as YYYY-MM-DD
     *
     * @return YYYY-MM-DD
     */
    public String getYYYYMMDD() {
        return year + "-" + month + "-" + day;
    }


    /**
     * Validates the year
     *
     * @param year to be validated
     */
    private static void validateYear(int year) {
        if (year > CURRENT_YEAR || year < MIN_YEAR) {
            throw new IllegalArgumentException("Invalid year, must be between 0 - 2024");
        }
    }

    /**
     * Validates the month
     *
     * @param month to be validated
     */
    private static void validateMonth(int month) {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new IllegalArgumentException("Invalid month, must be input as 0 - 12 (Jan to Dec)");
        }
    }


    /**
     * Validates if the number of days is valid for the month and year given.
     *
     * @param year  of the date
     * @param month of the date
     * @param day   of the date
     */
    private static void validateDay(int year, int month, int day) {
        int daysInMonth = getDaysInMonth(year, month);
        if (day < 1 || day > daysInMonth) {
            throw new IllegalArgumentException("Invalid days for the given month. Maximum amount is: "
                    + daysInMonth);
        }
    }

    /**
     * Calculates the days in a month given a year.
     *
     * @param year  to be checked if is leap year.
     * @param month to be searched for number of days.
     * @return the number of days in a given month + year.
     */

    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return THIRTY_ONE;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return THIRTY;
            case FEBRUARY:
                // If true, days in February = 29
                return isLeapYear(year) ? TWENTY_NINE : TWENTY_EIGHT; // Review Ternary operators!
        }
        throw new IllegalArgumentException("Invalid month: " + month);
    }

    /**
     * Method utilizing Zeller's Congruence to calculate what day a certain date fell on.
     *
     * @return Finds DAY_OF_WEEK[x] and returns the word from an Array of Strings
     */
    public String getDayOfWeek() {
        // Use a temporary variable to adjust the month, otherwise monthValidator() will result in an error.
        int tempMonth = month;
        int tempYear = year;

        // In Zeller's Congruence, Jan and Feb are treated as the 13th and 14th months of the previous year.
        if (tempMonth < Date.MARCH) {
            tempMonth += MONTHS_IN_YEAR;
            // Go back a year
            tempYear -= 1;
        }

        int lastTwoDigits = tempYear % HUNDRED;
        int j = tempYear / HUNDRED;


        // Zeller's  Congruence formula
        // h = day of the week (0 - 6 (Sun - Fri))
        int h = (day + (THIRTEEN * (tempMonth + 1)) / FIVE + lastTwoDigits + (lastTwoDigits / FOUR) + (j / FOUR) - 2 * j) % SEVEN;

        // Ensure h is within bounds of the DAY_OF_WEEK array
        // if (h + SIX) = -1
        // (-1) % 7 = 6
        return DAY_OF_WEEK[(h + SIX) % SEVEN];
    }


    /**
     * Method to verify if a given year has an additional day.
     *
     * @param year to be verified.
     * @return true/false
     */
    public static boolean isLeapYear(int year) {
        return year % LEAP_YEAR_DIVISOR == 0 || (year % CENTURY_DIVISOR != 0
                && year % ALT_CENTURY_DIVISOR == 0);
    }


    /**
     * Method to turn an integer value for month into a string.
     *
     * @return x where x is the string representation of a numbered month.
     */
    public String getMonthName() {
        switch (month) {
            case JANUARY:
                return "January";
            case FEBRUARY:
                return "February";
            case MARCH:
                return "March";
            case APRIL:
                return "April";
            case MAY:
                return "May";
            case JUNE:
                return "June";
            case JULY:
                return "July";
            case AUGUST:
                return "August";
            case SEPTEMBER:
                return "September";
            case OCTOBER:
                return "October";
            case NOVEMBER:
                return "November";
            case DECEMBER:
                return "December";
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    /**
     * Formats a date as: Monday September 28 1994
     */
    public String dateFormatter() {
        return String.format("%s %s %d, %d",
                getDayOfWeek(),
                getMonthName(),
                day,
                year
        );
    }

    public static Date currentDate() {
        final LocalDate today = LocalDate.now();
        return new Date(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
    }

    public boolean proceeds(Date other) {
        return this.compareTo(other) > 0;
    }

    public boolean preceeds(Date other) {
        return this.compareTo(other) < 0;
    }

    public int compareTo(Date other) {
        final int otherYear = other.getYear();
        final int otherMonth = other.getMonth();
        final int otherDay = other.getDay();

        final int yearDiff = this.year - otherYear;
        if (yearDiff != 0) return yearDiff;

        final int monthDiff = this.month - otherMonth;
        if (monthDiff != 0) return monthDiff;

        return this.day - otherDay;
    }
}