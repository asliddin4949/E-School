package storage;

import model.*;
import model.Class;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<User> userList = new ArrayList<>(List.of(
            new User(0, "Mr.Admin", "admin", "123", Role.ADMIN)));
    public static List<School> schoolList = new ArrayList<>();
    public static List<Subject> subjectList = new ArrayList<>();
    public static List<Class> classList = new ArrayList<>();
    public static List<Task> taskList = new ArrayList<>();
    public static List<Lesson> lessonList = new ArrayList<>();
    public static List<Answer> answerList = new ArrayList<>();

}
