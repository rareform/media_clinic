package vetclinic.repos;

import vetclinic.model.Appointment;
import vetclinic.model.Doctor;

import java.util.Set;

public interface AppointmentRepo {

    Set<Appointment> findAll();

    void save(Appointment appointment);

    void remove(Appointment appointment);
}
