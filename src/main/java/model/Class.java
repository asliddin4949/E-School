package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class Class {
    int id;
    String name;
    School school;
    Set<User> students;

    public Class(int id, String name, School school, Set<User> students) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.students = students;
    }

    public void add(User student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "\nClass id: " + id +
                "\nName: " + name +
                "\nSchool:" + school +
                "\n- - - - - - - - - - - ";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
