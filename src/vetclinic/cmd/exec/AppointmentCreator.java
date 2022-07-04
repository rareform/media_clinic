package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Appointment;
import vetclinic.model.Doctor;
import vetclinic.model.Patient;

import java.util.Optional;

public class AppointmentCreator extends AbstractCmdExec {

    @Override
    public int execute(String cmd) { return createAppointment(cmd); }


    public CmdType getCmdType() { return CmdType.ADD_APPOINTMENT; }

    private int createAppointment(String cmd) {
        var wordsArray = cmd.split(" ");

        var patientName = wordsArray[2];
        var doctorName = wordsArray[3] + " " + wordsArray[4];
        var appointmentDate = wordsArray[5] + " " + wordsArray[6];
        var appointmentStatus = "";

        //if (wordsArray.length == 8) {
            appointmentStatus = wordsArray[7];
        //} else if (wordsArray.length == 9) {
           // appointmentStatus = wordsArray[7] + " " + wordsArray[8];
        //}


        Optional<Doctor> apDoctor = findDoctor(doctorName);
        Optional<Patient> apPatient = findPatient(patientName);

        if (!apDoctor.isPresent()) {
            System.out.println("Doctor not found");
        } else if (!apPatient.isPresent()) {
            System.out.println("Patient not found");
        } else {
            Appointment appointment = new Appointment(apPatient.get(), apDoctor.get(), appointmentDate, appointmentStatus);
            appointmentRepo.save(appointment);

            System.out.println("Appointment added");
        }

        return 1;
    }
}
