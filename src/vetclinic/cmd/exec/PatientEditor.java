package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Patient;

import java.util.Optional;

public class PatientEditor extends AbstractCmdExec{

    @Override
    public int execute(String cmd) { return editPatient(cmd); }

    public CmdType getCmdType() { return CmdType.EDIT_PATIENT; }


    private int editPatient(String cmd) {

        var wordsArray = cmd.split(" ");

        var patientName = wordsArray[2];

        Optional<Patient> patientToEdit = findPatient(patientName);

        if (patientToEdit.isPresent()) {
            patientToEdit.get().setName(wordsArray[3]);

            System.out.println("Patient's name successfully changed");
        } else {
            System.out.println("Patient not found");
        }


        return 1;
    }
}
