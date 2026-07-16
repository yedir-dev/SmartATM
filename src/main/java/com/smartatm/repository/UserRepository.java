package com.smartatm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smartatm.entity.User;


public interface UserRepository 
        extends JpaRepository<User, Long>{


    User findByUsername(String username);


}