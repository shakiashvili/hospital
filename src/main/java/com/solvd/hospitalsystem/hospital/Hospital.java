package hospital;

import java.util.ArrayList;
import java.util.List;
import infrastructure.*;
import department.Department;


public class Hospital {

    private String name;
    private Building building;
    private List<Department> departments;
    private List<Ambulance> ambulances;
    private Parking parking;
    private WaitingRoom waitingRoom;

    private static  int hospitalCount;

    static  {
        hospitalCount = 0;
        System.out.println("Hospital class is loaded");
    }

    public Hospital(String name, Building building, List<Department> departments,
                    List<Ambulance> ambulances, Parking parking, WaitingRoom waitingRoom) {
        this.name = name;
        this.building = building;
        this.ambulances = ambulances;
        this.parking = parking;
        this.waitingRoom = waitingRoom;
        this.departments = departments;
        hospitalCount++; //Increase count after initializtion
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ambulance> getAmbulances() {
        return ambulances;
    }

    public void setAmbulances(List<Ambulance> ambulances) {
        this.ambulances = ambulances;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public static int getHospitalCount() {
        return hospitalCount;
    }

    public static void setHospitalCount(int hospitalCount) {
        Hospital.hospitalCount = hospitalCount;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public WaitingRoom getWaitingRoom() {
        return waitingRoom;
    }

    public void setWaitingRoom(WaitingRoom waitingRoom) {
        this.waitingRoom = waitingRoom;
    }
}