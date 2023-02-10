package com.bankly.transactionservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document("operation")
public class Operation implements Serializable {
    @Id
    private String id;
    private LocalDate dateTransaction;
    private Double amount;

    private String walletRef;
    private OperationType operationType;

    public Operation(LocalDate dateTransaction, Double amount, String walletRef, OperationType operationType) {
        this.dateTransaction = dateTransaction;
        this.amount = amount;
        this.walletRef = walletRef;
        this.operationType = operationType;
    }

    public Operation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOpperationType(OperationType opperationType) {
        this.operationType = opperationType;
    }


    public String getWalletRef() {
        return walletRef;
    }

    public void setWalletRef(String walletRef) {
        this.walletRef = walletRef;
    }

    @Override
    public String toString() {
        return "Opperation{" +
                "id=" + id +
                ", dateTransaction=" + dateTransaction +
                ", amount=" + amount +
                ", opperationType=" + operationType +
                '}';
    }
}
