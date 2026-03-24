package infrastructure;

public class Building extends Infrastructure{

    private int floorCount;
    private Room[] rooms;

    public Building(String location, int floorCount, Room[] rooms) {
        super(location);
        this.floorCount = floorCount;
        this.rooms = rooms;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}