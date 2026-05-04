package exceptions;

public class LowSalaryException extends RuntimeException {

    public LowSalaryException (String message) {
        super(message);
    }
}
