package console.impl;

import console.IApplication;
import interfaces.impl.SignIn;
import model.Role;
import model.User;

import java.util.Scanner;

public class Application implements IApplication {
    @Override
    public void startApp() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("* * * * * Developer's School * * * * *");
            System.out.println("'1' - \"sign in\"  '0' - \"exit\"");
            int command = scanner.nextInt();
            if (command == 1) {
                User user = SignIn.getInstance().signIn();
                if (user == null) {
                    System.out.println("Wrong Username or Password!");
                } else if (user.getRole().equals(Role.ADMIN)) {
                    System.out.println("Hello, "+user.getName()+"!");
                    AdminConsole.getInstance().openConsole(user);
                } else if (user.getRole().equals(Role.STUDENT)) {
                    System.out.println("Hello, "+user.getName()+"!");
                    StudentConsole.getInstance().openConsole(user);
                } else {
                    System.out.println("Hello, "+user.getName()+"!");
                    TeacherConsole.getInstance().openConsole(user);
                }
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

    private static Application application;

    public static Application getInstance() {
        if (application == null) {
            application = new Application();
        }
        return application;
    }
}
