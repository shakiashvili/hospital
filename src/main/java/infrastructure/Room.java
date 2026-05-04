package infrastructure;

import java.util.List;
import person.Patient;
import equipment.Equipment;

public class Room {

    private String roomNumber;
    private Patient patient;
    private List<Equipment> tools;

    public Room(String roomNumber, Patient patient, List<Equipment> tools) {
        this.roomNumber = roomNumber;
        this.patient = patient;
        this.tools = tools;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public List<Equipment> getTools() {
        return tools;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setTools(List<Equipment> tools) {
        this.tools = tools;
    }
}