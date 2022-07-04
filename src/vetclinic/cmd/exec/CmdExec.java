package vetclinic.cmd.exec;

import vetclinic.cmd.CmdType;

public interface CmdExec {

    int execute(String cmd);

    CmdType getCmdType();
}
