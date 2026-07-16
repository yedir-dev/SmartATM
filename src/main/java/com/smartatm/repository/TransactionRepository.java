package com.smartatm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartatm.entity.Transaction;


public interface TransactionRepository 
        extends JpaRepository<Transaction, Long> {


    List<Transaction> findByAccountAccountNumber(String accountNumber);


}