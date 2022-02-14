package dao;

import models.User;

import java.util.List;

public interface UserDao {
    //post new user
    void add(User user);

    //get all users
    List<User> getAllUsers();
}
