package com.smartatm.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartatm.dto.DepositRequest;
import com.smartatm.entity.Account;
import com.smartatm.service.AccountService;
import com.smartatm.dto.TransferRequest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



public class AccountControllerTest {


    private MockMvc mockMvc;


    @Mock
    private AccountService accountService;


    private ObjectMapper objectMapper;



    @BeforeEach
    void setup(){


        MockitoAnnotations.openMocks(this);


        AccountController controller =
                new AccountController(accountService);


        mockMvc =
                MockMvcBuilders
                .standaloneSetup(controller)
                .build();


        objectMapper =
                new ObjectMapper();

    }





    @Test
    void testDepositAPI() throws Exception {



        Account account =
                new Account(
                        "ACC001",
                        1500,
                        null
                );



        when(
            accountService.deposit(
                    "ACC001",
                    500
            )
        )
        .thenReturn(account);




        DepositRequest request =
                new DepositRequest();


        request.setAccountNumber("ACC001");

        request.setAmount(500);




        mockMvc.perform(
                post("/api/accounts/deposit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(request)
                )
        )
        .andExpect(
                status().isOk()
        );


    }
    @Test
    void testGetAccountsAPI() throws Exception {


        List<Account> accounts =
                List.of(
                        new Account(
                                "ACC001",
                                1000,
                                null
                        )
                );


        when(accountService.findAll())
                .thenReturn(accounts);



        mockMvc.perform(
                get("/api/accounts")
        )
        .andExpect(
                status().isOk()
        );

    }
    @Test
    void testWithdrawAPI() throws Exception {


        Account account =
                new Account(
                        "ACC001",
                        700,
                        null
                );


        when(
            accountService.withdraw(
                    "ACC001",
                    300
            )
        )
        .thenReturn(account);



        DepositRequest request =
                new DepositRequest();

        request.setAccountNumber("ACC001");
        request.setAmount(300);



        mockMvc.perform(
                post("/api/accounts/withdraw")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(request)
                )
        )
        .andExpect(
                status().isOk()
        );


    }
    @Test
    void testTransferAPI() throws Exception {


        Account account =
                new Account(
                        "ACC001",
                        800,
                        null
                );


        when(
            accountService.transfer(
                    "ACC001",
                    "ACC002",
                    200
            )
        )
        .thenReturn(account);



        TransferRequest request =
                new TransferRequest();


        request.setFromAccount("ACC001");

        request.setToAccount("ACC002");

        request.setAmount(200);



        mockMvc.perform(
                post("/api/accounts/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(request)
                )
        )
        .andExpect(
                status().isOk()
        );


    }


}