package com.bankly.gatewayservice.services;

import com.bankly.gatewayservice.dto.ResponseDto;
import com.bankly.gatewayservice.entities.UserApp;

public interface IUserAppService {
    ResponseDto addUser(UserApp user);
    ResponseDto updateUser(UserApp user);
    ResponseDto findById(Long idUser);

    ResponseDto findByEmail(String email);

    ResponseDto findByphone(String phone);

    ResponseDto findByCin(String cin);
}
