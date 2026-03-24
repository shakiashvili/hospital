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

    public void processTreatment(ITreatable t, Patient patient) {
        t.treat(patient);
    }

    public void processAssistance(IAssistable a, Patient patient) {
        a.assist(patient);
    }
    public void processManagment(IManagable managable) {
        managable.manage();
    }

}