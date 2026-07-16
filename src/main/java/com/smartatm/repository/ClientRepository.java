package com.smartatm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smartatm.entity.Client;



public interface ClientRepository 
        extends JpaRepository<Client, Long>{


}