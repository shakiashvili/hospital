package person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Set;
import person.Patient;
import equipment.Equipment;
import enums.ShiftType;
import enums.StaffStatus;
import interfaces.ITreatable;
import exceptions.LowSalaryException;
import exceptions.InvalidAgeException;



public class Doctor extends Employee implements ITreatable {

    private String specialization;
    private List<Equipment> equipments;
    private Set<Patient> patients; // Assigned patients
    private ShiftType shiftType;
    private StaffStatus status;

    public Doctor(int age,
                  String name,
                  BigDecimal salary,
                  String specialization,
                  List<Equipment> equipments,
                  Set<Patient> patients,
                  ShiftType shiftType) {
        super(age, name, salary);
        this.specialization = specialization;
        this.equipments = equipments;
        this.patients = patients;
        this.shiftType = shiftType;
        this.status = StaffStatus.ON_DUTY;

        if (salary.compareTo(new BigDecimal("1000")) < 0) {
            throw new LowSalaryException("Salary is too low for a Doctor: " + salary);
        }

        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is not valid for a human");
        }
    }

    @Override
    public void treat(Patient patient) {
        System.out.println("Doctor treats " + name +"  " + patient.getName());
    }

    @Override
    public void work() {
        System.out.println("Doctor is working,healing patients ");
    }

    @Override
    public String toString() {
        return "Doctor{name='" + name + "', specialization='" + specialization + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(name, doctor.name) && Objects.equals(specialization, doctor.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specialization);
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    public StaffStatus getStatus() {
        return status;
    }

    public void setStatus(StaffStatus status) {
        this.status = status;
    }
}