package Characters;

public class InvalidItemException extends Throwable {
    public InvalidItemException(String errorMessage) {
        super(errorMessage);
    }
}
