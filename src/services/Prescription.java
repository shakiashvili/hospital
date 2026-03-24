package services;
import java.math.BigDecimal;

public class Prescription extends MedicalDocument{
    private String medicationName;
    private BigDecimal cost;

    public Prescription(String documentID, String medicationName, BigDecimal cost) {
        super(documentID);
        this.medicationName = medicationName;
        this.cost = cost;
    }

    @Override
    public void archive() {
        System.out.print("Archived");
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}