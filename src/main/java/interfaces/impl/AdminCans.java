package interfaces.impl;

import interfaces.IAdmin;
import lombok.SneakyThrows;
import model.*;
import model.Class;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

import static storage.Storage.*;

public class AdminCans implements IAdmin {
    @Override
    public void addSchool() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Address:");
        String address = scanner.nextLine();
        School checkSchool = schoolList.stream().filter(school -> school.getName().equals(name))
                .findFirst().orElse(null);
        if (checkSchool == null) {
            schoolList.add(new School(School.currentId, name, address));
        } else {
            System.out.println("This name exists SchoolList!");
        }
    }

    @Override
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        User student = userList.stream().filter(user ->
                user.getUsername().equals(username)).findFirst().orElse(null);
        if (student == null) {
            System.out.println("Password");
            String password = scanner.nextLine();
            System.out.println("Name:");
            String name = scanner.nextLine();
            userList.add(new User(User.currentId, name, username, password, Role.STUDENT));
            System.out.println("Student added!");
        } else {
            System.out.println("this username exists");
        }
    }

    @Override
    public void addTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.nextLine();
        User student = userList.stream().filter(user ->
                user.getUsername().equals(username)).findFirst().orElse(null);
        if (student == null) {
            System.out.println("Password");
            String password = scanner.nextLine();
            System.out.println("Name:");
            String name = scanner.nextLine();
            userList.add(new User(User.currentId, name, username, password, Role.TEACHER));
            System.out.println("Teacher added!");
        } else {
            System.out.println("this username exists");
        }
    }

    @Override
    public void addClass() {
        Scanner scanner = new Scanner(System.in);
        schoolList.forEach(System.out::println);
        System.out.println("School Id:");
        int schoolId = scanner.nextInt();

        School chosenSchool = schoolList.stream().filter(school ->
                school.getId() == schoolId).findFirst().orElse(null);
        if (chosenSchool != null) {
            System.out.println("Class name:");
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            Class checkClass = classList.stream().filter(aClass ->
                            aClass.getName().equals(name) && aClass.getSchool().equals(chosenSchool))
                    .findFirst().orElse(null);
            if (checkClass == null) {
                classList.add(new Class(Class.currentId, name, chosenSchool, new HashSet<>()));
                System.out.println("Class added!");
            } else {
                System.out.println("This classname exists in this School!");
            }

        } else {
            System.out.println("Wrong Id!");
        }
    }

    @Override
    public void addSubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        Subject checkSubject = subjectList.stream().filter(subject -> subject.getName().equals(name))
                .findFirst().orElse(null);

        if (checkSubject == null) {
            subjectList.add(new Subject(Subject.currentId, name));
            System.out.println("Subject added!");
        } else {
            System.out.println("This name exists");
        }
    }


    @Override
    public void addStudentToClass() {
        Scanner scanner = new Scanner(System.in);
        for (User user : userList) {
            if (user.getRole().equals(Role.STUDENT)) {
                System.out.println(user);
            }
        }
        System.out.println("Enter Id:");
        int studentId = scanner.nextInt();
        classList.forEach(System.out::println);
        System.out.println("Enter Id:");
        int classId = scanner.nextInt();

        User student = userList.stream().filter(user -> user.getId() == studentId).findFirst().orElse(null);
        Class chosenClass = classList.stream().filter(aClass1 -> aClass1.getId() == classId).findFirst().orElse(null);
        if (student != null && chosenClass != null) {
            for (Class aClass : classList) {
                if (aClass.equals(chosenClass)) {
                    aClass.add(student);
                    System.out.println("Student Added to Class!");
                }
            }
        } else {
            System.out.println("Wrong Id!");
        }
    }

    @SneakyThrows
    @Override
    public void addLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lesson Name: ");
        String name = scanner.nextLine();
        scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println("Beginning time:");
        String startTime = scanner.nextLine();
        System.out.println("Finishing time:");
        String finishTime = scanner.nextLine();
        Date date1 = dateFormat.parse(startTime);
        Date date2 = dateFormat.parse(finishTime);
        scanner = new Scanner(System.in);
        classList.forEach(System.out::println);
        System.out.println("Enter Class Id:");
        int classId = scanner.nextInt();
        subjectList.forEach(System.out::println);
        System.out.println("Enter Subject Id:");
        int subjectId = scanner.nextInt();
        for (User user : userList) {
            if (user.getRole().equals(Role.TEACHER)) {
                System.out.println(user);
            }
        }
        System.out.println("Enter Teacher Id:");
        int teacherId = scanner.nextInt();
        User teacher = userList.stream().filter(user -> user.getId() == teacherId).findFirst().orElse(null);
        Subject subject = subjectList.stream().filter(subject1 -> subject1.getId() == subjectId).findFirst().orElse(null);
        Class aClass = classList.stream().filter(aClass1 -> aClass1.getId() == classId).findFirst().orElse(null);

        if (teacher != null && subject != null && aClass != null) {

            lessonList.add(new Lesson(Lesson.currentId, name, aClass, teacher, subject, date1, date2));
            System.out.println("Lesson added!");

        } else {
            System.out.println("Wrong Id!");
        }
    }

    private static AdminCans adminCans;

    public static AdminCans getInstance() {
        if (adminCans == null) {
            adminCans = new AdminCans();
        }
        return adminCans;
    }
}
