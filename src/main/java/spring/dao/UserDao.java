package spring.dao;

import spring.entity.User;

import java.util.List;

public interface UserDao {

    User add(User user);

    List<User> listUsers();
}

