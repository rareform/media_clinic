package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Patient;

import java.util.Optional;

public class PatientRemover extends AbstractCmdExec {

    @Override
    public int execute(String cmd) { return deletePatient(cmd); }


    @Override
    public CmdType getCmdType() { return CmdType.DELETE_PATIENT; }


    private int deletePatient(String cmd) {
        var wordsArray = cmd.split(" ");

        var patientNameToRemove = wordsArray[2];

        Optional<Patient> patientToRemove = findPatient(patientNameToRemove);

        if (patientToRemove.isPresent()) {
            patientRepo.remove(patientToRemove.get());

            System.out.println("Patient deleted.");
        } else {
            System.out.println("Patient doesn't exist");
        }

        return 1;
    }
}
