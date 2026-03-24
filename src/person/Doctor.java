package person;

import java.util.Objects;
import java.math.BigDecimal;
import person.Patient;
import equipment.Equipment;
import interfaces.ITreatable;

public class Doctor extends Employee implements ITreatable {
    private String specialization;
    private Equipment[] equipments;
    private Patient[] patients; // Assigned patients

    public Doctor(int age, String name,BigDecimal salary, String specialization, Equipment[] equipments,
                  Patient[] patients) {
        super(age, name,new BigDecimal("10000"));
        this.specialization = specialization;
        this.equipments = equipments;
        this.patients = patients;
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

    public Equipment[] getEquipments() {
        return equipments;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setEquipments(Equipment[] equipments) {
        this.equipments = equipments;
    }
    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }
}