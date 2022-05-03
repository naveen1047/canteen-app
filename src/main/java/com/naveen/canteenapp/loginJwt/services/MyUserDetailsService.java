package com.naveen.canteenapp.loginJwt.services;

import com.naveen.canteenapp.config.UserList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = new UserList().generateAndGetUserList();

        return userList.stream()
                .filter(obj -> obj.getUsername().equals(username))
                .findFirst().get();
    }
}
