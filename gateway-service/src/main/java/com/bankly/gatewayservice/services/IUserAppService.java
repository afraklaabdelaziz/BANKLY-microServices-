package com.bankly.gatewayservice.services;

import com.bankly.gatewayservice.dto.ResponseDto;
import com.bankly.gatewayservice.entities.UserApp;

public interface IUserAppService {
    public ResponseDto addUser(UserApp user);
    public ResponseDto updateUser(UserApp user);
    public ResponseDto findById(Long idUser);

    public ResponseDto findByEmail(String email);

    public ResponseDto findByphone(String phone);

    public ResponseDto findByCin(String cin);
}
