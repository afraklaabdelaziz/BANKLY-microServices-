package com.bankly.transactionservice.dto;

import java.io.Serializable;

public class OperationDto implements Serializable {
    private Long id;
    private String operationType;
    private Double amount;

    public OperationDto(String operationType, Double amount) {
        this.operationType = operationType;
        this.amount = amount;
    }

    public OperationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
