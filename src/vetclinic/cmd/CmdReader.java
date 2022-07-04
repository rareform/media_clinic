package vetclinic.cmd;

import vetclinic.cmd.exec.*;
import vetclinic.model.Patient;

import java.util.Map;
import java.util.Scanner;

public class CmdReader {

    /**
     * Command list:
     * "add patient name type" - name - 1 word, type - animal type, 1 word. ex: add patient Mosya dog
     * "patients" - show all patients
     * "add doctor F I.O. specialty" - F - last name, I.O. - initials, specialty - 1 word. ex: add doctor Zalyalov R.R. dogs
     * "doctors" - show all doctors
     * "delete patient name" - delete existing patient by name. name - 1 word
     * "add appointment patient-name doctor-name yyyy.mm.dd hh:MM status" ex: add appointment Mosya Zalyalov R.R. 2022.07.20 13:00 new
     * status (1 word) could be: new, pending, ongoing, finished, cancelled
     * "appointments" - show all appointments
     * "appointments patient-name" - show all appointments of particular patient
     * "edit patient old-name new-name" - change patient's name. old-name and new-name can only be 1 word
     * "status patient-name doctor-name new-status" - change appointment status, ex: status Mosya Zalyalov R.R. cancelled
     */
    private static final Map<CmdType, CmdExec> CMD_EXEC = Map.of(
            CmdType.ADD_PATIENT, new PatientCreator(),
            CmdType.SHOW_ALL_PATIENTS, new PatientWriter(),
            CmdType.ADD_DOCTOR, new DoctorCreator(),
            CmdType.SHOW_ALL_DOCTORS, new DoctorWriter(),
            CmdType.DELETE_PATIENT, new PatientRemover(),
            CmdType.ADD_APPOINTMENT, new AppointmentCreator(),
            CmdType.SHOW_APPOINTMENTS, new AppointmentWriter(),
            CmdType.EDIT_PATIENT, new PatientEditor(),
            CmdType.CHANGE_APPOINTMENT_STATUS, new AppointmentEditor()
    );

    public static void startReading() {
        System.out.println("Enter command: ");
        Scanner s = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            i = readCmd(s);
        }

        s.close();
    }

    private static int readCmd(Scanner s) {
        var cmdString = s.nextLine();

        CmdType cmdType = getCmdType(cmdString);

        if (CMD_EXEC.containsKey(cmdType)) {
            var cmdExec = CMD_EXEC.get(cmdType);
            return cmdExec.execute(cmdString);
        }

        if (cmdType == CmdType.EXIT) {
            return 0;
        }

        System.out.println("Wrong command.");
        return -1;
    }

    //Я не добавил обработчики ошибок на те случаи, когда команда введена неправильно,
    //но выполняется условие cmdString.contains(),
    //так что вводить их лучше сразу правильно
    private static CmdType getCmdType(String cmdString) {
        if (cmdString.contains("add patient")) {
            return CmdType.ADD_PATIENT;
        }

        if (cmdString.contains("patients")) {
            return CmdType.SHOW_ALL_PATIENTS;
        }

        if (cmdString.contains("add doctor")) {
            return CmdType.ADD_DOCTOR;
        }

        if (cmdString.contains("doctors")) {
            return CmdType.SHOW_ALL_DOCTORS;
        }

        if (cmdString.contains("add appointment")) {
            return CmdType.ADD_APPOINTMENT;
        }

        if (cmdString.contains("appointments")) {
            return CmdType.SHOW_APPOINTMENTS;
        }

        if (cmdString.contains("delete patient")) {
            return CmdType.DELETE_PATIENT;
        }

        if (cmdString.contains("edit patient")) {
            return CmdType.EDIT_PATIENT;
        }

        if (cmdString.contains("status")) {
            return CmdType.CHANGE_APPOINTMENT_STATUS;
        }

        if (cmdString.contains("exit")) {
            return CmdType.EXIT;
        }

        return CmdType.UNDEFINED;
    }
}
