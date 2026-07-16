package com.smartatm.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.smartatm.dto.DepositRequest;
import com.smartatm.dto.TransferRequest;
import com.smartatm.entity.Account;
import com.smartatm.service.AccountService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private final AccountService service;



    public AccountController(AccountService service){

        this.service = service;

    }



    // ==============================
    // GET ALL ACCOUNTS
    // ==============================

    @GetMapping
    public List<Account> getAccounts(){

        return service.findAll();

    }



    // ==============================
    // GET BY ID
    // ==============================

    @GetMapping("/{id}")
    public Account getAccount(
            @PathVariable Long id
    ){

        return service.findById(id);

    }




    // ==============================
    // CREATE ACCOUNT
    // ==============================

    @PostMapping
    public Account createAccount(
            @RequestBody Account account
    ){

        return service.save(account);

    }




    // ==============================
    // DEPOSIT
    // ==============================

    @PostMapping("/deposit")
    public Account deposit(
            @Valid @RequestBody DepositRequest request
    ){

        return service.deposit(
                request.getAccountNumber(),
                request.getAmount()
        );

    }





    // ==============================
    // WITHDRAW
    // ==============================

    @PostMapping("/withdraw")
    public Account withdraw(
            @Valid @RequestBody DepositRequest request
    ){

        return service.withdraw(
                request.getAccountNumber(),
                request.getAmount()
        );

    }





    // ==============================
    // TRANSFER
    // ==============================

    @PostMapping("/transfer")
    public Account transfer(
            @Valid @RequestBody TransferRequest request
    ){

        return service.transfer(
                request.getFromAccount(),
                request.getToAccount(),
                request.getAmount()
        );

    }



}