package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;


@Controller
class UsersController {

    @Autowired
    private final UserRepository repository;

    public UsersController(UserRepository repository) {
        this.repository = repository;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        for(int i =0;i<10;i++){
            User user = new User();
            user.setUserId(i);
            user.setName("user"+1);
            user.setPassword(encoder.encode("password"+1));
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setVoted(false);
            repository.save(user);
        }
        User user = new User();
        user.setUserId(1);
        user.setName("namhm");
        user.setPassword("$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu");
        user.setEnabled(true);
        user.setVoted(false);
        user.setRole("ROLE_USER");
        repository.save(user);
    }

}