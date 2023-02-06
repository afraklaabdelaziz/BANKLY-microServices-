package com.bankly.transactionservice.utiles;

import com.bankly.transactionservice.dto.OperationDto;
import com.bankly.transactionservice.entities.Operation;
import org.modelmapper.ModelMapper;

public class DtoToEntity {
    public static Operation operationDtoToOperationEntity(OperationDto operationDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(operationDto, Operation.class);
    }
}
