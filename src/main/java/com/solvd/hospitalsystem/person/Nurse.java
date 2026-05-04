package person;

import java.math.BigDecimal;
import java.util.Set;
import person.Patient;
import interfaces.IAssistable;
import exceptions.LowSalaryException;
import exceptions.InvalidAgeException;
import enums.ShiftType;

public class Nurse extends Employee implements IAssistable {

    private ShiftType shiftType;
    private Set<Patient> patients;

    public Nurse(int age, String name, BigDecimal salary, ShiftType shiftType, Set<Patient> patients) {
        super(age, name, new BigDecimal("5000"));
        this.shiftType = shiftType;
        this.patients = patients;

        if ( salary.compareTo(new BigDecimal("1000")) < 0) {
            throw new LowSalaryException("Salary is to low");
        }

        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age " + age+  " is not valid for a human");
        }

    }

    @Override
    public void work() {
        System.out.println("Nurse is working ");
    }

    @Override
    public void assist(Patient patient) {
        System.out.println("Nurse " +name+ " assist Patients "  + patient.getName());
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shift) {
        this.shiftType = shift;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}