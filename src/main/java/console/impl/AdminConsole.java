package console.impl;

import console.IConsole;
import interfaces.impl.AdminCans;
import model.User;

import java.util.Scanner;

public class AdminConsole implements IConsole {
    @Override
    public void openConsole(User admin) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - add school  '2' - sign up teacher  '3' - sign up student" +
                    "\n'4' - add subject  '5' - add class  '6' - add lesson and engage teacher" +
                    "\n'7' - student to class  '0' - exit");
            int command = scanner.nextInt();
            if (command == 1) {
                AdminCans.getInstance().addSchool();
            } else if (command == 2) {
                AdminCans.getInstance().addTeacher();
            } else if (command == 3) {
                AdminCans.getInstance().addStudent();
            } else if (command == 4) {
                AdminCans.getInstance().addSubject();
            } else if (command == 5) {
                AdminCans.getInstance().addClass();
            } else if (command == 6) {
                AdminCans.getInstance().addLesson();
            } else if (command == 7) {
                AdminCans.getInstance().addStudentToClass();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

    private static AdminConsole adminConsole;

    public static AdminConsole getInstance() {
        if (adminConsole == null) {
            adminConsole = new AdminConsole();
        }
        return adminConsole;
    }
}
