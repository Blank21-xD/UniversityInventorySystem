package exceptions;

// when equipement is not available
public class EquipmentNotAvailableException extends InventoryException {
    public EquipmentNotAvailableException(String message) {
        super(message);
    }
}