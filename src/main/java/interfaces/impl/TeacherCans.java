package interfaces.impl;

import interfaces.ITeacher;
import model.*;

import java.util.Scanner;

import static storage.Storage.*;

public class TeacherCans implements ITeacher {
    @Override
    public void showLessons(User teacher) {
        for (Lesson lesson : lessonList) {
            if (lesson.getTeacher().equals(teacher)) {
                System.out.println(lesson);
            }
        }
    }

    @Override
    public void addTask(User teacher) {
        showLessons(teacher);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Lesson Id:");
        int lessonId = scanner.nextInt();
        Lesson lesson = lessonList.stream().filter(lesson1 -> lesson1.getId() == lessonId).findFirst().orElse(null);
        if (lesson == null) {
            System.out.println("Wrong Id!");
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Title:");
            String title = scanner.nextLine();
            System.out.println("To Do: ");
            String toDo = scanner.nextLine();

            taskList.add(new Task(Task.currentId, title, lesson, toDo));
            System.out.println("Task added!");
        }
    }

    @Override
    public void setStatus(User teacher) {
        Scanner scanner = new Scanner(System.in);
        for (Answer answer : answerList) {
            if (answer.getTask().getLesson().getTeacher().equals(teacher) && answer.getStatus().equals(Status.CHECKING)) {
                System.out.println(answer);
            }
        }
        System.out.println("Enter Answer Id:");
        int answerId = scanner.nextInt();

        Answer chosenAnswer = answerList.stream().filter(answer -> answer.getId() == answerId).findFirst().orElse(null);

        if (chosenAnswer == null) {
            System.out.println("Wrong id!");
        } else {
            System.out.println("Enter Status: " +
                    "\n'1' - In Progress '2' - checking '3' - completed");
            int status = scanner.nextInt();
            status(chosenAnswer, status);
            System.out.println("Status updated!");
        }

    }

    void status(Answer chosenAnswer, int status) {
        for (Answer answer : answerList) {
            if (answer.equals(chosenAnswer)) {
                if (status == 1) {
                    answer.setStatus(Status.IN_PROGRESS);
                } else if (status == 2) {
                    answer.setStatus(Status.CHECKING);
                } else if (status == 3) {
                    answer.setStatus(Status.COMPLETED);
                } else {
                    System.out.println("Wrong Status!");
                }
            }
        }
    }

    @Override
    public void gradeAnswers(User teacher) {
        for (Answer answer : answerList) {
            if (answer.getTask().getLesson().getTeacher().equals(teacher) && answer.getStatus().equals(Status.CHECKING)) {
                System.out.println(answer);
            }
        }
        System.out.println("Enter Answer Id:");
        Scanner scanner = new Scanner(System.in);
        int answerId = scanner.nextInt();

        Answer chosenAnswer = answerList.stream().filter(answer -> answer.getId() == answerId).findFirst().orElse(null);

        if (chosenAnswer == null) {
            System.out.println("Wrong id!");
        } else {
            System.out.println("Enter Grade: ['0 - 5'] ");
            int grade = scanner.nextInt();
            setGrade(chosenAnswer, grade);
            System.out.println("Grade updated!");
        }
    }

    void setGrade(Answer chosenAnswer, int grade) {
        for (Answer answer : answerList) {
            if (answer.equals(chosenAnswer)) {
                if (grade == 0) {
                    answer.setGrade(Grade.ZERO);
                    answer.setStatus(Status.COMPLETED);
                } else if (grade == 1) {
                    answer.setGrade(Grade.ONE);
                    answer.setStatus(Status.COMPLETED);
                } else if (grade == 2) {
                    answer.setGrade(Grade.TWO);
                    answer.setStatus(Status.COMPLETED);
                } else if (grade == 3) {
                    answer.setGrade(Grade.THREE);
                    answer.setStatus(Status.COMPLETED);
                } else if (grade == 4) {
                    answer.setGrade(Grade.FOUR);
                    answer.setStatus(Status.COMPLETED);
                } else if (grade == 5) {
                    answer.setGrade(Grade.FIVE);
                    answer.setStatus(Status.COMPLETED);
                } else {
                    System.out.println("Wrong Grade!");
                }
            }
        }
    }

    private static TeacherCans teacherCans;

    public static TeacherCans getInstance() {
        if (teacherCans == null) {
            teacherCans = new TeacherCans();
        }
        return teacherCans;
    }
}
