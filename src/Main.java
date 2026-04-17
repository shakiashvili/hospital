import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;

import records.MedicalReport;
import enums.*;
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

            Equipment scissors = new Equipment("Scissors", true);
            List<Equipment> doctorEquipments = new ArrayList<>();
            doctorEquipments.add(scissors);

            MedicalRecord record = new MedicalRecord("Rec-01", "Checkup", LocalDateTime.now());
            Prescription prescription = new Prescription("Rx-01", "Aspirin", new BigDecimal("15.50"));

            Patient patient = new Patient(22, "Giorgi", record, prescription);
            Set<Patient> patients = new HashSet<>();
            patients.add(patient);

            Doctor doctor = new Doctor(
                    40, "Lasha",
                    new BigDecimal("9500"),
                    "Cardiology",
                    doctorEquipments,
                    patients,ShiftType.DAY);

            List<Doctor> doctors = new ArrayList<>();
            doctors.add(doctor);

            Nurse nurse = new Nurse(
                    25, "Ana",
                    new BigDecimal("3000"),
                    ShiftType.NIGHT,
                    patients);
            List<Nurse> nurses = new ArrayList<>();
            nurses.add(nurse);

            Receptionist receptionist = new Receptionist(
                    30, "Nina",
                    new BigDecimal("500"),
                    ShiftType.NIGHT);

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
            Hospital hospital = new Hospital("Med Hospital", building, departments, ambulances, parking, waitingRoom);

            System.out.println("Welcome to " + hospital.getName());


            MedicalReport medicalReport = new MedicalReport("", "Stable condition, needs rest.", LocalDateTime.now());
            System.out.println("Report Diagnostic: " + medicalReport.diagnostic());

            Predicate<Patient> isAdult = p -> p.getAge() >= 18;
            Function<Doctor, String> docInfo = d -> "Specialist: " + d.getName() + " [" + d.getSpecialization() + "]";
            Consumer<MedicalReport> logReport = r -> System.out.println("Logging Report: " + r.diagnostic());
            Supplier<LocalDateTime> timeNow = () -> LocalDateTime.now();
            BiFunction<RoomType, Integer, Double> costCalc = (type, days) -> type.calculateTotalCost(days);


            if (isAdult.test(patient)) System.out.println(patient.getName() + " is an adult.");
            System.out.println(docInfo.apply(doctor));
            logReport.accept(medicalReport);

            EmergencyAlert siren = (msg, level) -> {
                if(level.isCritical()) System.out.println("!!! ALERT [" + level.getColor() + "]: " + msg);
            };
            siren.alert("Emergency in ICU", UrgencyLevel.HIGH);

            TaxCalculator taxCalc = (amount, type) -> type.calculateTaxes(amount) + amount;
            double finalBill = taxCalc.apply(costCalc.apply(RoomType.VIP, 3), HospitalType.PRIVATE);
            System.out.println("Total VIP Bill with Tax: $" + finalBill);

            PatientValidator validator = p -> p.getName() != null && !p.getName().isEmpty() && (p.getAge() > 0 && p.getAge() < 150);
            System.out.println("Is patient valid? " + validator.validate(patient));

            if(!doctors.isEmpty()) {
                System.out.println("First Doctor: " + doctors.get(0).getName());
            }

            for(Map.Entry<Patient, Room> entry: patientAssignmentMap.entrySet()) {
                System.out.println("Patient " + entry.getKey().getName() + " in Room " + entry.getValue().getRoomNumber());
            }

            Inventory<Equipment> inv = new Inventory<>();
            inv.add(scissors);

            DataLogger<Patient> patientLog = new DataLogger<>(patient);
            patientLog.printLog();

            LocalDateTime arrival = LocalDateTime.now().minusHours(4);
            LocalDateTime departure = LocalDateTime.now();

            // Implementation of BI function
            BiFunction<Long, BigDecimal, BigDecimal> standardRate = (hours,rate) -> {
                if(hours <= 1) {
                    return BigDecimal.ZERO;
                }
                return rate.multiply(BigDecimal.valueOf(hours));
            };

            parking.processParking(arrival, departure, standardRate);

            HospitalService service = new HospitalService();
            service.processWorkingActivity(doctor);
            service.processTreatment(doctor, patient);

            ambulance.dispatch();

        } catch (InvalidDepartmentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Execution of Hospital logic is done.");
        }

        HospitalInfo.printInfo();
    }
}