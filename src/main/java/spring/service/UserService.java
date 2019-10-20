package spring.service;

import spring.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    List<User> listUsers();
}

