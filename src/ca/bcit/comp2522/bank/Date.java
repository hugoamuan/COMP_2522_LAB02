package ca.bcit.comp2522.bank;

import java.time.LocalDate;

/**
 * Date Class, representing the properties and functions of how humans perceive and track time.
 * @author Hugo Amuan and Mitchell MacDonald
 * @version 1.0
 */
public class Date {

    private static final int START_OF_INDEX = 1;

    private static final int BEFORE_THE_FIRST_DAY_OF_MONTH = 1;

    private static final int LEAP_YEAR_CORRECTION = 6;

    private static final int TWENTIETH_CENTURY_ADJUSTMENT = 2;

    private static final int TWELVE_DIVISOR = 12;

    private static final int TWENTY_FIRST_CENTURY = 2000;

    private static final int EIGHTEENTH_CENTURY = 1800;

    private static final int NINETEENTH_CENTURY = 1900;

    private static final int NUM_OF_DAYS_PER_WEEK = 7;

    private static final int THIRTY_ONE_DAYS = 31;

    private static final int THIRTY_DAYS = 30;

    private static final int TWENTY_NINE_DAYS = 29;

    private static final int TWENTY_EIGHT_DAYS = 28;

    private final int year;

    private final int month;

    private final int day;

    private static final int CURRENT_YEAR = 2024;

    private static final int MIN_YEAR_ALLOWED = 1;


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
    private static final int ONE_HUNDRED = 100;

