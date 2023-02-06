package com.bankly.transactionservice.controllers;

import com.bankly.transactionservice.dto.OperationDto;
import com.bankly.transactionservice.dto.ResponseDto;
import com.bankly.transactionservice.entities.Operation;
import com.bankly.transactionservice.services.IOperationService;
import com.bankly.transactionservice.utiles.DtoToEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/operation")
public class OperationController {
    private IOperationService operationService;

    public OperationController(IOperationService operationService) {
        this.operationService = operationService;
    }
    @PostMapping("/add")
    public ResponseDto addOperation(@RequestBody OperationDto operationDto){
        Operation operation = DtoToEntity.operationDtoToOperationEntity(operationDto);
        return operationService.addOperation(operation);
    }

    @GetMapping("/all")
    public ResponseDto findAll(){
        return operationService.findAllOperations();
    }

    @GetMapping("/find_one/id/{id}")
    public ResponseDto findOneOperation(@PathVariable Long id){
        return operationService.findOne(id);
    }
}
