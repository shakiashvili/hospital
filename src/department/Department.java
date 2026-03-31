package department;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import exceptions.InvalidDepartmentException;
import infrastructure.Room;
import person.Doctor;
import person.Nurse;
import person.Patient;  // For mapping purposes e.g. key:value pairs;


public class Department {

    private String name;
    private List<Doctor> doctors;
    private List<Nurse> nurses;
    private Map<Patient, Room> patientRooms;

    public Department(String name, List<Doctor> doctors, List<Nurse> nurses,
                      Map<Patient, Room> patientRooms) throws InvalidDepartmentException {
        this.name = name;
        this.doctors = doctors;
        this.nurses = nurses;
        this.patientRooms = patientRooms;

        if (name == null) {
            throw new InvalidDepartmentException("Department could not be null");
        }
    }

    public String getName() {
        return name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public Map<Patient, Room> getPatientRooms() {
        return patientRooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public void setPatientRooms(Map<Patient, Room> patientRooms) {
        this.patientRooms = patientRooms;
    }
}