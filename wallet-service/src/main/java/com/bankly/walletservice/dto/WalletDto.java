package com.bankly.walletservice.dto;

import java.time.LocalDate;

public class WalletDto {
    private Long id;
    private String cinClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