    /**
     * Variable holding the number four.
     */
    private static final int QUARTER_DIVISOR = 4;

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
     * Array of integers holding the monthCodes for calculating getDayOfWeek()
     */
    // From January - December (ascending order)
    private final static int[] monthCodes = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};

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
     * Constructs a Date object after validating the year, month, and day.
     * @param year  the year of the date, must be between 1 and the current year.
     * @param month the month of the date, must be between 1 (January) and 12 (December).
     * @param day   the day of the month, must be valid according to the month and year.
     * @throws IllegalArgumentException if the year, month, or day is invalid.
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
     * Returns the date formatted as "YYYY-MM-DD".
     * @return the formatted date as a string
     */

    public String getYYYYMMDD() {
        return year + "-" + month + "-" + day;
    }


    /**
     * Validates that the year is within an acceptable range.
     * @param year the year to be validated
     * @throws IllegalArgumentException if the year is outside the valid range.
     */

    private static void validateYear(int year) {
        if (year > CURRENT_YEAR || year < MIN_YEAR_ALLOWED) {
            throw new IllegalArgumentException("Invalid year, must be between 0 - 2024");
        }
    }

    /**
     * Validates that the month is within an acceptable range.
     * @param month the month to be validated
     * @throws IllegalArgumentException if the month is outside the valid range.
     */

    private static void validateMonth(int month) {
        if (month < JANUARY || month > DECEMBER) {
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
        if (day < BEFORE_THE_FIRST_DAY_OF_MONTH || day > daysInMonth) {
            throw new IllegalArgumentException("Invalid days for the given month. Maximum amount is: "
                    + daysInMonth);
        }
    }

    /**
     * Calculates the days in a month given a year.
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
                return THIRTY_ONE_DAYS;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return THIRTY_DAYS;
            case FEBRUARY:
                // If true, days in February = 29
                return isLeapYear(year) ? TWENTY_NINE_DAYS : TWENTY_EIGHT_DAYS; // Review Ternary operators!
        }
        throw new IllegalArgumentException("Invalid month: " + month);
    }

    /**
     * This constructor validates the input date based on the following rules:
     * 1. The year must be between 1800 and the current year (inclusive).
     * 2. The month must be between 1 (January) and 12 (December).
     * 3. The day must be between 1 and 31, or adjusted for the specific month (e.g., 30 days for some months,
     *    28 or 29 days for February depending on whether it's a leap year).
     *
     * Methods:
     * - `getDay()`: Returns the day of the month.
     * - `getMonth()`: Returns the month of the year.
     * - `getYear()`: Returns the year.
     * - `getYYYYMMDD()`: Returns a formatted date string in the format `YYYY-MM-DD`.
     * - `getDayOfTheWeek()`: Returns the day of the week using the following method for dates in the 1900s:
     *
     * Steps for calculating the day of the week (example: October 31, 1977):
     * 1. Calculate the number of twelves in the year part (e.g., 77):
     *    `77 / 12 = 6`.
     * 2. Calculate the remainder:
     *    `77 - 12 * 6 = 5`.
     * 3. Calculate the number of fours in the remainder:
     *    `5 / 4 = 1`.
     * 4. Add the day of the month to the values from steps 1, 2, and 3:
     *    `31 + 6 + 5 + 1 = 43`.
     * 5. Add the month code (October = 1; for Jan to Dec, the codes are: `144025036146`):
     *    `43 + 1 = 44`.
     * 6. Take the result from step 5 and mod it by 7 to get the remainder:
     *    `44 % 7 = 2`.
     * 7. Using the remainder (where 0 = Saturday, 1 = Sunday, ..., 6 = Friday), determine the day of the week:
     *    `2 = Monday`.
     *
     * @throws IllegalArgumentException if any date value is out of range.
     */
    public String getDayOfWeek() {
        int Num_Of_Twelves_Last_Two_Digits_Of_Year = (year % ONE_HUNDRED) / TWELVE_DIVISOR;
        int remainder = (year % ONE_HUNDRED) - TWELVE_DIVISOR * Num_Of_Twelves_Last_Two_Digits_Of_Year;
        int Num_Of_Fours_In_Remainder = remainder / QUARTER_DIVISOR;

        int sum = Num_Of_Twelves_Last_Two_Digits_Of_Year + remainder + Num_Of_Fours_In_Remainder + day;

        sum += monthCodes[month - START_OF_INDEX];

        // Adjustments for specific cases
        if (isLeapYear(year) && (month == JANUARY || month == FEBRUARY)) {
            sum += LEAP_YEAR_CORRECTION;
        }
        if (year >= TWENTY_FIRST_CENTURY) {
            sum += LEAP_YEAR_CORRECTION;
        } else if (year >= EIGHTEENTH_CENTURY && year < NINETEENTH_CENTURY) {
            sum += TWENTIETH_CENTURY_ADJUSTMENT;
        }

        // Calculate final result
        int dayIndex = (sum % NUM_OF_DAYS_PER_WEEK) - START_OF_INDEX;

        return DAY_OF_WEEK[dayIndex];
    }

    /**
     * Determines if the given year is a leap year.
     * A leap year is divisible by 4, but not divisible by 100 unless it is also divisible by 400.
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
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
     /**
     * Formats the date as "DayOfWeek Month Day, Year".
     * @return the formatted date as a string
     */

    public String dateFormatter() {
        return String.format("%s %s %d, %d",
                getDayOfWeek(),
                getMonthName(),
                day,
                year
        );
    }

    /**
     * Method that retrieves the current date using LocalDate class.
     * @return Date of today.
     */
    public static Date currentDate() {
        final LocalDate today = LocalDate.now();
        return new Date(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
    }

    // Used to validate creature's birthday.
    // Greater than (comes after)
    /**
     * Method that checks if a given date proceeds another.
     * @param other date to be compared to
     * @return true if the other date is lesser
     */
    public boolean proceeds(Date other) {
        return this.compareTo(other) > 0;
    }

    /**
     * Method that checks if a given date preceded another.
     * @param other date to be compared to
     * @return true if the other date is greater.
     */
    // Less than (comes before)
    public boolean preceeds(Date other) {
        return this.compareTo(other) < 0;
    }

    /**
     * Compares this date to another date.
     * @param other the date to compare to
     * @return a negative integer if this date is before the other date,
     *         zero if they are equal, and a positive integer if this date is after the other date.
     */

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