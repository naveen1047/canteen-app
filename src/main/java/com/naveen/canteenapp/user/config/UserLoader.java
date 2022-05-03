package com.naveen.canteenapp.user.config;

import com.naveen.canteenapp.config.UserList;
import com.naveen.canteenapp.user.dao.UserRepository;
import com.naveen.canteenapp.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUser();
    }

    private void loadUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("1"));
        new UserList().generateAndGetUserList().stream().forEach((e) -> {
            users.add(new User(e.getUsername()));
        });

        userRepository.saveAll(users);
    }
}
