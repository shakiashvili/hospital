package enums;

public enum RoomType {
    STANDARD(150.0),
    ICU(500.0),
    VIP(1000.0);

    private final double dailyRate;

    RoomType(double dailyRate) {
        this.dailyRate = dailyRate;
    }
    public double getDailyRate () {
        return dailyRate;
    }

    public double calculateTotalCost(int days) {
        return dailyRate * days;
    }

}
