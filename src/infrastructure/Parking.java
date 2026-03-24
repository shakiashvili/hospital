package infrastructure;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Duration;

public class Parking {

    private int totalSpots;
    private BigDecimal pricePerHour;

    public Parking(int totalSpots, BigDecimal pricePerHour) {
        this.totalSpots = totalSpots;
        this.pricePerHour = pricePerHour;
    }
    public void processParking(LocalDateTime start, LocalDateTime end) {
        if(totalSpots <= 0) { //Assume that we have at least one parking space in else statement
            System.out.print("Parking is full cannot process");
        }else{
            Duration duration = Duration.between(start, end);
            long totalHours = duration.toHours();

            BigDecimal fee;
            if (totalHours <= 1) {
                fee = BigDecimal.ZERO;
            }else{
                fee = pricePerHour.multiply(BigDecimal.valueOf(totalHours));
                System.out.println("Finall Fee " + fee);
            }
            totalSpots--;
        }
        System.out.println("Remaining spots: " + totalSpots);
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public void setTotalSpots(int totalSpots) {
        this.totalSpots = totalSpots;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}