package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Answer {
    int id;
    Task task;
    String answer;
    Status status;
    Grade grade;
    User student;

    public Answer(int id, Task task, String answer, Status status, User student) {
        this.id = id;
        this.task = task;
        this.answer = answer;
        this.status = status;
        this.student = student;
    }

    @Override
    public String toString() {
        return "\nAnswer id: " + id +
                task +
                "\nAnswer: " + answer +
                "\nStatus: " + status +
                "\nStudent: " + student +
                "\n- - - - - - - - - - - - ";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
