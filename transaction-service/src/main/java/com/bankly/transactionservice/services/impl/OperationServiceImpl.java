package com.bankly.transactionservice.services.impl;

import com.bankly.transactionservice.controllers.WalletProxy;
import com.bankly.transactionservice.dto.ResponseDto;
import com.bankly.transactionservice.dto.WalletDto;
import com.bankly.transactionservice.entities.Operation;
import com.bankly.transactionservice.entities.OperationType;
import com.bankly.transactionservice.repositories.OperationRepository;
import com.bankly.transactionservice.services.IOperationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OperationServiceImpl implements IOperationService {
    private OperationRepository operationRepository;
    private final WalletProxy walletProxy;

    public OperationServiceImpl(OperationRepository operationRepository, WalletProxy walletProxy) {
        this.operationRepository = operationRepository;
        this.walletProxy = walletProxy;
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
            if (operation.getOperationType() == OperationType.DEPOSIT){
                this.deposit(operation.getWalletRef(), operation.getAmount());
            }else {
                operation.setOpperationType(OperationType.WITHDRAW);
                this.withdraw(operation.getWalletRef(), operation.getAmount());
            }
            operation.setDateTransaction(LocalDate.now());
            operationRepository.save(operation);
            return new ResponseDto("success","operation add success",operation);
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
    public ResponseDto findOne(String idOperation) {
        Optional<Operation> operation = operationRepository.findById(idOperation);
        if (!operation.isPresent()){
            return new ResponseDto("bad request","this operation not exist");
        }else {
            return new ResponseDto("success","operation",operation.get());
        }
    }

    @Override
    public ResponseDto deposit(String walletRef,Double amount) {
        WalletDto wallet = walletProxy.findWalletByRef(walletRef);
        if (wallet == null){
            return new ResponseDto("bad request","this wallet not exist");
        }else{
            wallet.setBalance(wallet.getBalance()+amount);
            walletProxy.updateWallet(wallet);
            return new ResponseDto("success","this operation success",wallet);
        }
    }

    @Override
    public ResponseDto withdraw(String walletRef,Double amount) {
        WalletDto wallet = walletProxy.findWalletByRef(walletRef);
        if (wallet == null) {
            return new ResponseDto("bad request","this wallet not exist");
        }else if (wallet.getBalance() < amount){
            return new ResponseDto("bad request","balance is than amount");
        }else {
            wallet.setBalance(wallet.getBalance()-amount);
            walletProxy.updateWallet(wallet);
            return new ResponseDto("success","this operation success",wallet);
        }
    }
}
