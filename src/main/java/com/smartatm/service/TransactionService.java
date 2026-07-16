package com.smartatm.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.smartatm.entity.Transaction;
import com.smartatm.repository.TransactionRepository;



@Service
public class TransactionService {


    private final TransactionRepository repository;



    public TransactionService(
            TransactionRepository repository
    ){

        this.repository = repository;

    }




    public List<Transaction> findAll(){

        return repository.findAll();

    }




    public Transaction save(
            Transaction transaction
    ){

        return repository.save(transaction);

    }


}