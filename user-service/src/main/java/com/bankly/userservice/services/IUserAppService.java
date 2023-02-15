package com.bankly.userservice.services;


import com.bankly.userservice.dto.ResponseDto;
import com.bankly.userservice.entities.UserApp;

public interface IUserAppService {
    ResponseDto addUser(UserApp user);
    ResponseDto updateUser(UserApp user);
    ResponseDto findById(Long idUser);

    ResponseDto findByEmail(String email);

    ResponseDto findByphone(String phone);

    ResponseDto findByCin(String cin);

    UserApp validateToken(String token);

}
