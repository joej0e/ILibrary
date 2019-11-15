package spring.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.RoleRepository;
import spring.dao.UserRepository;
import spring.entity.User;
import spring.controller.dto.UserDto;
import spring.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) {
        if (emailExists(accountDto.getEmail())) {
            throw new AlreadyExistsException("There is an account with that email address: " + accountDto.getEmail());
        }
        User user = new User();
        user.setName(accountDto.getName());
        user.setSurname(accountDto.getSurname());
        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.saveAndFlush(user);
    }


    private boolean emailExists(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return (ArrayList) userRepository.findAll();
    }

}
