package exceptions;

public class InvalidMedicalRecordException extends RuntimeException {

    public InvalidMedicalRecordException(String message) {
        super(message);
    }
}