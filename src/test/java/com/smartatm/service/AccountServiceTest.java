package com.smartatm.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.smartatm.entity.Account;
import com.smartatm.repository.AccountRepository;
import com.smartatm.repository.TransactionRepository;


public class AccountServiceTest {


    @Mock
    private AccountRepository accountRepository;


    @Mock
    private TransactionRepository transactionRepository;


    private AccountService accountService;



    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);

        accountService =
                new AccountService(
                        accountRepository,
                        transactionRepository
                );

    }



    @Test
    void testDeposit(){


        Account account =
                new Account(
                        "ACC001",
                        1000,
                        null
                );


        when(
            accountRepository.findByAccountNumber("ACC001")
        )
        .thenReturn(account);



        accountService.deposit(
                "ACC001",
                500
        );



        assertEquals(
                1500,
                account.getBalance()
        );


    }
    @Test
    void testWithdraw(){


        Account account =
                new Account(
                        "ACC001",
                        1000,
                        null
                );


        when(
            accountRepository.findByAccountNumber("ACC001")
        )
        .thenReturn(account);



        accountService.withdraw(
                "ACC001",
                300
        );



        assertEquals(
                700,
                account.getBalance()
        );


    }
    @Test
    void testTransfer(){


        Account source =
                new Account(
                        "ACC001",
                        1000,
                        null
                );


        Account destination =
                new Account(
                        "ACC002",
                        500,
                        null
                );



        when(
            accountRepository.findByAccountNumber("ACC001")
        )
        .thenReturn(source);



        when(
            accountRepository.findByAccountNumber("ACC002")
        )
        .thenReturn(destination);



        accountService.transfer(
                "ACC001",
                "ACC002",
                200
        );



        assertEquals(
                800,
                source.getBalance()
        );


        assertEquals(
                700,
                destination.getBalance()
        );


    }


}