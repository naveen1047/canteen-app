package com.naveen.canteenapp.config;

import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    public List<User> generateAndGetUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(new User("1", "1", new ArrayList<>()));

        for (int i = 1; i < 30; i++) {
            User user;
            if (i < 10) {
                user = new User("20MCM00" + i, "20MCM00" + i, new ArrayList<>());
            } else {
                user = new User("20MCM0" + i, "20MCM0" + i, new ArrayList<>());
            }
            userList.add(user);
        }
        return  userList;
    }
}
