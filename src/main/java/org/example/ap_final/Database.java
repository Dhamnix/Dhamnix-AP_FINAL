package org.example.ap_final;

import java.util.ArrayList;

public class Database {
    public static ArrayList<user> users = new ArrayList<>();

    public static void addUser(String username , String password) {
        users.add(new user(username,password));
    }
    public static boolean userExists(String username){
        for (user user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }
}