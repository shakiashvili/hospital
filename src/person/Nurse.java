package person;

import java.math.BigDecimal;
import person.Patient;
import interfaces.IAssistable;


public class Nurse extends Employee implements IAssistable {
    private String shift;
    private Patient[] patients;

    public Nurse(int age, String name, BigDecimal salary, String shift, Patient[] patients) {
        super(age, name, new BigDecimal("5000"));
        this.shift = shift;
        this.patients = patients;
    }

    @Override
    public void work() {
        System.out.println("Nurse is working ");
    }

    @Override
    public void assist(Patient patient) {
        System.out.println("Nurse " +name+ " assist Patients "  + patient.getName());
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }
}