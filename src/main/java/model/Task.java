package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Task {
    int id;
    String title;
    Lesson lesson;
    String toDo;

    public Task(int id, String title, Lesson lesson, String toDo) {
        this.id = id;
        this.title = title;
        this.lesson = lesson;
        this.toDo = toDo;
    }

    public static int currentId = 1;

    {
        currentId++;
    }

}
