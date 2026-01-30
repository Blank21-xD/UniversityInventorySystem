package exceptions;

// when the values in the array exceeds 5
// Inherits from our base InventoryException
public class AssignmentLimitExceededException extends InventoryException {
    public AssignmentLimitExceededException(String message) {
        super(message);
    }
}