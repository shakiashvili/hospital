package streams;

import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.math.BigDecimal;

import person.Doctor;
import person.Patient;


public class StreamsAPI {

    public void printAdultPatient(List<Patient> patients) {
        patients.stream()
                .filter(p -> p.getAge() >= 18)
                .forEach(p -> System.out.println("Adult Patients " + p.getName()));
    }

    public List<String> getDoctorsNames(List<Doctor> doctors) {
        return doctors.stream()
                .map(Doctor::getName)
                .collect(Collectors.toList());
    }

    public boolean findPatient(List<Patient> patients, String patientName) {
        return patients.stream()
                .anyMatch(patient -> patient.getName().equals(patientName));

    }

    public long countHighEarners(List<Doctor> doctors, BigDecimal salary) {
        return doctors.stream()
                .filter(d -> d.calculateSalary().compareTo(salary) > 0)
                .count();
    }

    public Optional<Doctor> findDoctor(List<Doctor> doctors,String name) {
        return doctors.stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Patient> sortPatientsByAge(List<Patient> patients) {
        return patients.stream()
                .sorted(Comparator.comparingInt(Patient::getAge))
                .collect(Collectors.toList());
    }








}