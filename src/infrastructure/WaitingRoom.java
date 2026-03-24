package infrastructure;

import person.Receptionist;

public class WaitingRoom {
    private int capacity;
    private Receptionist receptionist;

    public WaitingRoom(int capacity, Receptionist receptionist) {
        this.capacity = capacity;
        this.receptionist = receptionist;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }
}
