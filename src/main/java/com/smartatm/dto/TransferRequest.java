package com.smartatm.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;



public class TransferRequest {



    @NotBlank(message = "Compte source obligatoire")
    private String fromAccount;



    @NotBlank(message = "Compte destination obligatoire")
    private String toAccount;



    @Positive(message = "Le montant doit être positif")
    private double amount;




    public TransferRequest(){
    }



    public String getFromAccount(){

        return fromAccount;

    }



    public void setFromAccount(String fromAccount){

        this.fromAccount = fromAccount;

    }




    public String getToAccount(){

        return toAccount;

    }



    public void setToAccount(String toAccount){

        this.toAccount = toAccount;

    }




    public double getAmount(){

        return amount;

    }



    public void setAmount(double amount){

        this.amount = amount;

    }



}