package com.bankly.gatewayservice.controllers;

import com.bankly.gatewayservice.dto.ResponseDto;
import com.bankly.gatewayservice.dto.UserAppDto;
import com.bankly.gatewayservice.entities.UserApp;
import com.bankly.gatewayservice.services.IUserAppService;
import com.bankly.gatewayservice.utiles.DtoToEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserRepository {

    private IUserAppService userAppService;

    public UserRepository(IUserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @GetMapping("/register")
    public ResponseDto register(@RequestBody UserAppDto userAppDto){
        UserApp userApp = DtoToEntity.operationDtoToOperationEntity(userAppDto);
        return userAppService.addUser(userApp);
    }
}
