package enums;

public enum HospitalType {
    PUBLIC(0.0),
    PRIVATE(0.18);

    private final double taxRate;

    HospitalType(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculateTaxes(double baseAmount) {
        return baseAmount * taxRate;
    }

}