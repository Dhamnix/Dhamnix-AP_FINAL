package org.example.ap_final;

import java.util.ArrayList;

public class Database {
    public static ArrayList<user> users = new ArrayList<>();

    public static void addUser(String email, String username, String password) {
        users.add(new user(email, username, password));
    }

    public static boolean userExistsByUsername(String username) {
        for (user user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }
    public static boolean userExistsByEmail(String email) {
        for (user user : users) {
            if (user.email.equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static user findUserByEmail(String email) {
        for (user user : users) {
            if (user.email.equals(email)) {
                return user;
            }
        }
        return null; // User not found
    }

    public static user findUserByUsername(String username) {
        for (user user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }
}