package com.bankly.walletservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private LocalDate createdAt;
    private Double balance;
    private String cinClient;

    public Wallet(String reference, LocalDate createdAt, Double balance, String cinClient) {
        this.reference = reference;
        this.createdAt = createdAt;
        this.balance = balance;
        this.cinClient = cinClient;
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", createdAt=" + createdAt +
                ", balance=" + balance +
                ", cinClient='" + cinClient + '\'' +
                '}';
    }
}
