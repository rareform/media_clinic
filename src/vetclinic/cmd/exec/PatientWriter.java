package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Patient;

public class PatientWriter extends AbstractCmdExec {

    @Override
    public int execute(String cmd) { return listPatients(cmd); }

    public CmdType getCmdType() { return CmdType.SHOW_ALL_PATIENTS; }

    private int listPatients(String cmd) {
        for (Patient patient : patientRepo.findAll()) {
            var date = patient.getRegDate(); //16 characters, yy-mm-dd - 0-9, hh:mm - 11-15
            var strDate = date.toString();
            strDate = strDate.substring(0, 10) + " " + strDate.substring(11, 16);

            System.out.printf("ID: %3d  |  Name: %10s  |  Animal Type: %10s  |  Registration Date: %s \n",
                    patient.getId(),
                    patient.getName(),
                    patient.getAnimalType(),
                    strDate
            );
        }

        return 1;
    }



}
