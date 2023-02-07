package com.bankly.transactionservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document("operation")
public class Operation implements Serializable {
    @Id
    private String id;
    private String reference;
    private LocalDate dateTransaction;
    private Double amount;
    private OperationType operationType;

    public Operation(String reference, LocalDate dateTransaction, Double amount, OperationType opperationType) {
        this.reference = reference;
        this.dateTransaction = dateTransaction;
        this.amount = amount;
        this.operationType = opperationType;
    }

    public Operation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    @Override
    public String toString() {
        return "Opperation{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", dateTransaction=" + dateTransaction +
                ", amount=" + amount +
                ", opperationType=" + operationType +
                '}';
    }
}
