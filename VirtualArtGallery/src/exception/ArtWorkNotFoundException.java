package exception;

public class ArtWorkNotFoundException extends Exception {
    private static final long serialVersionUID = 1L; // Serializable ID

    public ArtWorkNotFoundException(String message) {
        super(message);
    }
}

