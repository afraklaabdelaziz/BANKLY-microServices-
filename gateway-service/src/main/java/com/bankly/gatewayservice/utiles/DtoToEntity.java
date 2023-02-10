package com.bankly.gatewayservice.utiles;

import com.bankly.gatewayservice.dto.UserAppDto;
import com.bankly.gatewayservice.entities.UserApp;
import org.modelmapper.ModelMapper;

public class DtoToEntity {
    public static UserApp operationDtoToOperationEntity(UserAppDto userAppDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userAppDto, UserApp.class);
    }
}
