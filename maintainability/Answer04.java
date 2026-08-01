package maintainability;

/**
 * Answer 04: Reducing Cyclomatic Complexity using Guard Clauses
 * 
 * Key Improvements:
 * 1. Replaced deeply nested `if-else` branches with Guard Clauses (early returns).
 * 2. Reduced cognitive complexity from nesting level 3 to flat sequential execution.
 * 3. Clear fail-fast checks for system status, person null-checks, name validation, and PIN validation.
 */
public class Answer04 {

    public static class Person {
        private final String name;
        private final int pin;

        public Person(String name, int pin) {
            this.name = name;
            this.pin = pin;
        }

        public String getName() {
            return name;
        }

        public int getPin() {
            return pin;
        }
    }

    public String validatePerson(boolean isSystemUp, Person person, int pin) {
        // Guard 1: System availability check
        if (!isSystemUp) {
            return "System is Down";
        }

        // Guard 2: Person object and name validity check
        if (person == null || person.getName() == null || person.getName().trim().isEmpty()) {
            return "Invalid name";
        }

        // Guard 3: PIN validation check
        if (person.getPin() != pin) {
            return "Invalid Pin";
        }

        // Happy path
        return "Person validation successful";
    }
}
