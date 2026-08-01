package maintainability;

import java.time.Instant;
import java.util.Date;

/**
 * Answer 05: Simplifying Complex Logical Conditions
 * 
 * Key Improvements:
 * 1. Fixed bug in original code: `compareTo(...) > 1` was incorrect because `compareTo` returns > 0 for future dates.
 * 2. Decomposed condition using descriptive variable names / helper methods.
 * 3. Replaced double-negative inverted return logic with a direct boolean expression.
 * 4. Demonstrated modern `java.time.Instant` approach alongside legacy `Date`.
 */
public class Answer05 {

    /**
     * Legacy java.util.Date implementation with clear, un-nested condition.
     */
    public boolean isDateExpired(Date date) {
        if (date == null) {
            return true; // Null date considered expired or invalid
        }

        boolean isFutureDate = date.after(new Date());
        return !isFutureDate;
    }

    /**
     * Modern java.time.Instant implementation.
     */
    public boolean isInstantExpired(Instant instant) {
        if (instant == null) {
            return true;
        }
        return !instant.isAfter(Instant.now());
    }
}
