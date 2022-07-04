package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;
import vetclinic.model.Doctor;

public class DoctorWriter extends AbstractCmdExec {

    @Override
    public int execute(String cmd) { return listDoctors(cmd); }

    public CmdType getCmdType() { return CmdType.SHOW_ALL_DOCTORS; }

    private int listDoctors(String cmd) {

        for (Doctor doctor : doctorRepo.findAll()) {
            System.out.printf("ID: %3d  |  Name: %15s  |  Specialty: %10s  |\n",
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getSpecialty()
            );
        }

        return 1;
    }

}
