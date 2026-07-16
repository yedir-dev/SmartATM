package com.smartatm.dto;


public class DashboardResponse {


    private long clients;

    private long comptes;

    private long transactions;

    private double totalBalance;



    public DashboardResponse(
            long clients,
            long comptes,
            long transactions,
            double totalBalance) {

        this.clients = clients;
        this.comptes = comptes;
        this.transactions = transactions;
        this.totalBalance = totalBalance;

    }



    public long getClients() {
        return clients;
    }


    public long getComptes() {
        return comptes;
    }


    public long getTransactions() {
        return transactions;
    }


    public double getTotalBalance() {
        return totalBalance;
    }

}