package com.naveen.canteenapp.user.dao;

import com.naveen.canteenapp.user.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
