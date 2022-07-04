package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Doctor;

public class DoctorCreator extends AbstractCmdExec {

    int id = 0;

    @Override
    public int execute(String cmd) { return createDoctor(cmd); }

    public CmdType getCmdType() { return CmdType.ADD_DOCTOR; }
    private int createDoctor(String cmd) {
        var wordsArray = cmd.split(" ");

        id++;

        var doctorName = wordsArray[2] + " " + wordsArray[3];
        var doctorSpecialty = wordsArray[4];

        if (findDoctor(doctorName).isPresent()) {
            System.out.println("Doctor already exists.");
            return -1;
        }

        var newDoctor = new Doctor(id, doctorName, doctorSpecialty);

        doctorRepo.save(newDoctor);

        System.out.println("New doctor added");

        return 1;
    }
}
