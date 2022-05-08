package com.example.TaskManager2.services;


import com.example.TaskManager2.models.User;
import com.example.TaskManager2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Long addUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }
}
