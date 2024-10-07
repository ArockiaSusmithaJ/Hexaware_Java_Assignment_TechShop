package exception;

public class DatabaseConnectionException extends Exception {
    private static final long serialVersionUID = 1L; // Serializable ID

    public DatabaseConnectionException(String message) {
        super(message);
    }
}

