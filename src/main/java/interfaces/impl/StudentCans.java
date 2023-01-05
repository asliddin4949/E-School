package interfaces.impl;

import interfaces.IStudent;
import model.*;

import java.util.Scanner;

import static storage.Storage.*;

public class StudentCans implements IStudent {
    private static StudentCans studentCans;

    public static StudentCans getInstance() {
        if (studentCans == null) {
            studentCans = new StudentCans();
        }
        return studentCans;
    }

    @Override
    public void showLessons(User student) {
        for (Lesson lesson : lessonList) {
            if (lesson.getAClass().getStudents().contains(student)) {
                System.out.println(lesson);
            }
        }
    }

    @Override
    public void showTask(User student) {
        Scanner scanner = new Scanner(System.in);
        showLessons(student);
        System.out.println("Enter Lesson Id:");
        int lessonId = scanner.nextInt();
        var chosenLesson = lessonList.stream().filter(lesson -> lesson.getId() == lessonId).findFirst().orElse(null);
        if (chosenLesson != null) {
            for (Task task : taskList) {
                if (task.getLesson().equals(chosenLesson)) {
                    System.out.println(task);
                }
            }
        } else {
            System.out.println("Wrong Id!");
        }
    }

    @Override
    public void sendAnswer(User student) {
        Scanner scanner = new Scanner(System.in);
        showTask(student);
        System.out.println("Enter Task Id:");
        int taskId = scanner.nextInt();
        var chosenTask = taskList.stream().filter(task -> task.getId() == taskId).findFirst().orElse(null);
        if (chosenTask != null) {
            System.out.println("Enter Answer:");
            scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            answerList.add(new Answer(Answer.currentId, chosenTask, answer, Status.IN_PROGRESS, student));
        } else {
            System.out.println("Wrong Id!");
        }
    }

    @Override
    public void showGrades(User student) {
        for (Answer answer : answerList) {
            if (answer.getStudent().equals(student) && answer.getStatus().equals(Status.COMPLETED)) {
                System.out.println("Answer Id: " + answer.getId() +
                        "\nTask: " + answer.getTask()
                        + "\nGrade: " + answer.getGrade());
            }
        }
    }

    @Override
    public void showAnswerStatus(User student) {
        for (Answer answer : answerList) {
            if (answer.getStudent().equals(student)) {
                System.out.println("Answer Id: " + answer.getId() +
                        "\nTask: " + answer.getTask()
                        + "\nGrade: " + answer.getStatus());
            }
        }
    }
}
