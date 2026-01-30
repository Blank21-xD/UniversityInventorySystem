package models;

public class LabEquipment extends InventoryItem {
  /*   used private so that only this class can modify the value 
        added new variables for this class*/
    private String labName;
    private String lastCalibrationDate;

    // providing the values to the variables
    public LabEquipment(String id, String name, boolean isAvailable, String labName, String lastCalibrationDate) {
        super(id, name, isAvailable);
        this.labName = labName;
        this.lastCalibrationDate = lastCalibrationDate;
    }

    // calls the parent's class and tells the type of equipment
    @Override
    public String getItemType() {
        return "Lab Equipment";
    }

    // For providing the output
    @Override
    public String toString() {
        return super.toString() + ", Lab: " + labName + ", Last Calibration: " + lastCalibrationDate;
    }

    // Change and retrieve the values of the variables
    public String getLabName() { return labName; }
    public void setLabName(String labName) { this.labName = labName; }
    public String getLastCalibrationDate() { return lastCalibrationDate; }
    public void setLastCalibrationDate(String date) { this.lastCalibrationDate = date; }
}