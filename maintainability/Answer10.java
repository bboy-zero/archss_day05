package maintainability;

/**
 * Answer 10: Demonstrating Interface Segregation Principle (ISP)
 * 
 * Key Improvements:
 * 1. Fixed ISP Violation: Split bloated `Document` interface into fine-grained role interfaces.
 * 2. Created focused interfaces: `Openable`, `Saveable`, `Printable`, `Emailable`.
 * 3. Classes only implement interfaces corresponding to actions they support (no empty or throws-unsupported methods).
 */
public class Answer10 {

    public interface Openable {
        void open();
    }

    public interface Saveable {
        void save();
    }

    public interface Printable {
        void print();
    }

    public interface Emailable {
        void sendViaEmail();
    }

    // PDF supports opening, saving, and printing
    public static class PDFDocument implements Openable, Saveable, Printable {
        @Override
        public void open() {
            System.out.println("Opening PDF document...");
        }

        @Override
        public void save() {
            System.out.println("Saving PDF document...");
        }

        @Override
        public void print() {
            System.out.println("Printing PDF document...");
        }
    }

    // Word Document supports opening, saving, and sending via email
    public static class WordDocument implements Openable, Saveable, Emailable {
        @Override
        public void open() {
            System.out.println("Opening Word document...");
        }

        @Override
        public void save() {
            System.out.println("Saving Word document...");
        }

        @Override
        public void sendViaEmail() {
            System.out.println("Sending Word document via email...");
        }
    }
}
