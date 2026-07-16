package com.smartatm.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "atm_transactions")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String type;


    private double amount;


    private LocalDateTime date;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_id")
    private Account account;



    public Transaction(){

        this.date = LocalDateTime.now();

    }


    public Transaction(
            String type,
            double amount,
            Account account
    ){

        this.type = type;
        this.amount = amount;
        this.account = account;
        this.date = LocalDateTime.now();

    }



    public Long getId(){

        return id;

    }



    public String getType(){

        return type;

    }


    public void setType(String type){

        this.type = type;

    }



    public double getAmount(){

        return amount;

    }


    public void setAmount(double amount){

        this.amount = amount;

    }



    public LocalDateTime getDate(){

        return date;

    }


    public void setDate(LocalDateTime date){

        this.date=date;

    }



    public Account getAccount(){

        return account;

    }


    public void setAccount(Account account){

        this.account=account;

    }


}