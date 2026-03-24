package person;

import java.math.BigDecimal;
import java.util.Objects;
import interfaces.IWorkable;
import interfaces.IPayable;

public class Employee extends Person implements IWorkable,IPayable {
    protected BigDecimal salary;

    public Employee(int age, String name, BigDecimal salary) {
        super(age, name);
        this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println("Employee is working ");
    }

    @Override
    public BigDecimal calculateSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return "Employee{name='" + name + "', salary=" +salary + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && salary.compareTo(employee.salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}