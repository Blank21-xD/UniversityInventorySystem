package models;

// used private to ensure that only this class can change the values directly
public class Equipment extends InventoryItem {
    private String assetId;
    private String brand;
    private int warrantyMonths;
    private String category;

    
    public Equipment(String id, String name, boolean isAvailable, String assetId, String brand, int warrantyMonths, String category) {
        super(id, name, isAvailable); // sends the information to the parent class
        this.assetId = assetId; // assigns the values to the vairables
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
        this.category = category;
    }


    @Override
    public String getItemType() {
        return "Equipment";
    }

  
    @Override // if two items have same assestId, it will be treated as same equipment
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipment other = (Equipment) obj;
        return this.assetId != null && this.assetId.equals(other.assetId);
    }

    
    @Override // this provides the output when called and overrides the parents class's output
    public String toString() {
        return super.toString() + ", Asset ID: " + assetId + ", Brand: " + brand + 
               ", Warranty: " + warrantyMonths + " months, Category: " + category;
    }

    // the below codes help to return the value and update the value
    public String getAssetId() { return assetId; }
    public void setAssetId(String assetId) { this.assetId = assetId; }
    public String getBrand() { return brand; }
    public int getWarrantyMonths() { return warrantyMonths; }
    public String getCategory() { return category; }
}