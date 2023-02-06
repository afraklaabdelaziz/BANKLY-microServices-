package com.bankly.transactionservice.services;

import com.bankly.transactionservice.dto.ResponseDto;
import com.bankly.transactionservice.entities.Operation;

public interface IOperationService {
    public ResponseDto addOperation(Operation operation);
    public ResponseDto updateOperation(Operation operation);
    public ResponseDto findAllOperations();
    public ResponseDto findOne(Long idOperation);
}
