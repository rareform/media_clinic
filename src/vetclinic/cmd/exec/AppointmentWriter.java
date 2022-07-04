package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Appointment;

public class AppointmentWriter extends AbstractCmdExec{

    @Override
    public int execute(String cmd) { return listAppointments(cmd); }

    public CmdType getCmdType() { return CmdType.SHOW_APPOINTMENTS; }


    //мне кажется, есть и получше способы реализовать эту функцию, чем с помощью массива размером 1 :)
    //но я не додумался
    private int listAppointments(String cmd) {

        var wordsArray = cmd.split(" ");

        if (wordsArray.length == 1) {
            for (Appointment appointment : appointmentRepo.findAll()) {
                var patient = appointment.getPatient();
                var patientName = patient.getName();
                var doctor = appointment.getDoctor();
                var doctorName = doctor.getName();
                System.out.printf("Patient: %10s  |  Doctor: %15s  |  Date: %20s  |  Status: %15s\n",
                        patientName,
                        doctorName,
                        appointment.getDate(),
                        appointment.getStatus()
                );
            }
        } else {
            for (Appointment appointment : appointmentRepo.findAll()) {
                var patient = appointment.getPatient();
                var patientName = patient.getName();
                var doctor = appointment.getDoctor();
                var doctorName = doctor.getName();
                if (patientName.equals(wordsArray[1])) {
                    System.out.printf("Patient: %10s  |  Doctor: %15s  |  Date: %20s  |  Status: %15s\n",
                            patientName,
                            doctorName,
                            appointment.getDate(),
                            appointment.getStatus()
                    );
                }
            }
        }

        return 1;
    }


}
