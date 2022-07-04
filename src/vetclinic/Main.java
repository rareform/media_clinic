package vetclinic;

import vetclinic.Auth;
import vetclinic.cmd.CmdReader;

public class Main {


    public static void main(String[] args) {
        System.out.println("Zalyalov Ruslan's vetclinic app");

        authenticate();

        CmdReader.startReading();
    }

    private static void authenticate() {
        Auth.authenticate();
    }
}
