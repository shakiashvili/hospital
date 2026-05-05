package infrastructure;
import exceptions.VechileNotAvailableException;

public class Ambulance extends Vechile {

    private boolean isAvailable;

    public Ambulance(String numberPlate, boolean isAvailable) {
        super(numberPlate, "Emergency");
        this.isAvailable = isAvailable;
    }

    public void dispatch() {
        if(!isAvailable()) {
            throw new VechileNotAvailableException("Ambulance " + numberPlate + " is already taken!");
        }
        this.isAvailable = false;

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
