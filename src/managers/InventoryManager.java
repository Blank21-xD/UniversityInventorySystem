// brain
package managers;

import exceptions.*;
import java.util.ArrayList;
import models.*;

// used ArrayList since they are dynamic and can be used to add more data in the database
public class InventoryManager {
    private ArrayList<InventoryItem> allItems;
    private ArrayList<StaffMember> allStaff;

    public InventoryManager() {
        this.allItems = new ArrayList<>();
        this.allStaff = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        allItems.add(item);
    }

    public void addStaff(StaffMember staff) {
        allStaff.add(staff);
    }

    // connects a Staff Member to a item after fulfilling certain conditions
    public void assignItemToStaff(String assetId, int staffId) 
           throws AssignmentLimitExceededException, EquipmentNotAvailableException {
        
        InventoryItem item = findItemById(assetId);
        StaffMember staff = findStaffById(staffId);

        if (item == null || staff == null) {
            System.out.println("Error: Item or Staff not found.");
            return;
        }

        if (!item.isAvailable()) {
            throw new EquipmentNotAvailableException("The item " + assetId + " is currently unavailable.");
        }

        if (staff.getEquipmentCount() >= 5) {
            throw new AssignmentLimitExceededException(staff.getName() + " cannot take more than 5 items.");
        }

        if (item instanceof Equipment){
            staff.addEquipment((Equipment) item);
        }
    }

    // find specific objects
    // used loop to ensure every data is checked
    private InventoryItem findItemById(String id) {
        for (InventoryItem item : allItems) {
            if (item instanceof Equipment){
                
                if (((Equipment) item).getAssetId().equals(id)){
                    return item;
                }
            }
        }
        return null;
    }

    // find specific staff member
    private StaffMember findStaffById(int id) {
        for (StaffMember s : allStaff) {
            if (s.getStaffId() == id) return s;
        }
        return null;
    }

    // Showing the items that the university owns
    public void printAllItemsReport() {
        System.out.println("\n--- UNIVERSITY INVENTORY REPORT ---");
        // below code helps to make the output lined up perfectly
        System.out.printf("%-10s %-20s %-15s %-10s\n", "ID", "Name", "Category", "Status");
        System.out.println("------------------------------------------------------------");

        for (InventoryItem item : allItems) {
            String status = item.isAvailable() ? "Available" : "Assigned";
            
           
            String displayId = "N/A";
            String category = "General";

            if (item instanceof Equipment) {
                Equipment e = (Equipment) item;
                displayId = e.getAssetId();
                category = e.getCategory();
            }

            System.out.printf("%-10s %-20s %-15s %-10s\n", 
                displayId, item.getName(), category, status);
        }
    }

    // Shows the staff member and what they borrowed
    public void printStaffAssignmentReport() {
        System.out.println("\n--- STAFF ASSIGNMENT SUMMARY ---");
        for (StaffMember staff : allStaff) {
            System.out.println("Staff: " + staff.getName() + " (ID: " + staff.getStaffId() + ")");
            System.out.println("Items Borrowed (" + staff.getEquipmentCount() + "/5):");
            
            if (staff.getEquipmentCount() == 0) {
                System.out.println("  - No items assigned.");
            } else {
                for (int i = 0; i < staff.getEquipmentCount(); i++) {
                    Equipment item = staff.getAssignedEquipment()[i];
                    System.out.println("  - [" + item.getAssetId() + "] " + item.getName());
                }
            }
            System.out.println("------------------------------------");
        }
    }
}