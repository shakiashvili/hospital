package records;

import java.time.LocalDateTime;

public class MedicalReport {
    private final String id;
    private final String diagnostic;
    private final LocalDateTime date;

    public MedicalReport(String id, String diagnostic, LocalDateTime date) {
        this.id = id;
        this.diagnostic = diagnostic;
        this.date = date;
    }

    public String id() {
        return id;
    }

    public String diagnostic() {
        return diagnostic;
    }

    public LocalDateTime date() {
        return date;
    }
}