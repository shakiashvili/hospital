package infrastructure;

public abstract class Vechile {
    protected String numberPlate;
    protected String vechileType;

    public Vechile(String numberPlate, String vechileType) {
        this.numberPlate = numberPlate;
        this.vechileType = vechileType;
    }

    public String getnumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getVechileType() {
        return vechileType;
    }

    public void setVechileType(String vechileType) {
        this.vechileType = vechileType;
    }

    public abstract void dispatch();
}