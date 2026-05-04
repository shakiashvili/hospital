package services;

import person.Doctor;
import person.Patient;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Appointment {

    public BigDecimal bookAppointment(Patient patient, Doctor doctor, LocalDateTime time) {

        System.out.println("Booking appointment...");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Time: " + time);

        BigDecimal price = new BigDecimal("75.00");

        System.out.println("Appointment cost: " + price);

        return price;
    }
}