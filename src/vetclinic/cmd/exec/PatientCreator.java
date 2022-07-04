package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Patient;

public class PatientCreator extends AbstractCmdExec {

    int id = 0;
    @Override
    public int execute(String cmd) { return createPatient(cmd); }

    @Override
    public CmdType getCmdType() { return CmdType.ADD_PATIENT; }

    private int createPatient(String cmd) {
        var wordsArray = cmd.split(" ");

        id++;

        var patientName = wordsArray[2];

        var patientType = wordsArray[3];

        if (findPatient(patientName).isPresent()) {
            System.out.println("Patient already exists.");
            return -1;
        }

        var newPatient = new Patient(id, patientName, patientType);

        patientRepo.save(newPatient);

        System.out.println("New patient added");

        return 1;
    }
}
