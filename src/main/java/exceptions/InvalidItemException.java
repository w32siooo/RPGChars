package exceptions;

public class InvalidItemException extends Exception {
    public InvalidItemException(String errorMessage) {
        super(errorMessage);
    }
}
