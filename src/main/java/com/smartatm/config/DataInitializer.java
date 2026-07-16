package com.smartatm.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.smartatm.entity.Account;
import com.smartatm.entity.Client;
import com.smartatm.entity.User;

import com.smartatm.repository.AccountRepository;
import com.smartatm.repository.ClientRepository;
import com.smartatm.repository.UserRepository;



@Component
public class DataInitializer implements CommandLineRunner {


    private final ClientRepository clientRepository;

    private final AccountRepository accountRepository;

    private final UserRepository userRepository;



    public DataInitializer(
            ClientRepository clientRepository,
            AccountRepository accountRepository,
            UserRepository userRepository) {

        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;

    }




    @Override
    public void run(String... args) {


        if(clientRepository.count()==0){


            Client client =
                    new Client();


            client.setNom("Ben Amar");

            client.setPrenom("Yedir");

            client.setTelephone("0612345678");


            clientRepository.save(client);



            Account account1 =
                    new Account(
                            "ACC001",
                            1000,
                            client
                    );


            accountRepository.save(account1);



            Account account2 =
                    new Account(
                            "ACC002",
                            500,
                            client
                    );


            accountRepository.save(account2);



        }



        if(userRepository.count()==0){


            User user =
                    new User();


            user.setUsername("admin");

            user.setPassword("1234");


            userRepository.save(user);

        }


    }

}