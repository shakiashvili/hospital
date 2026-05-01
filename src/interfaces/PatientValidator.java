package interfaces;

import person.Patient;

@FunctionalInterface
public interface PatientValidator {
    boolean validate(Patient p);
}