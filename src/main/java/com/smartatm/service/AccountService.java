package com.smartatm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartatm.entity.Account;
import com.smartatm.entity.Transaction;
import com.smartatm.repository.AccountRepository;
import com.smartatm.repository.TransactionRepository;


@Service
public class AccountService {


    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;



    public AccountService(
            AccountRepository accountRepository,
            TransactionRepository transactionRepository
    ) {

        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;

    }



    // ======================
    // GET ALL
    // ======================
    public List<Account> findAll() {

        return accountRepository.findAll();

    }



    // ======================
    // GET BY ID
    // ======================
    public Account findById(Long id) {

        return accountRepository.findById(id).orElse(null);

    }



    // ======================
    // SAVE
    // ======================
    public Account save(Account account) {

        return accountRepository.save(account);

    }



    // ======================
    // DEPOSIT
    // ======================
    public Account deposit(
            String accountNumber,
            double amount
    ) {


        if(amount <= 0){

            throw new RuntimeException(
                    "Montant invalide"
            );

        }



        Account account =
                accountRepository.findByAccountNumber(accountNumber);



        if(account == null){

            throw new RuntimeException(
                    "Compte introuvable"
            );

        }



        account.setBalance(
                account.getBalance() + amount
        );



        Account saved =
                accountRepository.save(account);



        Transaction transaction =
                new Transaction(
                        "DEPOSIT",
                        amount,
                        account
                );


        transactionRepository.save(transaction);



        return saved;

    }





    // ======================
    // WITHDRAW
    // ======================
    public Account withdraw(
            String accountNumber,
            double amount
    ) {


        if(amount <= 0){

            throw new RuntimeException(
                    "Montant invalide"
            );

        }



        Account account =
                accountRepository.findByAccountNumber(accountNumber);



        if(account == null){

            throw new RuntimeException(
                    "Compte introuvable"
            );

        }



        if(account.getBalance() < amount){

            throw new RuntimeException(
                    "Solde insuffisant"
            );

        }



        account.setBalance(
                account.getBalance() - amount
        );



        Account saved =
                accountRepository.save(account);



        Transaction transaction =
                new Transaction(
                        "WITHDRAW",
                        amount,
                        account
                );


        transactionRepository.save(transaction);



        return saved;

    }





    // ======================
    // TRANSFER
    // ======================
    public Account transfer(
            String fromAccount,
            String toAccount,
            double amount
    ) {



        if(amount <= 0){

            throw new RuntimeException(
                    "Montant invalide"
            );

        }



        Account source =
                accountRepository.findByAccountNumber(fromAccount);



        Account destination =
                accountRepository.findByAccountNumber(toAccount);



        if(source == null){

            throw new RuntimeException(
                    "Compte source introuvable"
            );

        }



        if(destination == null){

            throw new RuntimeException(
                    "Compte destination introuvable"
            );

        }



        if(source.getBalance() < amount){

            throw new RuntimeException(
                    "Solde insuffisant"
            );

        }



        // débit
        source.setBalance(
                source.getBalance() - amount
        );



        // crédit
        destination.setBalance(
                destination.getBalance() + amount
        );



        accountRepository.save(source);

        accountRepository.save(destination);




        Transaction debit =
                new Transaction(
                        "TRANSFER_OUT",
                        amount,
                        source
                );



        Transaction credit =
                new Transaction(
                        "TRANSFER_IN",
                        amount,
                        destination
                );



        transactionRepository.save(debit);

        transactionRepository.save(credit);



        return source;

    }


}