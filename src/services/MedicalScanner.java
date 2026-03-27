package services;

public class MedicalScanner implements AutoCloseable {

    public MedicalScanner() {
        System.out.println("Scanner Online");
    }

    public void scan(String patient) {
        System.out.println("Scanning: " + patient);
    }

    @Override
    public void close() {
        System.out.println("Scanner Powering down");
    }

}