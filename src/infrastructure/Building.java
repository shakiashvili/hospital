package infrastructure;

import java.util.List;


public class Building extends Infrastructure{

    private int floorCount;
    private List<Room> rooms;

    public Building(String location, int floorCount, List<Room> rooms) {
        super(location);
        this.floorCount = floorCount;
        this.rooms = rooms;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}