package models;

// the parent class InventoryItem is extended to the Furniture
public class Furniture extends InventoryItem {
    /*additional variable for the Furniture class
    used private so that only this class can change the value*/
    private String roomNumber;
    private String material;

    
    public Furniture(String id, String name, boolean isAvailable, String roomNumber, String material) {
    
        super(id, name, isAvailable);
        this.roomNumber = roomNumber;
        this.material = material;
    }

    // calls getItemTupe in Inventory Items and returns "Furniture"
    @Override
    public String getItemType() {
        return "Furniture";
    }

    // Provides the output overriding the mainclass'
    @Override
    public String toString() {
        return super.toString() + ", Room: " + roomNumber + ", Material: " + material;
    }

    // Used to retrieve and update the values and uses encapsulation
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}