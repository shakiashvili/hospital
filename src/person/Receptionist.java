package person;

import java.math.BigDecimal;
import interfaces.IManagable;

public class Receptionist extends Employee implements IManagable {

    private String shift;

    public Receptionist(int age,String name,BigDecimal salary, String shift) {
        super(age, name, new BigDecimal("1000"));
        this.shift = shift;
    }

    @Override
    public void work() {
        System.out.println("I am Recieving the patients");
    }

    @Override
    public void manage() {
        System.out.println("Receptionist " + name  + " Manages the work");
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}