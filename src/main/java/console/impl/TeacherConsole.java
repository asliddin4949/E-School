package console.impl;

import console.IConsole;
import interfaces.impl.TeacherCans;
import model.User;

import java.util.Scanner;

public class TeacherConsole implements IConsole {
    @Override
    public void openConsole(User teacher) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("'1' - \"show my lessons\"  '2' - \"add task\"  '3' - \"grade answer\"" +
                    "\n'4' - \"set answer status\"  '0' - \"exit\"");
            int command = scanner.nextInt();
            if (command == 1) {
                TeacherCans.getInstance().showLessons(teacher);
            } else if (command == 2) {
                TeacherCans.getInstance().addTask(teacher);
            } else if (command == 3) {
                TeacherCans.getInstance().gradeAnswers(teacher);
            } else if (command == 4) {
                TeacherCans.getInstance().setStatus(teacher);
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

    private static TeacherConsole teacherConsole;

    public static TeacherConsole getInstance() {
        if (teacherConsole == null) {
            teacherConsole = new TeacherConsole();
        }
        return teacherConsole;
    }
}
