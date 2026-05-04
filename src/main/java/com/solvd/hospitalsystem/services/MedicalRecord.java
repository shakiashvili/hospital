package services;
import java.time.LocalDateTime;

public class MedicalRecord extends MedicalDocument{
    private String diagnosis;
    private LocalDateTime visitTime;
    private boolean hasMedicalRecord;

    public MedicalRecord(String documentID, String diagnosis, LocalDateTime visitTime) {
        super(documentID);
        this.diagnosis = diagnosis;
        this.visitTime = visitTime;
        this.hasMedicalRecord = false;
    }

    @Override
    public void archive() {
        System.out.print("Archived");
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public boolean hasMedicalRecord() {
        return hasMedicalRecord;
    }

    public void setHasMedicalRecord(boolean hasMedicalRecord) {
        this.hasMedicalRecord = hasMedicalRecord;
    }
}
