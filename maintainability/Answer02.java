package maintainability;

/**
 * Answer 02: Single Responsibility Principle (SRP)
 * 
 * Key Improvements:
 * 1. Separated concerns: Each notification channel (Email, SMS) has its own dedicated class implementing `NotificationSender`.
 * 2. Eliminated boolean flag parameter (`isEmail`), which is a code smell violating SRP and Open/Closed Principle.
 * 3. Future notification channels can be added by implementing `NotificationSender` without altering existing code.
 */
public class Answer02 {

    // Common abstraction for sending notifications
    public interface NotificationSender {
        void send(String content);
    }

    // Email-specific notification sender
    public static class EmailNotificationSender implements NotificationSender {
        @Override
        public void send(String content) {
            System.out.println("Sending Email with content: " + content);
        }
    }

    // SMS-specific notification sender
    public static class SmsNotificationSender implements NotificationSender {
        @Override
        public void send(String content) {
            System.out.println("Sending SMS with content: " + content);
        }
    }

    // Service delegating to the appropriate sender
    public static class NotificationService {
        private final NotificationSender notificationSender;

        public NotificationService(NotificationSender notificationSender) {
            this.notificationSender = notificationSender;
        }

        public void notifyUser(String content) {
            notificationSender.send(content);
        }
    }

    public static void main(String[] args) {
        NotificationService emailService = new NotificationService(new EmailNotificationSender());
        emailService.notifyUser("Hello via Email!");

        NotificationService smsService = new NotificationService(new SmsNotificationSender());
        smsService.notifyUser("Hello via SMS!");
    }
}
