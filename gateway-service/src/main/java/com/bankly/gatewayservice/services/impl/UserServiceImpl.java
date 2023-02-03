package com.bankly.gatewayservice.services.impl;

import com.bankly.gatewayservice.dto.ResponseDto;
import com.bankly.gatewayservice.entities.UserApp;
import com.bankly.gatewayservice.repositories.UserAppRepository;
import com.bankly.gatewayservice.services.IUserAppService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserAppService {

    private final UserAppRepository userAppRepository;

    public UserServiceImpl(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    @Override
    public ResponseDto addUser(UserApp user) {
       if (user == null){
           return new ResponseDto("bad request","user is null");
       }else if (user.getCin().equals("")){
           return new ResponseDto("bad request","cin is empty");
       }
       else if (user.getFirstName().equals("")){
           return new ResponseDto("bad request","firstname is empty");
       }
       else if (user.getLastName().equals("")){
           return new ResponseDto("bad request","lastname is empty");
       }
       else if (user.getPassword().equals("")){
           return new ResponseDto("bad request","password is empty");
       }
       else if (user.getPhone().equals("")){
           return new ResponseDto("bad request","phone is empty");
       }
       else if (user.getEmail().equals("")){
           return new ResponseDto("bad request","email is empty");
       }
       else if (this.findByCin(user.getCin()).getData() != null){
           return new ResponseDto("bad request","user with  cin = "+user.getCin()+" already exist");
       }
       else if (this.findByEmail(user.getEmail()).getData() != null){
           return new ResponseDto("bad request","user with  email  "+ user.getEmail() +" already exist");
       }
       else if (this.findByphone(user.getPhone()).getData() != null){
           return new ResponseDto("bad request","user with phone "+ user.getPhone() +" already exist");
       }else {
           userAppRepository.save(user);
           return new ResponseDto("success","user is added",user);
       }
    }

    @Override
    public ResponseDto updateUser(UserApp user) {
        return null;
    }

    @Override
    public ResponseDto findById(Long idUser) {
        return null;
    }

    @Override
    public ResponseDto findByEmail(String email) {
        Optional<UserApp> user = userAppRepository.findByCin(email);
        if (!user.isPresent()){
            return new ResponseDto("bad request","this user not found");
        }else {
            return new ResponseDto("success","user with email "+email,user.get());
        }
    }

    @Override
    public ResponseDto findByphone(String phone) {
        Optional<UserApp> user = userAppRepository.findByCin(phone);
        if (!user.isPresent()){
            return new ResponseDto("bad request","this user not found");
        }else {
            return new ResponseDto("success","user with phone "+phone,user.get());
        }
    }

    @Override
    public ResponseDto findByCin(String cin) {
        Optional<UserApp> user = userAppRepository.findByCin(cin);
        if (!user.isPresent()){
            return new ResponseDto("bad request","this user not found");
        }else {
            return new ResponseDto("success","user with cin "+cin,user.get());
        }
    }
}
