package person;

import java.math.BigDecimal;

public class Receptionist extends Employee {
    private String shift;

    public Receptionist(int age,String name,BigDecimal salary, String shift) {
        super(age, name, new BigDecimal("1000"));
        this.shift = shift;
    }

    @Override
    public void work() {
        System.out.print("I am Recieving the patients");
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}