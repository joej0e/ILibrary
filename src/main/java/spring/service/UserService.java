package spring.service;


import spring.entity.User;
import spring.controller.dto.UserDto;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User registerNewUserAccount(UserDto accountDto);

}

