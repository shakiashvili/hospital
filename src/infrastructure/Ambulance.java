package infrastructure;

public class Ambulance extends Vechile {

    private boolean isAvailable;

    public Ambulance(String numberPlate, boolean isAvailable) {
        super(numberPlate, "Emergency");
        this.isAvailable = isAvailable;
    }

    public void dispatch() {
        if(isAvailable) {
            System.out.println("Ambulance " + numberPlate + " is going to an emergency");
            this.isAvailable = false;
        } else {
            System.out.println("Ambulance car is taken");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
