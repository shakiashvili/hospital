package enums;

public enum ShiftType{
    MORNING(6,14),
    DAY(14,22),
    NIGHT(22,6);

    private final int startHour;
    private final int endHour;

    ShiftType(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public boolean isOverNight() {
        return this == NIGHT;
    }
}