package interfaces.impl;

import interfaces.ISignIn;
import model.User;
import storage.Storage;

import java.util.Scanner;

import static storage.Storage.userList;

public class SignIn implements ISignIn {

    @Override
    public User signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        return userList.stream().filter(user ->
                        user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    private static SignIn signIn;

    public static SignIn getInstance() {
        if (signIn == null) {
            signIn = new SignIn();
        }
        return signIn;
    }
}
