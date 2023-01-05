package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class Subject {
    int id;
    String name;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nSubject id: " + id +
                "\nName: " + name +
                "\n- - - - - - - - - -";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
