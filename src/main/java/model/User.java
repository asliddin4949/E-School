package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    int id;
    String name;
    String username;
    String password;
    Role role;

    public User(int id, String name, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User id: " + id +
                "\nName: " + name +
                "\n- - - - - - - - - -";
    }

    public static int currentId = 1;

    {
        currentId++;
    }
}
