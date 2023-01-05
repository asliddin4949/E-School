package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class School {
    int id;
    String name;
    String address;

    public School(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "School id: " + id +
                "\nName: " + name  +
                "\nAddress: " + address +
                "\n- - - - - - - - - - - ";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
