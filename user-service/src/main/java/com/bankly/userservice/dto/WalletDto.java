package com.bankly.userservice.dto;

import java.io.Serializable;

public class WalletDto implements Serializable {
    private String cinClient;


    public WalletDto(String cinClient, Double balance) {
        this.cinClient = cinClient;
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

    public WalletDto() {
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "cinClient='" + cinClient + '\'' +
                '}';
    }
}
