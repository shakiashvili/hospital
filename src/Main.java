import java.time.LocalDateTime;
import java.math.BigDecimal;
import equipment.*;
import exceptions.*;
import infrastructure.*;
import person.*;
import services.*;
import interfaces.*;
import department.Department;
import hospital.*;

public class Main {

    public static void main(String[] args) {

        try (MedicalScanner scanner = new MedicalScanner()) {
            scanner.scan("Giorgi");
        } catch (Exception e) {
            System.out.println("Scanner System Error: " + e.getMessage());
        }

        try {

            // 1. Bottom Level (Equipment and Records)
            Equipment scissors = new Equipment("Scissors", true);
            Equipment[] doctorEquipments = {scissors};

            MedicalRecord record = new MedicalRecord("Rec-01", "Checkup", LocalDateTime.now());
            Prescription prescription = new Prescription("Rx-01", "Aspirin", new BigDecimal("15.50"));

            // 2. People Level
            Patient patient = new Patient(22, "Giorgi", record, prescription);
            Patient[] patients = {patient};

            Doctor doctor = new Doctor(40, "Lasha", new BigDecimal("9500"), "Cardiology", doctorEquipments, patients);
            Doctor[] doctors = {doctor};

            Nurse nurse = new Nurse(25, "Ana", new BigDecimal("3000"), "Night Shift", patients);
            Nurse[] nurses = {nurse};

            Receptionist receptionist = new Receptionist(30, "Nina", new BigDecimal("500"), "Night Shift");

            // 3. Infrastructure Level
            WaitingRoom waitingRoom = new WaitingRoom(20, receptionist);

            Room room = new Room("15", patient, doctorEquipments);
            Room[] rooms = {room};

            Department cardiology = new Department("Cardiology", doctors, nurses, rooms);
            Department[] departments = {cardiology};

            Building building = new Building("University Street", 5, rooms);

            Ambulance ambulance = new Ambulance("TB-344-TB", true);
            Ambulance[] ambulances = {ambulance};

            Parking parking = new Parking(50, new BigDecimal("5.90"));

            // 4. Root Object
            Hospital hospital = new Hospital("Med Hospital", building, departments, ambulances, parking, waitingRoom);

            System.out.println("Welcome to " + hospital.getName());

            // Business methods
            LocalDateTime arrival = LocalDateTime.now().minusHours(4);
            LocalDateTime departure = LocalDateTime.now();
            parking.processParking(arrival, departure);

            Appointment appointment = new Appointment();
            appointment.bookAppointment(patient, doctor, LocalDateTime.now());

            // Second Homework
            HospitalService service = new HospitalService();
            // Doctor
            Person currentStaff;
            currentStaff = doctor;
            service.processWorkingActivity(currentStaff);
            // Interface polymorphism for Doctor
            service.processTreatment(doctor, patient);

            // Nurse
            currentStaff = nurse;
            service.processWorkingActivity(currentStaff);
            // Interface polymorphism for Nurse
            service.processAssistance(nurse, patient);
            // Receptionist
            currentStaff = receptionist;
            service.processWorkingActivity(currentStaff);
            // Interface polymorphism for Receptionist
            service.processManagment(receptionist);

            Doctor duplicateDoctor = new Doctor(50, "Lasha", new BigDecimal("800"), "Cardiology", doctorEquipments, patients);


            System.out.println(duplicateDoctor.toString());
            System.out.println("Is doctor equal to doctorDuplicate" + doctor.equals(duplicateDoctor));
            System.out.println("Hash code " + duplicateDoctor.hashCode());

            ambulance.dispatch();


        } catch (InvalidDepartmentException e) {
            System.out.println(e.getMessage());
        } catch (LowSalaryException | InvalidAgeException | VechileNotAvailableException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        // Call HospitalInfo class(Final classs with final method and variable)
        HospitalInfo.printInfo();
        System.out.println(HospitalInfo.NAME);

    }
}