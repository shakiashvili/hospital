package person;

import java.util.Objects;

public abstract class Person {
    protected String name;
    protected int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}