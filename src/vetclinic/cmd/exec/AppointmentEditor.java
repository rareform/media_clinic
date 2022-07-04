package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Appointment;

import java.util.Optional;

public class AppointmentEditor extends AbstractCmdExec{

    @Override
    public int execute(String cmd) { return changeStatus(cmd); }


    public CmdType getCmdType() { return CmdType.CHANGE_APPOINTMENT_STATUS; }

    private int changeStatus(String cmd) {
        var wordsArray = cmd.split(" ");

        var patientName = wordsArray[1];
        var apDate = wordsArray[2] + " " + wordsArray[3];

        Optional<Appointment> appointmentToEdit = findAppointment(patientName, apDate);

        if (appointmentToEdit.isPresent()) {
            appointmentToEdit.get().setStatus(wordsArray[4]);
            System.out.println("Appointment status changed");
        } else {
            System.out.println("Appointment not found");
        }

        return 1;
    }
}
