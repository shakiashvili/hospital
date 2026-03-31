package generics;

import java.time.LocalDateTime;
import person.Person;

public class DataLogger<T extends Person> {
    private T data;
    private LocalDateTime logTime;

    public DataLogger(T data) {
        this.data = data;
        this.logTime = logTime;
    }

    public void printLog() {
        System.out.println(logTime + " Logging: " +data);
    }
}