package com.smartatm.entity;


import jakarta.persistence.*;


@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String accountNumber;


    private double balance;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;



    // Constructeur obligatoire JPA
    public Account() {

    }



    // Constructeur complet
    public Account(
            String accountNumber,
            double balance,
            Client client
    ) {

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.client = client;

    }



    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



    public String getAccountNumber() {

        return accountNumber;

    }



    public void setAccountNumber(String accountNumber) {

        this.accountNumber = accountNumber;

    }



    public double getBalance() {

        return balance;

    }



    public void setBalance(double balance) {

        this.balance = balance;

    }



    public Client getClient() {

        return client;

    }



    public void setClient(Client client) {

        this.client = client;

    }


}