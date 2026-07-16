package com.smartatm.controller;


import org.springframework.web.bind.annotation.*;

import com.smartatm.entity.User;
import com.smartatm.repository.UserRepository;



@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserRepository repository;



    public UserController(UserRepository repository){

        this.repository = repository;

    }



    @PostMapping
    public User createUser(
            @RequestBody User user
    ){

        return repository.save(user);

    }

}