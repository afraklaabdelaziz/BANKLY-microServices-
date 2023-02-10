package com.bankly.transactionservice.services;

import com.bankly.transactionservice.dto.ResponseDto;
import com.bankly.transactionservice.entities.Operation;

public interface IOperationService {
     ResponseDto addOperation(Operation operation);
     ResponseDto updateOperation(Operation operation);
     ResponseDto findAllOperations();
     ResponseDto findOne(String idOperation);
     ResponseDto deposit(String walletRef,Double amount);
     ResponseDto withdraw(String walletRef,Double amount);

}
