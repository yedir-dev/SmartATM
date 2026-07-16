package com.smartatm.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;



public class DepositRequest {



    @NotBlank(message = "Le numéro de compte est obligatoire")
    private String accountNumber;



    @Positive(message = "Le montant doit être positif")
    private double amount;



    public DepositRequest(){
    }



    public String getAccountNumber(){

        return accountNumber;

    }



    public void setAccountNumber(String accountNumber){

        this.accountNumber = accountNumber;

    }



    public double getAmount(){

        return amount;

    }



    public void setAmount(double amount){

        this.amount = amount;

    }


}