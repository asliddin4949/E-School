package console.impl;

import console.IConsole;
import interfaces.impl.StudentCans;
import model.User;

import java.util.Scanner;

public class StudentConsole implements IConsole {
    @Override
    public void openConsole(User student) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - show my lessons  '2' - show tasks  '0' - exit" +
                    "\n'3' - send answer  '4' - show answer status  '5' - grades");
            int command = scanner.nextInt();
            if (command == 1) {
                StudentCans.getInstance().showLessons(student);
            } else if (command == 2) {
                StudentCans.getInstance().showTask(student);
            } else if (command == 3) {
                StudentCans.getInstance().sendAnswer(student);
            } else if (command == 4) {
                StudentCans.getInstance().showAnswerStatus(student);
            } else if (command == 5) {
                StudentCans.getInstance().showGrades(student);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

    private static StudentConsole studentConsole;

    public static StudentConsole getInstance() {
        if (studentConsole == null) {
            studentConsole = new StudentConsole();
        }
        return studentConsole;
    }
}
