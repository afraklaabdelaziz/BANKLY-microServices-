package com.bankly.transactionservice.services.impl;

import com.bankly.transactionservice.dto.ResponseDto;
import com.bankly.transactionservice.entities.Operation;
import com.bankly.transactionservice.repositories.OperationRepository;
import com.bankly.transactionservice.services.IOperationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OperationServiceImpl implements IOperationService {
    private OperationRepository operationRepository;

    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public ResponseDto addOperation(Operation operation) {

        if (operation == null){
            return new ResponseDto("bad request","operation is null");
        }

        else if (operation.getOperationType() == null){
            return new ResponseDto("bad request","please choose operation type");
        }

        else if (operation.getAmount() == null){
            return new ResponseDto("bad request","please enter amount of transaction");
        }
        else if (operation.getAmount() < 0){
            return new ResponseDto("bad request","amount must be greater than 0");
        }

        else {
            operation.setDateTransaction(LocalDate.now());
            operationRepository.save(operation);
            return new ResponseDto("success","operation add success");
        }
    }

    @Override
    public ResponseDto updateOperation(Operation operation) {
        return null;
    }

    @Override
    public ResponseDto findAllOperations() {
        return new ResponseDto("success","all operation",operationRepository.findAll());
    }

    @Override
    public ResponseDto findOne(Long idOperation) {
        Optional<Operation> operation = operationRepository.findById(idOperation);
        if (!operation.isPresent()){
            return new ResponseDto("bad request","this operation not exist");
        }else {
            return new ResponseDto("success","operation",operation.get());
        }
    }
}
