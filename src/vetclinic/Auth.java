package vetclinic;

import java.util.Scanner;

public class Auth {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "123";

    public static void authenticate() {

        Scanner s = new Scanner(System.in);

        boolean isLoginSuccess = false;

        for (int i = 3; i != 0; i--) {
            String login;
            String password;

            System.out.print("Login: ");
            login = s.nextLine();

            System.out.print("Password: ");
            password = s.nextLine();

            if (validate(login, password)) {
                isLoginSuccess = true;
                break;
            } else if (i == 1) {
                break;
            } else {
                System.out.println("Unsuccessful login attempt. Try again");
            }
        }

        if (!isLoginSuccess) {
            throw new RuntimeException("Login failed.");
        }
    }

    public static boolean validate(String login, String password) {
        return login.equals(LOGIN) && password.equals(PASSWORD);
    }
}
