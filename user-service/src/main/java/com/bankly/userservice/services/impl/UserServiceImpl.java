package com.bankly.userservice.services.impl;

import com.bankly.userservice.config.JwtUtile;
import com.bankly.userservice.controllers.WalletProxy;
import com.bankly.userservice.dto.ResponseDto;
import com.bankly.userservice.dto.WalletDto;
import com.bankly.userservice.entities.UserApp;
import com.bankly.userservice.repositories.UserAppRepository;
import com.bankly.userservice.services.IUserAppService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserAppService {

    private final UserAppRepository userAppRepository;

   private final WalletProxy walletProxy;

   private PasswordEncoder passwordEncoder;


    private JwtUtile jwtUtile;


    public UserServiceImpl(UserAppRepository userAppRepository, WalletProxy walletProxy, PasswordEncoder passwordEncoder, JwtUtile jwtUtile) {
        this.userAppRepository = userAppRepository;
        this.walletProxy = walletProxy;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtile = jwtUtile;
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
           WalletDto walletDto = new WalletDto();
           walletDto.setCinClient(user.getCin());
           walletProxy.addWallet(walletDto);
           user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        Optional<UserApp> user = userAppRepository.findByEmail(email);
        if (!user.isPresent()){
            return new ResponseDto("bad request","this user not found");
        }else {
            return new ResponseDto("success","user with email "+email,user.get());
        }
    }

    @Override
    public ResponseDto findByphone(String phone) {
        Optional<UserApp> user = userAppRepository.findByPhone(phone);
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

    @Override
    public UserApp validateToken(String token) {
        final String userEmail = jwtUtile.extractUsername(token);
        UserApp userApp = (UserApp) findByEmail(userEmail).getData();
        if (userEmail.equals(userApp.getEmail()) && !jwtUtile.isTokenExpired(token)) {
            jwtUtile.generateToken(userApp);
            return userApp;
        } else {
            return null;
        }
    }
}
