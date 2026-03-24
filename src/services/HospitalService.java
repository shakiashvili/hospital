package services;
import person.Person;
import person.Patient;
import interfaces.ITreatable;
import interfaces.IAssistable;
import interfaces.IManagable;

public class HospitalService {

    public void processWorkingActivity(Person person) {
        person.work();
    }

    public void processTreatment(ITreatable treatable, Patient patient) {
        treatable.treat(patient);
    }

    public void processAssistance(IAssistable assistable, Patient patient) {
        assistable.assist(patient);
    }

    public void processManagment(IManagable managable) {
        managable.manage();
    }

}