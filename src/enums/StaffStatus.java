package enums;

public enum StaffStatus {
    ON_DUTY(true, "Currently working"),
    OFF_DUTY(false, "Resting at home"),
    IN_SURGERY(false,"Busy in the operating room"),
    ON_LEAVE(false, "On scheduled vacation");

    private final boolean available;
    private final String description;

    StaffStatus(boolean available, String description) {
        this.available = available;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }
}
