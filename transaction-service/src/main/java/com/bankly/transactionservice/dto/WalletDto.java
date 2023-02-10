package com.bankly.transactionservice.dto;

import java.io.Serializable;

public class WalletDto implements Serializable {
    private String cinClient;

    private Double balance;

    private String reference;

    public WalletDto(String cinClient, Double balance, String reference) {
        this.cinClient = cinClient;
        this.balance = balance;
        this.reference = reference;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCinClient() {
        return cinClient;
    }

    public void setCinClient(String cinClient) {
        this.cinClient = cinClient;
    }

    public WalletDto(String cinClient) {
        this.cinClient = cinClient;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public WalletDto() {
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "cinClient='" + cinClient + '\'' +
                ", balance=" + balance +
                '}';
    }
}
