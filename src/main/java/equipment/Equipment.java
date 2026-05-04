package equipment;

public class Equipment {

    private String eqipmentName;
    private boolean isSterile;

    public Equipment(String eqipmentName, boolean isSterile) {
        this.eqipmentName = eqipmentName;
        this.isSterile = isSterile;
    }

    public String getEqipmentName() {
        return eqipmentName;
    }

    public void setEqipmentName(String name) {
        this.eqipmentName = name;
    }

    public boolean isSterile() {
        return isSterile;
    }

    public void setSterile(boolean sterile) {
        this.isSterile = sterile;
    }
}