import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.*;


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
import generics.*;

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
            List<Equipment> doctorEquipments = new ArrayList<>();
            doctorEquipments.add(scissors);

            MedicalRecord record = new MedicalRecord("Rec-01", "Checkup", LocalDateTime.now());
            Prescription prescription = new Prescription("Rx-01", "Aspirin", new BigDecimal("15.50"));

            // 2. People Level
            Patient patient = new Patient(22, "Giorgi", record, prescription);
            Set<Patient> patients = new HashSet<>();
            patients.add(patient);

            Doctor doctor = new Doctor(40, "Lasha", new BigDecimal("9500"), "Cardiology", doctorEquipments, patients);
            List<Doctor> doctors = new ArrayList<>();
            doctors.add(doctor);

            Nurse nurse = new Nurse(25, "Ana", new BigDecimal("3000"), "Night Shift", patients);
            List<Nurse> nurses = new ArrayList<>();
            nurses.add(nurse);

            Receptionist receptionist = new Receptionist(30, "Nina", new BigDecimal("500"), "Night Shift");

            // 3. Infrastructure Level
            WaitingRoom waitingRoom = new WaitingRoom(20, receptionist);

            Room room15 = new Room("15", patient, doctorEquipments);
            List<Room> roomList = new ArrayList<>();
            roomList.add(room15);

            Map<Patient, Room> patientAssignmentMap = new HashMap<>();
            patientAssignmentMap.put(patient, room15);

            Department cardiology = new Department("Cardiology", doctors, nurses, patientAssignmentMap);

            List<Department> departments = new ArrayList<>();
            departments.add(cardiology);

            Building building = new Building("University Street", 5, roomList);

            Ambulance ambulance = new Ambulance("TB-344-TB", true);
            List<Ambulance> ambulances = new ArrayList<>();
            ambulances.add(ambulance);

            Parking parking = new Parking(50, new BigDecimal("5.90"));

            // 4. Root Object
            Hospital hospital = new Hospital("Med Hospital", building, departments, ambulances, parking, waitingRoom);

            System.out.println("Welcome to " + hospital.getName());

            // Collections

            if(!doctors.isEmpty()) {
                System.out.println("First Doctor in the list" + doctors.get(0).getName());
            }

            // Map
            for(Map.Entry<Patient, Room> entry: patientAssignmentMap.entrySet()) {
                System.out.println("Patient " + entry.getKey().getName()
                        + " is assigned to Room " + entry.getValue().getRoomNumber());
            }

            // Get first element of a set
            Patient firstPatient = patients.iterator().next();
            System.out.println(firstPatient.getName());

            // Use generic classes

            Inventory<Equipment> inv = new Inventory<>();
            inv.add(scissors);

            DataLogger<Patient> patientLog = new DataLogger<>(patient);
            patientLog.printLog();


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

//            Doctor duplicateDoctor = new Doctor(50, "Lasha", new BigDecimal("800"), "Cardiology", doctorEquipments, patients);

//
//            System.out.println(duplicateDoctor.toString());
//            System.out.println("Is doctor equal to doctorDuplicate" + doctor.equals(duplicateDoctor));
//            System.out.println("Hash code " + duplicateDoctor.hashCode());

            ambulance.dispatch();


        } catch (InvalidDepartmentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Execution of Hospital class is done");
        }
        // Call HospitalInfo class(Final classs with final method and variable)
        HospitalInfo.printInfo();
        System.out.println(HospitalInfo.NAME);

    }
}