import java.util.ArrayList;
public class Hospital {
ArrayList<Patient> patients = new ArrayList<>();
public void addPatient(Patient p) {
        patients.add(p);
    }
public ArrayList<Patient> getPatients() {
        return patients;
    }
public void updatePatient(int id, String name, int age, String disease) {
        for (Patient p : patients) {
            if (p.id == id) {
                p.name = name;
                p.age = age;
                p.disease = disease;
                return;
     }
    }
    }

public void deletePatient(int id) {
patients.removeIf(p -> p.id == id);
    }
    }