package models;

public class StaffMember {
  // only this class can modify the values of the below variables
    private int staffId;
    private String name;
    private String email;
    
  
    private Equipment[] assignedEquipment;// [] is an array and holds the list of Equipment objects
    private int equipmentCount; // Tells how many slots are actually used

    public StaffMember(int staffId, String name, String email) {
        // for assigning the values to the variables
        this.staffId = staffId;
        this.name = name;
        this.email = email;

        // Initializing the array with a fixed size of 5
        this.assignedEquipment = new Equipment[5];
        this.equipmentCount = 0;
    }

    // Used to get the information
    public int getStaffId() { return staffId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Equipment[] getAssignedEquipment() { return assignedEquipment; }
    public int getEquipmentCount() { return equipmentCount; }

// adding the equipments in the array
    public void addEquipment(Equipment item) {
    // checks for the space in the array
    if (equipmentCount < 5) {
        // Place the item in the next slot
        assignedEquipment[equipmentCount] = item;
        
        // Increase the count so that new objects can be added to new slot
        equipmentCount++;
        
        // Mark the item as unavailable so no one else can take it
        item.setAvailable(false);
        
        System.out.println("Success: " + item.getName() + " assigned to " + this.name);
    } 
    else
       {
        // When the limit is reached it will print the below statement
        System.out.println("Failure: Cannot assign more than 5 items to " + this.name);
    }
  }
// for removing/ "overriding" the items in the array incase of any problem
  public void removeEquipment(String id) {
    for (int i = 0; i < equipmentCount; i++) {

        // Look for the item with the matching ID
        if (assignedEquipment[i].getId().equals(id)) {

            // Mark it as available again for others to use
            assignedEquipment[i].setAvailable(true);
            
            // Shift all items after this one to the left to close the gap
            for (int j = i; j < equipmentCount - 1; j++) {
                assignedEquipment[j] = assignedEquipment[j + 1];
            }
            
            // Clear the last slot and decrease the count
            assignedEquipment[equipmentCount - 1] = null;
            equipmentCount--;
            System.out.println("Item " + id + " has been returned.");
            return;
        }
    }
    System.out.println("Item not found in this staff member's list.");
}
}