package com.smartatm.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.smartatm.entity.Transaction;
import com.smartatm.repository.TransactionRepository;



@RestController
@RequestMapping("/api/transactions")
public class TransactionController {



    private final TransactionRepository repository;



    public TransactionController(
            TransactionRepository repository) {

        this.repository = repository;

    }



    @GetMapping
    public List<Transaction> getAll(){

        return repository.findAll();

    }




    @GetMapping("/account/{accountNumber}")
    public List<Transaction> getByAccount(
            @PathVariable String accountNumber){

        return repository
                .findByAccountAccountNumber(accountNumber);

    }


}