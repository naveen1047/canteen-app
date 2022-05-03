package com.naveen.canteenapp.user.services;

import com.naveen.canteenapp.user.dao.UserRepository;
import com.naveen.canteenapp.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

//    public UserServiceImpl(UserRepository UserRepository) {
//        this.UserRepository = UserRepository;
//    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

}
