package maintainability;

import java.time.LocalDateTime;

/**
 * Answer 07: Applying SRP to Re-organize Class Responsibilities
 * 
 * Key Improvements:
 * 1. Separated data representation (`Order`) from business operations (notification, discount calculation).
 * 2. Created cohesive, single-responsibility classes:
 *    - `Order`: Pure domain model / data holder.
 *    - `OrderNotificationService`: Handles sending notifications for orders.
 *    - `OrderDiscountCalculator`: Handles discount calculations.
 */
public class Answer07 {

    // 1. Order Domain Entity (Only holds order state)
    public static class Order {
        private final String id;
        private final LocalDateTime orderDate;
        private final double totalAmount;

        public Order(String id, LocalDateTime orderDate, double totalAmount) {
            this.id = id;
            this.orderDate = orderDate;
            this.totalAmount = totalAmount;
        }

        public String getId() {
            return id;
        }

        public LocalDateTime getOrderDate() {
            return orderDate;
        }

        public double getTotalAmount() {
            return totalAmount;
        }
    }

    // 2. Notification Responsibility
    public static class OrderNotificationService {
        public void sendOrderNotification(Order order) {
            System.out.println("Notification sent for Order ID: " + order.getId());
        }
    }

    // 3. Discount Calculation Responsibility
    public static class OrderDiscountCalculator {
        public double calculateDiscount(Order order, double discountRatePercentage) {
            return order.getTotalAmount() * (discountRatePercentage / 100.0);
        }
    }
}
