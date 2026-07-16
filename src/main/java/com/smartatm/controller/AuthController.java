package com.smartatm.controller;


import org.springframework.web.bind.annotation.*;

import com.smartatm.dto.LoginRequest;
import com.smartatm.entity.User;
import com.smartatm.service.AuthService;



@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService service;



    public AuthController(AuthService service){

        this.service = service;

    }




    @PostMapping("/login")
    public User login(
            @RequestBody LoginRequest request
    ){

        return service.login(
                request.getUsername(),
                request.getPassword()
        );

    }


}