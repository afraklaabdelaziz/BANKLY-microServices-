package com.bankly.userservice.utiles;


import com.bankly.userservice.dto.UserAppDto;
import com.bankly.userservice.entities.UserApp;
import org.modelmapper.ModelMapper;

public class DtoToEntity {
    public static UserApp operationDtoToOperationEntity(UserAppDto userAppDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userAppDto, UserApp.class);
    }
}
