package com.smartatm.controller;


import org.springframework.web.bind.annotation.*;

import com.smartatm.dto.DashboardResponse;
import com.smartatm.repository.AccountRepository;
import com.smartatm.repository.ClientRepository;
import com.smartatm.repository.TransactionRepository;



@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {



    private final ClientRepository clientRepository;

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;



    public DashboardController(
            ClientRepository clientRepository,
            AccountRepository accountRepository,
            TransactionRepository transactionRepository) {


        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;

    }




    @GetMapping
    public DashboardResponse dashboard(){


        double totalBalance =
                accountRepository
                .findAll()
                .stream()
                .mapToDouble(a -> a.getBalance())
                .sum();



        return new DashboardResponse(

                clientRepository.count(),

                accountRepository.count(),

                transactionRepository.count(),

                totalBalance

        );


    }


}