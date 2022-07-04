package vetclinic.cmd.exec;

import vetclinic.model.Appointment;
import vetclinic.model.Doctor;
import vetclinic.model.Patient;
import vetclinic.repos.AppointmentRepo;
import vetclinic.repos.DoctorRepo;
import vetclinic.repos.PatientRepo;
import vetclinic.repos.impl.AppointmentRepoImpl;
import vetclinic.repos.impl.DoctorRepoImpl;
import vetclinic.repos.impl.PatientRepoImpl;

import java.util.Optional;

public abstract class AbstractCmdExec implements CmdExec {

    protected final PatientRepo patientRepo = PatientRepoImpl.getSingleton();

    protected final DoctorRepo doctorRepo = DoctorRepoImpl.getSingleton();

    protected final AppointmentRepo appointmentRepo = AppointmentRepoImpl.getSingleton();


    protected Optional<Patient> findPatient(String patientName) {
        for (Patient patient : patientRepo.findAll()) {
            if (patient.getName().equals(patientName)) {
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }


    protected Optional<Doctor> findDoctor(String doctorName) {
        for (Doctor doctor: doctorRepo.findAll()) {
            if (doctor.getName().equals(doctorName)) {
                return Optional.of(doctor);
            }
        }

        return Optional.empty();
    }

    protected Optional<Appointment> findAppointment(String patientName, String date) {
        for (Appointment appointment : appointmentRepo.findAll()) {
            if (appointment.getPatient().getName().equals(patientName) && appointment.getDate().equals(date)) {
                return Optional.of(appointment);
            }
        }

        return Optional.empty();
    }

}
