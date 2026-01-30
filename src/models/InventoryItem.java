package models;

// I used protected instead of private so the sub classes can access data
public abstract class InventoryItem { // Initializing 
    protected String id;
    protected String name;
    protected boolean isAvailable;

    public InventoryItem(String id, String name, boolean isAvailable) {
        this.id = id; // actual values are passed down to the variables
        this.name = name;
        this.isAvailable = isAvailable;
    }

// a "contract" that forces the extended classes to provide their type
    public abstract String getItemType();

   // used Encapsulation
    public String getId() { return id; } // calls the functions and returns the value
    public void setId(String id) { this.id = id; } // modifies the value
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override // overides the parents class and uses the ones in sub classes
    public String toString() { 
        return "ID: " + id + ", Name: " + name + ", Available: " + isAvailable;
    }
}