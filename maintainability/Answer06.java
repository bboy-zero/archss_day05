package maintainability;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Answer 06: Catching Multiple Exceptions in Java
 * 
 * Key Improvements:
 * 1. Used Java 7+ Multi-catch syntax: `catch (IOException | SQLException e)`.
 * 2. Avoided redundant subclass catching (`FileNotFoundException` is a subclass of `IOException`).
 * 3. Avoided swallowed/empty catch blocks by logging the error properly.
 */
public class Answer06 {

    private static final Logger LOGGER = Logger.getLogger(Answer06.class.getName());

    public void processFile() {
        try {
            readFile();
            executeQuery();
        } catch (IOException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while processing file or database", e);
        }
    }

    private void executeQuery() throws SQLException {
        // Implementation for DB query execution
    }

    private void readFile() throws IOException {
        // Implementation for reading file
    }
}
