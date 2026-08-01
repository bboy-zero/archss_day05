package maintainability;

/**
 * Answer 09: Demonstrating Liskov Substitution Principle (LSP)
 * 
 * Key Improvements:
 * 1. Fixed LSP Violation: Original code placed `vote()` on `SingaporeCitizen`, forcing `NonVoter` to inherit a capability it cannot perform.
 * 2. Extracted `Voter` capability into a dedicated interface.
 * 3. Base class `SingaporeCitizen` contains common citizen attributes/behaviors.
 * 4. Only classes that actually support voting implement `Voter`, ensuring subtype substitutability.
 */
public class Answer09 {

    // Interface for objects capable of voting
    public interface Voter {
        void vote();
    }

    // Base class representing any citizen
    public static class SingaporeCitizen {
        private final String nric;
        private final String name;

        public SingaporeCitizen(String nric, String name) {
            this.nric = nric;
            this.name = name;
        }

        public String getNric() { return nric; }
        public String getName() { return name; }
    }

    // Registered Voter inherits citizen traits AND implements voting behavior
    public static class RegisteredVoter extends SingaporeCitizen implements Voter {
        public RegisteredVoter(String nric, String name) {
            super(nric, name);
        }

        @Override
        public void vote() {
            System.out.println(getName() + " casted a vote successfully.");
        }
    }

    // NonVoter inherits citizen traits but does NOT implement Voter
    public static class NonVoter extends SingaporeCitizen {
        public NonVoter(String nric, String name) {
            super(nric, name);
        }
    }

    // Service method that safely operates on any Voter (substitutability guaranteed)
    public static void castVote(Voter voter) {
        voter.vote();
    }

    public static void main(String[] args) {
        RegisteredVoter validVoter = new RegisteredVoter("S1234567A", "Alice");
        castVote(validVoter); // Compiles and works cleanly

        NonVoter minorCitizen = new NonVoter("T9876543B", "Bob");
        // castVote(minorCitizen); // Compile-time safety error! Bob is not a Voter.
    }
}
