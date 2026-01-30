package exceptions;

// Base for error Handling
// used built-in Exception to handle the errors
public class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}