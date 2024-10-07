package exception;

public class GalleryNotFoundException extends Exception {
    private static final long serialVersionUID = 1L; // Serializable ID

    public GalleryNotFoundException(String message) {
        super(message);
    }
}
