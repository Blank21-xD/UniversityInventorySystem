import exceptions.*;
import managers.*;
import models.*;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        // Setting up the system
        InventoryManager manager = new InventoryManager();

        // Staff creation
        StaffMember staff1 = new StaffMember(101, "Dr. Alice", "Research");
        manager.addStaff(staff1);

        // Creating Equipments using polymorphism using InventoryItem so the data can be "generic" item when stored but remembers it is a equipment as well
        // Providing all 7 values to the variables
InventoryItem laptop = new Equipment("1", "Laptop", true, "L001", "Dell", 24, "Electronics");
InventoryItem tablet = new Equipment("2", "Tablet", true, "T002", "Apple", 12, "Electronics");
InventoryItem projector = new Equipment("3", "Projector", true, "P003", "Epson", 36, "Visual");

        manager.addItem(laptop);
        manager.addItem(tablet);
        manager.addItem(projector);

        // for error handling
        try {
            System.out.println("--- Processing Assignments ---");
            
            // Assign successfully
            manager.assignItemToStaff("L001", 101);
            System.out.println("Assigned L001 to Alice.");

            // TRY TO ASSIGN THE SAME ITEM AGAIN 
            System.out.println("Attempting to assign L001 again...");
            manager.assignItemToStaff("L001", 101);

        } catch (AssignmentLimitExceededException | EquipmentNotAvailableException e) {
            
            System.out.println("STOPPED: " + e.getMessage());
        }

        manager.printAllItemsReport();
        manager.printStaffAssignmentReport();
    }
}