package enums;

public enum UrgencyLevel {
    LOW(1, "Green"), MEDIUM(2,"Yellow"), HIGH(3,"Red");

    private final int priority;
    private final String color;

    UrgencyLevel(int priority, String color) {
        this.priority = priority;
        this.color = color;
    }
    public boolean isCritical() {
        return priority >= 2;
    }

    public String getColor() {
        return color;
    }
}