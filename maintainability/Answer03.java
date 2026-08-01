package maintainability;

/**
 * Answer 03: Input Validation and Exception Handling
 * 
 * Key Improvements:
 * 1. Added explicit parameter and state validation for discount and total.
 * 2. Throws `IllegalArgumentException` for invalid discount ranges (e.g. < 0 or > 100) or negative total.
 * 3. Handles potential arithmetic errors or illegal states explicitly.
 */
public class Answer03 {

    private double total;

    public Answer03(double total) {
        setTotal(total);
    }

    public void setTotal(double total) {
        if (Double.isNaN(total) || Double.isInfinite(total) || total < 0) {
            throw new IllegalArgumentException("Total must be a non-negative finite number. Provided: " + total);
        }
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    /**
     * Calculates discount based on percentage.
     * 
     * @param discountPercentage Discount percentage (0.0 to 100.0)
     * @return Discount amount
     * @throws IllegalArgumentException if discount percentage is invalid or total is negative
     * @throws ArithmeticException if an arithmetic failure occurs
     */
    public double calculateDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100. Provided: " + discountPercentage);
        }
        if (Double.isNaN(discountPercentage) || Double.isInfinite(discountPercentage)) {
            throw new IllegalArgumentException("Discount percentage must be a valid number.");
        }

        double discountAmount = getTotal() * (discountPercentage / 100.0);

        if (Double.isNaN(discountAmount) || Double.isInfinite(discountAmount)) {
            throw new ArithmeticException("Arithmetic failure during discount calculation.");
        }

        return discountAmount;
    }
}
