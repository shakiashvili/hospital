package person;

import java.util.Objects;
import services.MedicalRecord;
import services.Prescription;


public class Patient extends Person {

    private MedicalRecord record;
    private Prescription prescription;

    public Patient(int age, String name, MedicalRecord record, Prescription prescription) {
        super(age, name);
        this.record = record;
        this.prescription = prescription;
    }

    public MedicalRecord getRecord() {
        return record;
    }

    public void setRecord(MedicalRecord record) {
        this.record = record;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public void work() {
        System.out.println("Patient " + name + " is currently under medication ");
    }

    @Override
    public String toString() {
        return "Patient{name'" + name +"', age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Patient)) return false;
       Patient patient = (Patient) o;
       return age == patient.age && Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}