package vetclinic.repos;

import vetclinic.model.Doctor;

import java.util.Set;

public interface DoctorRepo {

    Set<Doctor> findAll();

    void save(Doctor doctor);

    void remove(Doctor doctor);
}