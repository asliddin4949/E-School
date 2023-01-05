package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
public class Lesson {
    int id;
    String name;
    Class aClass;
    User teacher;
    Subject subject;
    Date startTime;
    Date finishTime;

    public Lesson(int id, String name, Class aClass, User teacher, Subject subject, Date startTime, Date finishTime) {
        this.id = id;
        this.name = name;
        this.aClass = aClass;
        this.teacher = teacher;
        this.subject = subject;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public static int currentId = 1;

    {
        currentId++;
    }

}
