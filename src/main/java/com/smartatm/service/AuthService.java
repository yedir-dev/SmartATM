package com.smartatm.service;


import org.springframework.stereotype.Service;

import com.smartatm.entity.User;
import com.smartatm.repository.UserRepository;


@Service
public class AuthService {


    private final UserRepository repository;



    public AuthService(UserRepository repository){

        this.repository = repository;

    }



    public User login(
            String username,
            String password
    ){


        User user =
                repository.findByUsername(username);



        if(user == null){

            throw new RuntimeException(
                    "Utilisateur introuvable"
            );

        }



        if(!user.getPassword().equals(password)){

            throw new RuntimeException(
                    "Mot de passe incorrect"
            );

        }



        return user;

    }


}