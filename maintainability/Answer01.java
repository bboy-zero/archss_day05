package maintainability;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Answer 01: Improving Date Manipulation Code
 * 
 * Key Improvements & Fixes:
 * 1. Fixed Bugs in Original Code:
 *    - `cal.add(Calendar.DAY_OF_MONTH, months)` incorrectly added days instead of months (should be Calendar.MONTH).
 *    - `cal.add(Calendar.DAY_OF_WEEK, weeks)` incorrectly modified the day-of-week field rather than adding weeks.
 * 2. Replaced Legacy API (`Calendar`, `SimpleDateFormat`):
 *    - Modern Java 8+ `java.time` API (`LocalDate`, `DateTimeFormatter`) is immutable, thread-safe, and self-documenting.
 * 3. Clean API:
 *    - Using `date.plusMonths()`, `date.plusWeeks()`, `date.plusDays()`.
 */
public class Answer01 {

    public static void main(String[] args) {
        String inputDate = "01/12/2025";
        System.out.println("The Actual Date is: " + inputDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // Add 0 months, 0 weeks, 5 days
        LocalDate modifiedDate = addTimeToDate(date, 0, 0, 5);

        System.out.println("The Modified Date is: " + modifiedDate.format(formatter));
    }

    /**
     * Adds months, weeks, and days to a LocalDate instance cleanly and immutably.
     */
    public static LocalDate addTimeToDate(LocalDate date, int months, int weeks, int days) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.plusMonths(months)
                   .plusWeeks(weeks)
                   .plusDays(days);
    }
}
