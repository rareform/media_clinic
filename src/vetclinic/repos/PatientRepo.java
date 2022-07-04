package vetclinic.repos;

import vetclinic.model.Patient;

import java.util.Set;

public interface PatientRepo {

    Set<Patient> findAll();

    void save(Patient patient);

    void remove(Patient patient);
}
