package com.bankly.transactionservice.controllers;

import com.bankly.transactionservice.dto.OperationDto;
import com.bankly.transactionservice.dto.ResponseDto;
import com.bankly.transactionservice.dto.WalletDto;
import com.bankly.transactionservice.entities.Operation;
import com.bankly.transactionservice.entities.OperationType;
import com.bankly.transactionservice.services.IOperationService;
import com.bankly.transactionservice.utiles.DtoToEntity;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@EnableFeignClients
@RequestMapping("api/v1/operation")
public class OperationController {
    private IOperationService operationService;
    private final WalletProxy walletProxy;
    public OperationController(IOperationService operationService, WalletProxy walletProxy) {
        this.operationService = operationService;
        this.walletProxy = walletProxy;
    }
    @PostMapping("/add")
    public ResponseDto addOperation(@RequestBody OperationDto operationDto){
        Operation operation = DtoToEntity.operationDtoToOperationEntity(operationDto);

        if (operationDto.getOperationType().equals("DEPOSIT")){
            operation.setOpperationType(OperationType.DEPOSIT);
        }else {
            operation.setOpperationType(OperationType.WITHDRAW);
        }

        return operationService.addOperation(operation);
    }

    @GetMapping("/all")
    public ResponseDto findAll(){
        return operationService.findAllOperations();
    }

    @GetMapping("/find_one/id/{id}")
    public ResponseDto findOneOperation(@PathVariable String  id){
        return operationService.findOne(id);
    }
}
