package person;

import java.math.BigDecimal;
import enums.ShiftType;
import interfaces.IManagable;

public class Receptionist extends Employee implements IManagable {

    private ShiftType shiftType;

    public Receptionist(int age,String name,BigDecimal salary, ShiftType shift) {
        super(age, name, new BigDecimal("1000"));
        this.shiftType = shiftType;
    }

    @Override
    public void work() {
        System.out.println("I am Recieving the patients");
    }

    @Override
    public void manage() {
        System.out.println("Receptionist " + name  + " Manages the work");
    }

    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShift(ShiftType shift) {
        this.shiftType = shift;
    }
}